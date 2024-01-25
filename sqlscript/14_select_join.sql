/*
 * 	테이블 조인 : 테이블 컬럼(필드) 을 합하는 연산
 * 				ㄴ ref) union 연산이 있는데 테이블의 로우(행)을 합하는 연산
 */

-- step 1 : from 뒤에 2개의 테이블 나열
SELECT *
FROM TBL_CUSTOM tc, TBL_BUY tb;

SELECT *
FROM TBL_CUSTOM tc;

SELECT *
FROM TBL_BUY tb;
-- 결과 : 2개 테이블 공통 컬럼인 customer_id 로 모든 경우의 수를 조합해 합칩니다 CROSS JOIN

-- step 2 : ** EQUAL JOIN 동등조인 고객 ID가 같은 의미가 있는 데이터를 보여줍니다.
SELECT *
FROM 	TBL_CUSTOM tc
		, TBL_BUY tb
WHERE tc.CUSTOM_ID  = tb.customId;
--  ** 고객 중 구매를 한번도 하지 않은 고객은 구매 테이블에 출력되지 않습니다

-- step 3 : 위 2 단계로 만든 예시
-- 1) 2024년에 상품을 구매한 고객의 이메일을 모두 조회하세요
SELECT customId, email, tb.buy_date
FROM 	TBL_CUSTOM tc
		, TBL_BUY tb
WHERE  tc.CUSTOM_ID  = tb.customId
AND TO_CHAR(buy_date, 'yyyy') = '2024';


-- 2) 회원 twice 가 구매한 상품명과 가격을 출력하세요
SELECT *
FROM  TBL_PRODUCT tp;

SELECT *
FROM  TBL_BUY tb;

SELECT 	tp.pname,
		tp.price, 
		tb.quantity, 
		(tb.quantity * tp.price) AS "구매금액"
FROM  TBL_PRODUCT tp
	, TBL_BUY tb
WHERE  tp.PCODE  = tb.PCODE
AND tb.customId = 'twice';


-- 3) 년도별 회원의 총 구매금액을 출력하세요
--  + ( 이벤트 ) 진라면을 구매한 고객의 이름을 출력
--  + B1 카테고리 상품의 구매현황(상품명, 가격, 수량, 구매일)을 출력
SELECT   TO_CHAR(TB.BUY_DATE, 'yyyy')  AS YEAR,
		 TB.CUSTOMID, 	
		 SUM(TB.quantity * TP.price) AS "총구매금액"
FROM  TBL_PRODUCT TP
	, TBL_BUY TB
WHERE TP.PCODE  = TB.PCODE
GROUP BY TO_CHAR(TB.BUY_DATE, 'yyyy') , TB.CUSTOMID
ORDER BY YEAR DESC;

SELECT tp.pname, tp.price, tb.quentity, tb.buy_date
FROM TBL_PRODUCT tp, tbl_buy tb
WHERE tp.pcode = tb.pcode
AND tp.category = 'B1';


-- 동등 조인 형식 	1) SELECT * FROM 테이블 T1, 테이블 T2 WHERE T1.공통컬럼 =  T2.공통컬럼
--				2) SELECT * FROM 테이블 T1 JOIN 테이블 T2 ON T1.공통컬럼 = T2.공통컬럼

SELECT * 
FROM TBL_PRODUCT TP
JOIN TBL_BUY TB
ON TP.PCODE = TB.PCODE;


-- 외부조인 
--	SELECT *
--	FROM 테이블 T1
--	LEFT[OUTER] JOIN TABLE T2
--	ON T1.공통컬럼 = T2.공통컬럼;
--  ㄴ 테이블2에 없는 값도 테이블1에 있으면 조인에 포함시킵니다
--				ㄴ 테이블2에 해당하는 컬럼값은 NULL입니다

-- 구매이력이 없는 회원 출력하기 

SELECT *
FROM TBL_CUSTOM TC	
LEFT JOIN TBL_BUY TB
ON TC.CUSTOM_ID = TB.CUSTOMID;

SELECT *
FROM TBL_CUSTOM; 

SELECT *
FROM TBL_BUY; 


-- 외부 조인 : 1번째 형식
SELECT CUSTOM_ID, NAME, EMAIL, AGE
FROM TBL_CUSTOM TC	
LEFT JOIN TBL_BUY TB
	ON TC.CUSTOM_ID = TB.CUSTOMID 	-- 조인 조건식
WHERE TB.CUSTOMID IS NULL;			-- 그외 조건식

-- 외부 조인 : 2번째 형식
SELECT CUSTOM_ID, NAME, EMAIL, AGE
FROM  TBL_CUSTOM TC	
	, TBL_BUY TB
WHERE 	TC.CUSTOM_ID= TB.CUSTOMID(+) 
	AND TB.CUSTOMID IS NULL;


INSERT INTO TBL_PRODUCT (pcode, category, pname, price)
VALUES ('SNACK99', 'C1', '새우깡번들' ,'5500');


-- 형식3: 오라클에서만 사용하는 조인 형식 (외부 OUTER 조인)
-- 구매 이력이 없는 상품(이름, 가격) 출력
SELECT TP.*
FROM TBL_PRODUCT TP, TBL_BUY TB
WHERE TP.PCODE = TB.PCODE(+);		-- NULL 값이 들어가는 테이블 컬럼에 + 표시

SELECT TP.*
FROM TBL_PRODUCT TP, TBL_BUY TB
WHERE TP.PCODE = TB.PCODE(+);	





















