/*
 * 	오라클 RANK 함수
 * 	예제 : 고객 - 상품별 최대구매금액과 해당 상품코드를 보여주기
 * 		ㄴ 고객ID 로 1차 그룹화, 고객 내에서 상품코드로 2차 그룹화
 * */


-- 1) GROUP BY
SELECT 	TB.CUSTOMID, 
		TB.PCODE,
		SUM(TP.PRICE * TB.QUANTITY) AS SUM -- 가격 수량에 대한 그룹화 함수 SUM 실행
FROM 
		TBL_BUY TB, TBL_PRODUCT TP
WHERE 	
		TB.PCODE = TP.PCODE 
GROUP BY 
		TB.CUSTOMID, TB.PCODE;
		
	
INSERT INTO TBL_BUY  VALUES (BUY_PK_SEQ.NEXTVAL, 'mina012', 'JINRMn5', 13, '2024-01-26');


SELECT *
FROM TBL_BUY;


-- 1)
SELECT tb.CUSTOMID , tb.pcode,
		sum(tp.price * tb.quantity) 
FROM 
	TBL_BUY tb, 
	TBL_PRODUCT tp
WHERE tb.pcode = tp.pcode
GROUP BY tb.customid, tb.pcode;


-- 2) 정렬 
SELECT tb.CUSTOMID, tb.pcode,
		sum(tp.price * tb.quantity) AS pay_sum
FROM 
	TBL_BUY tb, 
	TBL_PRODUCT tp
WHERE tb.pcode = tp.pcode
GROUP BY tb.customid, tb.pcode
ORDER BY 
	tb.CUSTOMID, pay_sum desc;
	
	

-- 3) 위 결과에 rank 함수를 사용해 순위를 보여주세요
SELECT	  tb.CUSTOMID 
		, tb.pcode
		, sum(tp.price * tb.quantity) 
		, RANK() 
				over(PARTITION BY tb.customid
					ORDER BY sum(tp.price * tb.quantity) DESC) AS RANK	-- OVER () 안에는 순위를 매기기 위해 어떤 컬럼으로 정렬 할지 사용 
FROM 
	TBL_BUY tb, 
	TBL_PRODUCT tp
WHERE tb.pcode = tp.pcode
GROUP BY tb.customid, tb.pcode;
	
-- 4) 위 결과에 서브쿼리를 사용해 rank = 1 인 조건을 보여주세요
WITH customSale
AS 
(
	SELECT	  tb.CUSTOMID 
			, tb.pcode
			, SUM(tp.price * tb.quantity) 
			, RANK() 
					over(PARTITION BY tb.customid
						 ORDER BY sum(tp.price * tb.quantity) DESC) AS RANK	-- OVER () 안에는 순위를 매기기 위해 어떤 컬럼으로 정렬 할지 사용 
	FROM 
		TBL_BUY tb, 
		TBL_PRODUCT tp
	WHERE tb.pcode = tp.pcode
	GROUP BY tb.customid, tb.pcode
 )
SELECT  *
FROM customSale
WHERE customSale.RANK = 1
;