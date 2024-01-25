/*
 * 서브 쿼리(sub query) : select 조회 결과가 다른 DML 명령어에 쓰일 수 있습니다
 * 											ㄴ SELECT, INSERT, UPDATE, DELETE
 * 							ㄴ SELECT, INSERT, UPDATE, DELETE 안에 SELECT 를 사용하는 것을 서브쿼리라고 합니다
 * 
 * SELECT 함께 쓰이는 서브쿼리
 * 				: SELECT 컬럼, 컬럼 FROM (SELECT...)
 * 						WHERE 컬럼 = 값(SELECT...)
 * 
 * SELECT 서브쿼리는 JOIN 도 가능하다
 * 
 * */


-- 1) WHERE 에서 쓰는 서브쿼리 

SELECT TP.*
FROM TBL_PRODUCT TP
WHERE PCODE IN				-- 2) 조건식 연산
-- ('JINRMn5','MANGOTK4r')
(SELECT PCODE FROM TBL_BUY WHERE CUSTOMID = 'twice' );		-- 1) 조건식 연산


-- FROM 에서 쓰는 서브쿼리
-- 구매코드의 합계금액
SELECT
	SALE.PCODE, SUM(quantity), SUM("구매금액")
FROM 
	(	SELECT tp.PCODE,
			tp.pname,
			tp.price, 
			tb.quantity, 
			(tb.quantity * tp.price) AS "구매금액"
		FROM  TBL_PRODUCT tp
			, TBL_BUY tb
		WHERE  tp.PCODE  = tb.PCODE
	)  AS SALE
GROUP BY SALE.PCODE
;


SELECT 
    tp.PCODE,
    SUM(tb.QUANTITY) AS Total_Quantity,
    SUM(tp.PRICE * tb.QUANTITY) AS Total_Amount
FROM 
    TBL_PRODUCT tp
JOIN 
    TBL_BUY tb ON tp.PCODE = tb.PCODE
GROUP BY 
    tp.PCODE;

 

SELECT 
    tp.PCODE,
    SUM(tb.QUANTITY) AS Total_Quantity,
    SUM(tp.PRICE * tb.QUANTITY) AS Total_Amount
FROM 
    TBL_PRODUCT tp,
    TBL_BUY tb 
WHERE tp.PCODE = tb.PCODE
GROUP BY 
    tp.PCODE;

   

SELECT 
    tp.PCODE,
    SUM(tb.QUANTITY) AS Total_Quantity,
    SUM(tp.PRICE * tb.QUANTITY) AS Total_Amount
FROM 
    TBL_PRODUCT tp,
    TBL_BUY tb 
WHERE tp.PCODE = tb.PCODE(+)
GROUP BY 
    tp.PCODE
ORDER BY TOTAL_AMOUNT DESC;

   
 -- 회원별로 구매금액이 가장 큰 상품을 찾기
SELECT tb.customid, sum(tp.price * tb.quantity) AS total_quantity
FROM  TBL_PRODUCT tp
  	, TBL_BUY  tb 
WHERE tp.pcode = tb.pcode
GROUP BY tb.customid, tp.pcode
;

SELECT X.pcode, sum(X.P_SUM)
FROM 
	(
		SELECT  
			tb.customid, tp.pcode, sum(tb.quantity * tp.price) AS P_SUM 
		FROM 
			tbl_buy tb, 
			tbl_product tp
		WHERE 
			tp.pcode = tb.pcode
		GROUP BY 
			tb.customid, 
			tp.pcode
	) X
GROUP BY X.pcode	;

-- 오라클 with 구문 : select 조회 결과를 저장해 놓고 사용하도록 합니다
WITH SALEMONEY
AS 
(
	SELECT  tp.PCODE,
			tp.pname,
			tp.price, 
			tb.quantity, 
			(tb.quantity * tp.price) AS "구매금액"
	FROM  TBL_PRODUCT tp
		, TBL_BUY tb
	WHERE  tp.PCODE  = tb.PCODE
)
SELECT  pcode, sum(quantity), sum("구매금액")
FROM SALEMONEY
GROUP BY salemoney.pcode;
   
  

