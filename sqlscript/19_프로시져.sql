/*
PL/SQL : Procedure(절차,순서) Language , 기존의 단순한 SQL이 확장된 언어(SQL로 만드는 프로그램)
         변수,제어문(if,반복문)을 사용하여 프로그래밍언어와 같이 sql 실행의 흐름을 제어
- 구성 : 선언부(DECLARE), 실행부(BEGIN), 예외처리부 (EXCEPTION)로 구성됨
- 유형
	1) Anonymous PL/SQL Block(익명블록) 
	익명 블록은 주로 일회성으로 사용
	2)Stored PL/SQL Block (저장 프로시저)
	서버에 파싱해서 저장해 놓고 주기적으로 반복해서 사용할 경우 사용됨
	서브프로그램 또는 프로그램 단위라고도 하며, 
	스키마를 구성하는 오브젝트로서 파싱된 후 오라클 서버 내부에 저장되거나 오라클 툴 안에 라이브러리 형태로 저장되어 있음

Declare (선언부)
Executable (실행부)
Exception (예외 처리부)
*/
SELECT * FROM TBL_CUSTOM tc ;

SELECT * FROM TBL_BUY;

-- 1) 익명 프로시져 선언
DECLARE   -- 변수선언부  
	-- vname varchar2(40);			 -- 스칼라변수
	-- vage number(3,0);
	vname tbl_custom.name %TYPE;     -- 참조변수(타입변수) : TABLE.COLUMN  %TYPE
	vage tbl_custom.age %TYPE;
BEGIN		--프로시저 시작(실행부)
  -- 프로시저 내부에는 주로 트랜잭션을 구성하는 DML 명령문들을 작성
	SELECT name,age 
		INTO vname , vage	-- 프로시저 구문: 검색결과를 프로시저 일반 변수 vname, vage 에 저장
	FROM "TBL_CUSTOM" tc 
	WHERE CUSTOM_ID ='hongGD';		-- 1개 행만 결과 조회되는 조건
									-- 여러개 행 조회될때는 각 행에 접근하기 위한 cursor 필요.
-- DBMS_OUTPUT 는 콘솔에 출력하는 오라클 패키지의 하나이며 PUT_LINE 함수
	DBMS_OUTPUT.PUT_LINE('고객이름 : ' || vname);   -- ||는 문자열 연결 연산
	DBMS_OUTPUT.PUT_LINE('고객나이 : ' || vage);
	EXCEPTION		-- 예외(오류)처리
	WHEN no_data_found THEN   -- no_data_found : 예외 이름 (fixed name) others : exceptions of All
		DBMS_OUTPUT.PUT_LINE('찾는 데이터가 없습니다.');
END;

/*
	저장 프로시저 생성
	CREATE OR REPLACE PROCEDURE 프로시저 이름
	( 매개변수이름 [IN 또는 OUT] 데이터 타입,.....)	IN : INPUT PARAMETER VARIABLE , OUT: PRINT PARAMETER VARIABLE 
	[IS 또는 AS]
		프로시저 변수 선언
	BEGIN
		프로시저 작업 내용 SQL들....

	EXCEPTION 
		WHEN 예외이름 THEN 처리 내용;

	END ;

*/


-- 2) 저장 프로시져로 변경
-- 인자O, 리턴O 저장프로시저 선언
CREATE OR REPLACE PROCEDURE search_custom(   -- 프로시저 이름 설정
      c_id IN tbl_custom.CUSTOM_ID %TYPE      -- 매개변수(인자) IN 
)
IS 
   vname tbl_custom.name %TYPE;   -- 지정된 테이블의 컬럼과 동일형식의 변수
   vage tbl_custom.age %TYPE;
BEGIN 
   SELECT name,age 
      INTO vname , vage   
   FROM "TBL_CUSTOM" tc 
   WHERE CUSTOM_ID = c_id;      -- 1개 행만 결과 조회되는 조건. 매개변수로 전달된 값으로 조건 실행
   
   DBMS_OUTPUT.PUT_LINE(CHAR(10) || '고객이름 : ' || vname);  
   DBMS_OUTPUT.PUT_LINE('고객나이 : ' || vage);
   EXCEPTION      -- 예외(오류)처리
   WHEN no_data_found THEN   
      DBMS_OUTPUT.PUT_LINE(CHAR(10) || '찾는 데이터가 없습니다.');   
END;   


-- RUN PROCEDURE
BEGIN 
	search_custom('mina012');
END;

EXEC search_custom('hong');


-- 구매 수량이 최대인 고객의 이름, 나이 출력하는 프로시저 : max_custom
CREATE OR REPLACE PROCEDURE max_custom(	  -- METHOD ARGUEMENT (IN JAVA)
   p_name OUT tbl_custom.NAME %TYPE,      -- 출력(리턴) 변수
   p_age OUT tbl_custom.AGE %TYPE
)
IS
   maxval number(5);						-- MAX BUY AMOUNT
   cid tbl_custom.custom_id %TYPE;			-- PRINT RETURN VARIABLE
