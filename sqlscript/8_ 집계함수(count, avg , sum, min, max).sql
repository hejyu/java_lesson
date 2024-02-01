/*
 	SQL 집계 함수(개수, 최댓값, 최솟값, 평균, 합계) 함수 - 그룹함수
 				ㄴ GROUP BY 구문과 많이 사용
 				ㄴ 다른 컬럼과 함께 조회하려면 집계함수가 필요합니다
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

SELECT  STUNO, AVG(JUMSU) 
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


/*
 * 집계함수 count, avg , sum, min, max 등 그룹 함수라고도 합니다. 
 * 그룹화 - 지정한 컬럼값이 같을 것을 갖는 행에 대해 집계 함수를 실행합니다.
 *      
 * 
 * SELECT 
 *       그룹화컬럼, 그룹함수
 * FROM 테이블이름
 * [WHERE] 그룹화하기 이전의 조건식
 * GROUP BY 그룹화에 사용할 컬럼명
 * [HAVING] 그룹화 후에 사용하는 조건식
 * [ORDER BY] 정렬 컬럼
 */

--************************** Example ************************** 
-- 예시1 : 학번(학생)별로 수강한 과목 수와 평균을 구해보세요
SELECT STUNO, COUNT(*), avg(jumsu)
FROM TBL_SCORE
GROUP BY STUNO;

-- 예시2 : 위의 결과에 대해 평균이 80점 미만인 학생을 출력하세요
SELECT STUNO, COUNT(*), avg(jumsu)
FROM TBL_SCORE
GROUP BY STUNO
HAVING avg(JUMSU) < 80;		-- HAVING 절 : 집계함수 결과에 대한 조건입니다

-- 예시3 :  예를 들어, "점수가 80점 이상 데이터만" 예시1번을 수행하도록 한다면 WHERE JUMSU >= 80 GROUP BY STUNO
SELECT STUNO, COUNT(*), avg(jumsu) AS AVG
FROM TBL_SCORE
WHERE JUMSU >= 80	-- GROUP BY 수행 전에 수행할 조건입니다
GROUP BY STUNO;

-- 예시4 : 위 예시 1	번의 결과를 평균 내림차순으로 출력하세요
SELECT STUNO, COUNT(*) "과목 수", avg(jumsu) AS "학생별 평균"
FROM TBL_SCORE
GROUP BY STUNO
ORDER BY "학생별 평균" DESC;


-- 예시 5 : 학기 교사별 학생 수 COUNT, 학생의 평균AVG 조회하기 
SELECT TERM , TEACHER , COUNT(*) "학생수", AVG(JUMSU) "학생평균"  
FROM TBL_SCORE 
GROUP BY TERM, TEACHER;		-- 1차 학기별 그룹, 2차 선생님별로 그룹화 





--************************** Example ************************** 




































