/*
 * 	프로시져 직접 만들어보기 : money_of_day
 * 	매개변수 IN : 고객ID, 날짜(패턴은 'yyyy-mm-dd')
 *  매개변수 OUT : IN 으로 받은 값들을 tbl_buy에서 상품코드를 조회하여 '총 구매 금액'을 구합니다
 * 	*주의 : 매개 변수 선언에 varchar2 또는 number 만 씁니다
 * 	프로시저 실행
 * 	
 * 	DECLARE
 * 		vmoney number(8);
 * 		vid varchar2(20);
 * 		vdate varchar2(20);
 *  BEGIN
 * 		vid := 'mina012';
 * 		vdate := '2023-11-10';
 * 		moeny_of_date(vid,vdate,vmoney);
 * 		money_of_day('mina012','2023-11-10', vmoney);
 * 		dbms_output.put_line(chr(10) || '고객아이디 : ' || vid || ' 날짜: ' || vdate) ;
 * 		dbms_output.put_line('고객님 구매금액은 ' || vmoney || ' 입니다');
 * 
 */
--INSERT INTO TBL_BUY 
--VALUES (buy_pk_seq.nextval, 'mina012' , 'CJBAb12g' , 20,to_date('2023-11-10 14:33:15','yyyy-mm-dd hh24:mi:ss'));
--DELETE FROM TBL_BUY WHERE BUY_IDX = 1008;



SELECT PCODE, QUANTITY 
FROM TBL_BUY 
WHERE CUSTOMID = 'mina012'
	  AND TO_CHAR(BUY_DATE,'yyyy-mm-dd') = '2023-11-10';
	 
SELECT *
FROM TBL_BUY tp 
WHERE PCODE IN('APLE5kg');

SELECT tb.QUANTITY * tp.price AS sum 
FROM TBL_BUY tb,
	 TBL_PRODUCT tp 
WHERE tb.pcode = tp.pcode 
	  AND tb.customid = 'mina012'
	  AND TO_CHAR(tb.BUY_DATE,'yyyy-mm-dd') = TO_CHAR(TO_DATE('2023-11-10','yyyy-mm-dd'),'yyyy-mm-dd');
--	  AND tb.pcode IN('APLE5kg')


SELECT PCODE
FROM TBL_BUY 
WHERE CUSTOMID = 'mina012'
      AND TO_CHAR(BUY_DATE,'yyyy-mm-dd') = '2023-11-10';

     
-- 총 구매금액(day) 계산
SELECT 
	(SELECT PRICE FROM TBL_PRODUCT WHERE PCODE = 'APLE5kg') * 2
FROM dual;
          
     
CREATE OR REPLACE PROCEDURE "C##IDEV".money_of_day(
   p_id IN tbl_custom.custom_id %TYPE,      -- 출력(리턴) 변수
   p_date IN varchar2,      				-- 출력(리턴) 변수
   p_money OUT NUMBER
)
IS
   v_pcode TBL_BUY.PCODE %TYPE;
   v_quantity TBL_BUY.QUANTITY %TYPE;
   v_price TBL_PRODUCT.PRICE %TYPE;
BEGIN
   SELECT PCODE, QUANTITY
      INTO v_pcode , v_quantity  
   FROM TBL_BUY
   WHERE CUSTOMID = p_id AND to_char(buy_date,'yyyy-mm-dd') = p_date;
   
   DBMS_OUTPUT.PUT_LINE('* p : ' || v_pcode || v_quantity );
  
   SELECT PRICE
      INTO v_price
   FROM TBL_PRODUCT
   WHERE PCODE = v_pcode;
  
   DBMS_OUTPUT.PUT_LINE('* p : ' || v_price);
  
   SELECT v_quantity * v_price
      INTO p_money
   FROM dual;
  
   DBMS_OUTPUT.PUT_LINE('* m : ' || p_money);
  
   EXCEPTION
   WHEN no_data_found then
   DBMS_OUTPUT.PUT_LINE('조건에 맞는 데이터가 없습니다.');
END;

-- 프로시저 실행
   DECLARE
        vmoney number(8);         -- 일반변수 선언할때에는 () 에 크기 필요
        vid varchar2(20);
        vdate varchar2(20);
   BEGIN
      vid :='mina012';
      vdate := '2023-11-10';
      money_of_day(vid,vdate,vmoney);
      dbms_output.put_line(CHR(10) || '고객ID : ' || vid || ' 날짜: ' || vdate);
      dbms_output.put_line('고객님의 구매금액은 ' || vmoney || ' 입니다.'); 
    END;   	  