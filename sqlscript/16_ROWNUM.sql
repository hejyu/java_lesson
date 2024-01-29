/*
 * 		오라클 RWONUM 컬럼 : 오라클이 SELECT 결과에 부여하는 로우(행)번호
 * 						  오라클이 내부적으로 관리를 하기 위한 컬럼
 * */

-- 1) 상품테이블 상품 가격이 높은 순으로 정렬해 조회
SELECT *
FROM TBL_PRODUCT 
ORDER BY PRICE DESC;

-- 2) ROWNUM 컬럼을 출력해봅니다
SELECT ROWNUM, TP.*
FROM TBL_PRODUCT TP 
ORDER BY PRICE DESC;


-- 3) 서브쿼리로 ROWNUM 순서 추가
SELECT ROWNUM, TP.*
FROM (
	SELECT *
	FROM TBL_PRODUCT 
	ORDER BY PRICE DESC
) TP;


-- 4) 위의 결과에 특정 ROWNUM만 보여주기  
SELECT ROWNUM, TP.*
FROM (
	SELECT *
	FROM TBL_PRODUCT 
	ORDER BY PRICE DESC
) TP
--WHERE ROWNUM = 1;				
WHERE ROWNUM IS NOT NULL;		-- 가능한 조건식은 ROWNUM이 1이 포함되는 경우만 가능



-- 5) 중간 일부를 가져오기 위해서 BETWEEN AND 연산 사용. 위 결과에 서브쿼리(TABLE)를 사용
-- 게시판 글목록 페이지 번호에 사용됨
SELECT *
FROM
	(
		SELECT ROWNUM AS R, TP.*		
		FROM (
			SELECT *
			FROM TBL_PRODUCT 
			ORDER BY PRICE DESC
		) TP		
	)
WHERE R BETWEEN 1 AND 10;


-- 6) 오라클 12C 버전부터는 FETCH 명령이 있습니다.	ROWNUM <= 2 와 동일한 결과
SELECT TP.*
FROM TBL_PRODUCT  TP
ORDER BY PRICE DESC 
FETCH FIRST 2 ROWS ONLY;	--TOP 2(N) 가져오기