/*
 * 수업 날짜 1월 18 ~ 19일
 * 4. 제약조건 Constraint (NULL, UNIQUE, CHECK, PRIMARY KEY)
 * 1) 반드시 값이 있어야한다.	NULL 허용안함.
 * 2) 같은 값을 가질수 없다.	UNIQUE (유일한)		* 무결성 : 데이터 정확성 유지
 * 3) 1~4 범위만 가진다.		CHECK
 *------------------------------- 
 * 4) 기본키 : 테이블의 행을 구별(식별) where 기본키컬럼 = 값; 조건실행 했을 때 1개의 행을 조회
 * 				자동으로 인덱스(색인)로 생성해줍니다. 인덱스는 검색(조회) 속도를 향상시키는 방법입니다.
 * 		특징 : NOT NULL, UNIQUE (2가지 제약조건)
 * 		기본키는 테이블에서 1개만 가능.
 * 		단, 기본키를 구성하는 컬럼은 1개 이상(2개,3개...) 가능합니다. 
 * 5) 외래키 : 테이블 간 참조를 위해서 사용됩니다.
 * 			 외래키는 테이블에서 여러개 만들어질 수 있습니다.
 * */

-- 제약조건 컬럼레벨 설정하기 
CREATE TABLE tbl_constr(	
	aname varchar2(20) NOT NULL,
	bname varchar2(20) UNIQUE,					-- NULL 허용
	cno number(4) NOT NULL UNIQUE,
	dno number(4) CHECK(dno BETWEEN 1 AND 4)	-- NULL 허용
	-- eno	number(4)				-- 데이터타입에 맞는 모든 값 허용
);


INSERT INTO tbl_constr(aname, cno) VALUES ('apple',3);	-- 필수 입력 컬럼



INSERT INTO tbl_constr(aname, cno) VALUES ('apple',3);	-- 필수 입력 컬럼
-- 1) 입력 오류 발생하는 경우: UNIQUE 위반 , 무결성 제약조건
--INSERT INTO TBL_CONSTR (aname, bname, cno) VALUES('apple','banana',3);	-- cno 컬럼값 중복
--INSERT INTO TBL_CONSTR (aname, bname, cno) VALUES('apple','banana',4);	

--INSERT INTO tbl_constr(aname, bname, cno) VALUES ('apple', 'banana',5);		-- bname 컬럼값 중복 


-- 2) 입력 오류 발생하는 경우: not null 위반
--INSERT INTO tbl_constr(cno) VALUES (3);
--INSERT INTO tbl_constr(cno) VALUES ('  ');	

-- 3) 입력 오류 발생하는 경우 : check 위반
INSERT INTO tbl_constr(aname,cno,dno) VALUES ('apple',7,3);
--INSERT INTO tbl_constr(aname,cno,dno) VALUES ('apple',8,5);




SELECT  * FROM TBL_CONSTR;