/*
 	SQL 집계 함수(개수, 최댓값, 최솟값, 평균, 합계) 함수
 	- GROUP BY 구문과 많이 사용
 	- 다른 컬럼과 함께 조회하려면 집계함수가 필요합니다
 */

-- 1. 성적 테이블 SCORE 전체 행의 개수
SELECT  COUNT(*) FROM TBL_SCORE;			-- 7
SELECT  COUNT(*) FROM TBL_SCORE WHERE SUBJECT ='국어';  -- 2

-- 2. 집계함수는 다른 컬럼과 함께 결과를 확인하려면 groub by 가 필요
-- SELECT  SUBJECT , COUNT(*)  FROM TBL_SCORE WHERE SUBJECT = '국어';
SELECT  SUBJECT, COUNT(*) 
FROM TBL_SCORE
GROUP BY SUBJECT;

SELECT  SUBJECT, COUNT(*)  
FROM TBL_SCORE
GROUP BY SUBJECT;

SELECT  STUNO,AVG(JUMSU) 
FROM TBL_SCORE
GROUP BY STUNO;

-- 3. 성적 테이블 SUBJECT = '국어' 인 로우
SELECT  COUNT(*) AS "COUNT"
FROM TBL_SCORE
WHERE SUBJECT = '국어';

-- 4. 집계함수(개수, 최댓값, 최솟값, 평균, 합계) 함수
SELECT SUM(jumsu) FROM TBL_SCORE 
WHERE SUBJECT ='국어';

SELECT AVG(jumsu)  FROM TBL_SCORE;

SELECT MAX(jumsu)  FROM TBL_SCORE;

SELECT MIN(jumsu)  FROM TBL_SCORE;

SELECT MIN('홍길동')  FROM dual;






