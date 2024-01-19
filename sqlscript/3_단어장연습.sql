/*
 * -- 기존테이블 삭제
 * DROP TABLE TBL_JAVAWORD;
 * `단어장` 프로그램을 위한 테이블
 * 
 * 0. 테이블명 : tbl_javaword					
 * 1. 테이블 구조								3. TO DO : 컬럼 값들의 규칙( 요구사항 ) => 요구사항에 대한 제약조건
 * 	
 * 		idx 		number(8) PRIMARY KEY,		같은 값을 가질 수 없다(UNIQUE). 반드시 값이 있어야한다.(NOT NULL)
 * 		english		varchar2(100) UNIQUE NOT NULL,				같은 값을 가질 수 없다(UNIQUE). 반드시 값이 있어야한다.(NOT NULL)
 * 		korean		nvarchar2(100)				반드시 값이 있어야한다.(NOT NULL)
 * 		step		number(1)					반드시 값이 없는 null도 가능하다.(NULL) 1~4범위만 허용한다.(CHECK(STEP BEWEEN 1 AND 4))
 * 
 * 		4.TO DO : 검색 속도를 향상시키기 위한 컬럼(반복되는 데이터가 쌓이지 않게함) `데이터 행을 식별`할 수 있는 컬럼을 정해라 (기본키의 사용목적)
 * 				   PRIMARY KEY
 * 2. 테이블에 행 추가 - 데이터 입력하기
 * 
 * *** 오라클의 키워드를 테이블명, 컬럼명으로 사용 불가능
 * */
DROP TABLE TBL_JAVAWORD;

CREATE TABLE TBL_JAVAWORD(
	IDX NUMBER(8)  PRIMARY KEY,			-- UNIQUE 와 NOT NULL
	ENGLISH VARCHAR2(100) UNIQUE NOT NULL,
	KOREAN NVARCHAR2(100) NOT NULL,
	STEP NUMBER(1) CHECK(STEP BETWEEN 1 AND 4)		-- CHECK () 괄호 필수
);

SELECT  IDX , 
		ENGLISH , 
		KOREAN,
		STEP 
FROM TBL_JAVAWORD;

--INSERT INTO TBL_NUMBER VALUES (123456789,12345,12345.67,0.00012);

INSERT INTO TBL_JAVAWORD 
VALUES (1, 'public','공개의','1'); 			-- 성공

INSERT INTO TBL_JAVAWORD 
VALUES (1, 'private','사적인','2'); 			-- SQL Error [1] [23000]: ORA-00001: 무결성 제약 조건(C##IDEV.SYS_C008327)에 위배됩니다

INSERT INTO TBL_JAVAWORD 
VALUES (2, 'public','응용프로그램','2');		-- SQL Error [1] [23000]: ORA-00001: 무결성 제약 조건(C##IDEV.SYS_C008328)에 위배됩니다


INSERT INTO TBL_JAVAWORD 
VALUES (2, 'iterate','반복자',3);

INSERT INTO TBL_JAVAWORD 
VALUES (5, 'object','객체',2);

INSERT INTO TBL_JAVAWORD 
VALUES (6, 'interface','객체','2');

INSERT INTO TBL_JAVAWORD(idx, english, korean) 
VALUES (7, 'remove','삭제하다');		-- 입력하지 않은 컬럼 step 의 값은 null


-- SELECT 컬럼명1, 컬럼명2, ....
-- FROM 테이블명 
-- WHERE 컬럼명 = 값 
-- => 특정 컬럼을 조건식으로 조회
SELECT  IDX , 
		ENGLISH , 
		KOREAN,
		STEP 
FROM TBL_JAVAWORD
WHERE STEP IS NOT NULL;

SELECT  IDX , 
		ENGLISH , 
		KOREAN,
		STEP 
FROM TBL_JAVAWORD
WHERE STEP IS NULL;

SELECT  IDX , 
		ENGLISH , 
		KOREAN,
		STEP 
FROM TBL_JAVAWORD
WHERE STEP = 2;

SELECT  IDX, 
		ENGLISH, 
		KOREAN,
		STEP 
FROM TBL_JAVAWORD
WHERE ENGLISH  = 'public';

SELECT  IDX, 
		ENGLISH, 
		KOREAN,
		STEP 
FROM TBL_JAVAWORD
WHERE ENGLISH  = 'public' 
AND STEP = 2;		-- AND : 논리연산 

SELECT * 
FROM TBL_JAVAWORD 
WHERE ENGLISH LIKE '%sh';		-- sh로 끝나는, %기호는 don't care 

SELECT * 
FROM TBL_JAVAWORD 
WHERE ENGLISH LIKE '%ic%';		-- ic가 들어가는, %기호는 don't care 

SELECT * 
FROM TBL_JAVAWORD 
WHERE IDX BETWEEN 1 AND 20;	-- idx 값이 1~20인 

SELECT * 
FROM TBL_JAVAWORD 
WHERE IDX NOT BETWEEN 10 AND 20;	-- idx 값이 10~20 범위가 아닌것 

SELECT * 
FROM TBL_JAVAWORD 
WHERE ENGLISH < 'public' ;		-- ENGLISH가 public 보다 작은(컬럼에 부등호 사용 가능)
