BEGIN
   SELECT max(quantity)				
      INTO maxval 							-- GENERAL VARIABLE
   FROM tbl_buy; 

   SELECT customid
      INTO cid								-- STORED TO CID ON SELECT RESULT 
   FROM tbl_buy
   WHERE quantity = maxval;

   SELECT name,age 
      INTO p_name , p_age   
   FROM "TBL_CUSTOM" tc 
   WHERE CUSTOM_ID =cid;
   
   DBMS_OUTPUT.PUT_LINE('고객이름 : ' || p_name);  
   DBMS_OUTPUT.PUT_LINE('고객나이 : ' || p_age);
END;


-- RUN PROCEDURE : PARAMETER O 
DECLARE 
	vname tbl_custom.name %TYPE;
	vage tbl_custom.age %TYPE;
BEGIN 
	max_custom(vname, vage);	-- stored return value,  (vname, vage)
	DBMS_OUTPUT.PUT_LINE(CHR(10);
	DBMS_OUTPUT.PUT_LINE('= 고객나이 : ' || vage);
	DBMS_OUTPUT.PUT_LINE('= 고객나이 : ' || vage);


-- 프로시저 복습하기 위한 테이블 p_buy를 생성합니다
-- 		ㄴ tbl_buy 테이블 복사 (PK와 FK는 복사못함)
CREATE TABLE p_buy
AS
SELECT * FROM TBL_BUY tb ;

SELECT * FROM p_buy;

-- 실행을 위해서 시퀀스 생성, money 컬럼(수량*가격으로 총구매금액 컬럼) 추가
CREATE SEQUENCE pbuy_seq START WITH 1500;
ALTER TABLE p_buy ADD money number(7) CHECK (money >=10000);  -- 

/**
 * 웹애플리케이션(인터넷 환경) 개발할 때, JDBC 에서 사용자가 원하는 기능 요청 하나에 sql을 1개씩만 실행을 합니다.
 * => 프로시저를 이용하면 요청 한번에 대해 많은 SQL을 실행을 할수 있습니다.
 * =>JDBC : Java DataBase Connection. 자바와 db(오라클,mysql 등등)를 연결하는 프로토콜(규칙).
 * 
 * 프로시저 사용은
 * 	ㄴ 데이베이스관점에서 `무결성`(정확성) 을 유지할 수 있는 방법.
 * 
 * 프로시저로 트잰잭션을 관리하는 예
 * => 최소구매 금액 10000 미만이면 트랜잭션을 롤백
 */

CREATE OR REPLACE PROCEDURE proc_set_money(	  
	acustom_id IN varchar2, -- 회원ID		-- 입력 매개변수 IN
	apcode IN varchar2, 	-- 상품코드
	acnt IN NUMBER , 		-- 수량
	isSuccess OUT varchar2  -- 출력 매개변수 OUT. 트랜잭션 처리 성공여부 저장.
)
IS 
	vseq NUMBER;	--변수선언
	vprice NUMBER;
BEGIN 
	INSERT INTO p_buy(BUY_IDX,CUSTOMID,PCODE,QUANTITY,BUY_DATE)
		values (pbuy_seq.nextval, acustom_id,apcode,acnt,sysdate);	-- 매개변수값으로 insert
	SELECT pbuy_seq.currval 		-- 방금 insert 한 현재 시퀀스 값 조회
		INTO vseq
		FROM dual;
	dbms_output.put_line('방금 insert 한 현재 시퀀스 값 : ' || vseq);
	SELECT price 
		INTO vprice 
		FROM tbl_product tp WHERE pcode=apcode;		-- 상품코드에 대한 가격 조회
	dbms_output.put_line('방금 insert 한 상품의 가격 : ' || vprice);
	UPDATE p_buy SET money = vprice * QUANTITY 
		WHERE BUY_IDX = vseq;  -- 방금 INSERT 한 데이터로 가격*수량 값 구해서 money 컬럼값 수정
	dbms_output.put_line('실행 성공');		-- 가격*수량 값이 10000원 이상일 때만 성공 
	isSuccess :='success';			-- 프로시저에서 일반변수 대입문 기호 :=
	commit ;
	EXCEPTION 			-- EXCEPTION 추가하여 처리 -> 메시지 출력, rollback 
		WHEN OTHERS THEN 
		dbms_output.put_line('실행 실패');  -- 가격*수량 값이 10000원 미만은 실패
		rollback ;		-- 오류가 발생한 sql 앞의 insert,update,delete를 취소.
		isSuccess :='fail';
END;



-- 실행 예
DECLARE 
	VRESULT varchar2(20);
BEGIN
	-- 메시지는 'fail' 이고 p_buy 테이블 insert 입력값 없어야 합니다.
	--	proc_set_money('twice','SNACK99',1,VRESULT); 
	
	-- 메시지는 'success' 이고 p_buy 테이블에 값이 insert 됩니다.
	proc_set_money('mina012','SNACK99',3,VRESULT); 

	dbms_output.put_line('결과 : ' || VRESULT );
END;
