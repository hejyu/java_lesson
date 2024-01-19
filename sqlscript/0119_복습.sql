

INSERT INTO TBL_JAVAWORD VALUES(5,'constranst', '제약사항',3);
INSERT INTO TBL_JAVAWORD VALUES(9,'order', '순서',1);


SELECT * FROM  TBL_JAVAWORD;

-- ALT X : 여러개 실행

-- IDX 값이 2,5,9 인 로우 조회
SELECT * FROM TBL_JAVAWORD
WHERE IDX IN(2,5,9); -- IN 연산자: OR 연산을 간단하게 실행


-- IDX 값이 2~5 조회
SELECT * FROM TBL_JAVAWORD  
WHERE IDX BETWEEN 2 AND 5;


-- SELECT 컬럼명1, 컬럼명2 ... FROM 테이블명
-- 			[WHERE 컬럼명 = 값] => 특정 컬럼을 조건식으로 조회
--			[ORDER BY 컬럼명 [DESC]] => 지정된 컬럼명으로 정렬, DESC 는 내림차순 . ASC 오름차순(생략)
-- 										컬럼명1이 같은 값이면 컬럼명2로 정렬됩니다.


-- IDX 값이 2~5 조회
SELECT * FROM TBL_JAVAWORD  
WHERE IDX IN(2,5,9)
ORDER BY IDX;


--INSERT INTO TBL_JAVAWORD VALUES(2,'private', '개인적인',1);


-- IDX 값이 2~5 조회
SELECT * FROM TBL_JAVAWORD  
WHERE IDX IN(2,5,9)
ORDER BY IDX, KOREAN;	-- IDX 1차 정렬 컬럼, KOREAN 2차 정렬 컬럼