-------------------------------------------------------------------------------------------
-- 서브쿼리와 조인을 이용한 문제를 한 개씩 만들어 팀별로 공유해보세요
-- 조하연 문제 :  진라면을 가장 많이 구매한 회원을 구매금액이 높은 순으로 회원아이디와 총 진라면 구매금액을 보여주세요.
SELECT X.CUSTOMID, X.SUM
FROM 
(
	SELECT tb.customid, tb.quantity, tp.price,  tb.quantity * tp.price  AS sum
	FROM TBL_PRODUCT tp,
		 tbl_buy tb
	WHERE   tp.pcode = tb.pcode
		AND tp.pcode = 'JINRMn5'
) X
ORDER BY SUM DESC
;

-- 한진만 문제 : 팔린 갯수가 가장 많은 순서로 상품(상품코드와 상품이름)을 정렬하고 총 팔린 금액을 출력하시오
SELECT tp.PCODE, tp.PNAME, tb.QUANTITY "팔린 갯수" , tb.QUANTITY  * tp.PRICE  "총 팔린 금액"
FROM TBL_PRODUCT tp
LEFT JOIN TBL_BUY tb ON tb.PCODE = tp.PCODE
WHERE tb.BUY_IDX IS NOT NULL
ORDER BY QUANTITY DESC ;

-- 총 구매금액이 가장 높은 회원 보여주기 

-- 회원별 구매금액 을 구하고 회원으로 그룹바이 해서 구매금액 합계가 큰 순으로 정렬
SELECT X.CUSTOMID, sum(pay_sum) AS total
FROM
	(
		SELECT tb.customid, tp.price * tb.quantity  AS pay_sum
		FROM  TBL_PRODUCT  tp
			, TBL_buy tb
		WHERE tp.pcode = tb.pcode
	) X
GROUP BY X.CUSTOMID
ORDER BY total DESC
;

-- 한주영 문제 : 2023년 구매 금액 5만원 이상인 회원을 보여주세요
SELECT  COUPON.CUSTOMID "고객id",
      SUM(COUPON.TOTAL) "구매 총액"
FROM (
      SELECT
         tb.QUANTITY * tp.PRICE AS TOTAL,
         BUY_DATE,
         tb.CUSTOMID,
         QUANTITY,
         PRICE
      FROM
         TBL_PRODUCT tp,
         TBL_BUY tb
      WHERE
         tp.PCODE = tb.PCODE
         AND TO_CHAR(BUY_DATE,'YYYY')='2023'
   ) COUPON
GROUP BY COUPON.CUSTOMID
HAVING SUM(COUPON.TOTAL) > 50000;


-- 차정호 문제 햇반의 총 매출과 팔린 갯수 산사람의 회원 아이디를 구하세요
SELECT dongwon.CUSTOMID, dongwon.Price1 "가격", dongwon.quantity "개수" 
FROM 
(
   SELECT tb.customid, tb.quantity, tp.price,  tp.price* tb.quantity AS Price1
   FROM TBL_PRODUCT tp,
       tbl_buy tb
   WHERE   tp.pcode = tb.pcode
      AND tp.pcode = 'CJBAb12g'
) dongwon;

---------------------------------------------------------------------------
SELECT * 
FROM TBL_CUSTOM ;

SELECT * FROM tbl_buy;

SELECT * FROM tbl_product;

/**
 * 고객별로 구매금액이 가장 높은 상품코드를 보여주세요
 * ㄴ 오라클 RANK 함수 ( 그룹화 결과에 대한 순위를 제공)
 * 
 * 내림차순 오름차순 정렬된 결과에서 TOP3를 보여주세요
 * 
 */

SELECT A.*
FROM (
	SELECT X.CUSTOMID, 
		 sum(pay_sum) AS total,
		 RANK() OVER(ORDER BY sum(pay_sum) DESC) AS RANK,
		 DENSE_RANK() OVER(ORDER BY sum(pay_sum) DESC) AS DENSE_RANK
	FROM
		(
			SELECT tb.customid, tp.price * tb.quantity  AS pay_sum
			FROM  TBL_PRODUCT  tp
				, TBL_buy tb
			WHERE tp.pcode = tb.pcode
		) X
	
	GROUP BY X.CUSTOMID
	ORDER BY total DESC
) A 
WHERE ROWNUM <= 3
   

   
   
