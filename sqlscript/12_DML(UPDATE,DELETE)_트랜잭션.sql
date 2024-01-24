/*
 * DML : SELECT, INSERT, UPDATE, DELETE, MERGE
 * 		- 테이블 로우에 대한 조작 언어 
 * 
 *  로우 식별 : 기본키가 필요한 이유입니다
 * */

SELECT * FROM EXBUY;

-- UPDATE 테이블
-- SET 컬럼 = 표현식 , 컬럼 = 표현식
-- WHERE 표현식
-- 예시 : mina012 회원이 구매한 상품 CJBAB12g 수량을 모두 10으로 업데이트
UPDATE EXBUY 
SET AMOUNT  =  10
WHERE CUSTOMER_ID = 'mina012' AND code = 'CJBAb12g';

-- 예시 : buy_idx 1001 인 데이터 수량 5로 변경
UPDATE EXBUY 
SET AMOUNT  =  5
WHERE buy_idx = '1001';
-- WHERE 절 PK 컬럼이 행식별일 때는 반드시 1개의 행 수정만 적용된다
SELECT * FROM EXBUY;

UPDATE EXBUY 
SET AMOUNT = 5;		-- WHERE 표현 없는 SQL 필요시 신중하게 실행

-- DELETE FROM 테이블 WHERE 포현식 : 행전체 삭제
-- 조건식 컬럼이 PK 컬럼(로우 식별)이면 반드시 1개 행만 삭제가 되야 합니다.
DELETE FROM EXBUY WHERE BUY_IDX = 1001;

-- 결론 : 기본키의 필요성과 역할  
-- PK는 응용프로그램을 개발할 때 없으면 기능을 만들 수 없다
-- 행식별을 하여 조회 SELECT, 수정 UPDATE, 삭제 DELETE 행이 결과에 반영된다. 
SELECT * FROM EXBUY;


-- ************************************* 트랜잭션  ************************************* 
-- INSERT, UPDATE, DELETE 에서 반드시 하나 단위로 처리해야 할 작업
-- 		모모가 사나한테 5만원 이체를 하려고 하는데요. 
--		``모모 계좌는 -5만원 그리고 사나 계좌는 +5만원`` 의 동시에 수행하는 작업이 하나의 트랜잭션
-- 트랜잭션 :	UPDATE 2개 모두 "동시에" 실행 또는 2개 모두 "동시에" 실행이 안되게 해야 하는 "작업단위"
-- 자동커밋 : 테이블에 INSET UPDATE DELETE MERGE 가 바로 반영되는 것
-- 수동커밋 : 테이블에 INSERT, UPDATE, DELETE MERGE 가 바로 반영되지 않고, COMMIT 명령으로 수행되는 것
--			트랜잭션 취소는 ROLLBACK

-- SQL PLUS 에서 실행가능 자동커밋 명령어
-- SHOW AUTOCOMMIT;
-- SET AUTOCOMMIT OFF[ON];


-- 디비버에서 수동 커밋 설정하기 : 데이터베이스 메뉴 - 트랜잭션 모드 - Manual Commit 선택
-- ************************************************************************************  

-- ----------------------  트랜잭션1 시작 ----------------------  
-- 1) 현재 트랜잭션 1
INSERT INTO exbuy(customer_id, code, amount, buy_idx) 
VALUES('hongGD','APLE5kg','5', exbuy_pk_seq.nextval);

-- 2) 현재 트랜잭션 2
SELECT * FROM EXBUY ;

-- 수동 커밋 상태에서 sql plus 실행 -> c##idev 계정 접속
-- 디비버에서 사용자가 추가한 insert 는 커밋 해야 sqlplus 사용자에게 보인다.

-- 3) 현재 트랜잭션 3
UPDATE EXBUY 
SET AMOUNT  =  13
WHERE buy_idx = '1021';		

-- 트랜잭션 취소
ROLLBACK;
-- ----------------------  트랜잭션1 종료 ---------------------- 
-- ----------------------  트랜잭션2 시작 ----------------------   
-- 1) 현재 트랜잭션 1
INSERT INTO exbuy(customer_id, code, amount, buy_idx) 
VALUES('hongGD','APLE5kg','1', exbuy_pk_seq.nextval);

-- 2) 현재 트랜잭션 2
SELECT * FROM EXBUY;

-- 수동 커밋 상태에서 sql plus 실행 -> c##idev 계정 접속
-- 디비버에서 사용자가 추가한 insert 는 커밋 해야 sqlplus 사용자에게 보인다.

-- 3) 현재 트랜잭션 3
UPDATE EXBUY 
SET AMOUNT  =  13
WHERE buy_idx = '1022';		

-- 4) 현재 트랜잭션 4
SELECT * FROM EXBUY ;

-- 트랜잭션 취소
ROLLBACK;
-- ----------------------  트랜잭션2 종료 ---------------------- 
-- ----------------------  트랜잭션3 시작 ----------------------   
-- 1) 현재 트랜잭션 1
INSERT INTO exbuy(customer_id, code, amount, buy_idx) 
VALUES('hongGD','APLE5kg','5', exbuy_pk_seq.nextval);

-- 2) 현재 트랜잭션 2
SELECT * FROM EXBUY ;

-- 수동 커밋 상태에서 sql plus 실행 -> c##idev 계정 접속
-- 디비버에서 사용자가 추가한 insert 는 커밋 해야 sqlplus 사용자에게 보인다.

-- 3) 현재 트랜잭션 3
UPDATE EXBUY 
SET AMOUNT  =  13
WHERE buy_idx = '1023';		

-- 4) 현재 트랜잭션 4
SELECT * FROM EXBUY;

-- 트랜잭션 처리완료
COMMIT;
-- ----------------------  트랜잭션3 종료 ----------------------  




































