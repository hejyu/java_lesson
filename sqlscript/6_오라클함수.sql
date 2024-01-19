-- 수업날짜 : 2024-01-19

-- 1. 숫자함수(정수 또는 실수 number를 대상으로 하는 함수)

-- abc(n) : 절댓값

-- trunc(숫자, 자릿수) : 자릿수 맞추기 위해서 버림 3.144 -> 3.1
SELECT  TRUNC(3.144,1) FROM dual; 	-- 3.1

-- round(숫자, 자릿수)  : 반올림
SELECT ROUND(3.17745,2) FROM dual; -- 3.18 반올림

-- ceil(number)	: 올림
SELECT  CEIL(3.155) FROM dual;		-- 4 올림

-- floor(number) : 내림
SELECT  FLOOR(3.155) FROM dual;		-- 3 실수를 정수형, 내림으로 변환 




-- 2. 문자 함수
-- (실제로는 테이블의 컬럼으로 함수를 실행합니다)

-- INITCAP(varchar) : 첫번째 문자를 대문자로
SELECT INITCAP('hello') FROM dual;		-- Hello 

-- UPPER(varchar)
SELECT UPPER('hello') FROM dual;		-- HELLO

SELECT LOWER('OraCle') FROM dual;		-- oracle

SELECT SUBSTR('java program', 3,5) FROM dual; -- va pr 부분 추출(문자열, 위치, 길이) 
											  -- 오라클은 문자열 인덱스 1부터 시작
SELECT SUBSTR('java program',-3,3)  FROM dual;	-- ram 위치가 음수이면 뒤에서부터

SELECT REPLACE('java program', 'pro','프로') FROM dual;	--java 프로gram 문자열 바꾸기

SELECT instr('java program', 'va') FROM dual;	-- 3 자바의 indexOf, 해당문자열이 없으면 결과 0

SELECT TRIM('  java program  ')  FROM dual;  -- java program

SELECT LENGTH(' java program   ') FROM dual;  -- 16 공백포함

SELECT LENGTH('java program') FROM dual;		-- 12

SELECT LENGTH(TRIM(' java program   ')) FROM dual;		-- 공백제거 


-- 3. 날짜 함수 
-- to_char(날짜를 문자열로) 와 to_date(문자열을 날짜형으로)

-- SYSTIMESTAMP 와 차이 : 표준시와의 시차(타임존)까지 출력해줌
SELECT SYSDATE , SYSTIMESTAMP  FROM dual; -- 2024-01-19 10:48:10.000 , 2024-01-19 10:48:10.691 +0900

-- TO_CHAR 
SELECT TO_CHAR(SYSDATE, 'yyyy"년 "mm"월 "dd"일"')  FROM dual;		-- 2024년 01월 19일
-- 날짜 자동캐스팅 패턴
-- yyyy-mm-dd hh24:mi:ss	24시간 기준
-- yyyy-mm-dd hh:mi:ss am	12시간 기준(am 대신에 pm 사용 가능)

-- TBL_MEMBER 테이블에 JOIN_DATE 컬럼  insert
-- 자동 캐스팅 패턴 yyyy-mm-dd만 가능
-- 오류
INSERT INTO TBL_MEMBER VALUES (7,'박나연','na1234@gmail.com',to_date('2021-05-05 13:24:55','yyyy-mm-dd hh24:mi:ss'));

-- **** 문자열을 날짜패턴을 알려주고 날짜형식으로 변경하기 ****
INSERT INTO TBL_MEMBER VALUES (10,'홍길동','gdHong@daum.net',to_date('20240109','yyyymmdd'));

SELECT * FROM TBL_MEMBER;

-- date, number add month 
SELECT ADD_MONTHS(SYSDATE,3) FROM dual;

-- 문자열 패턴 기호 / 구분 없음
SELECT TO_CHAR(ADD_MONTHS(SYSDATE,3),'YYYY/MM/DD') FROM DUAL;

-- 지정된 2개의 날짜 사이 차이(월/단위). 결과는 소수점
SELECT MONTHS_BETWEEN(SYSDATE, TO_DATE('2022-09-23')) FROM DUAL;

-- 날짜끼리 뺄셈 가능 : 2 개의 날짜형식 값 간격(일/단위) 
-- TRUNC(DATE) 는 일(day)까지 보여줌
SELECT TRUNC(SYSDATE) FROM dual;
SELECT TO_DATE('20240110','YYYY-MM-DD') FROM dual;
SELECT TRUNC(SYSDATE) - TO_DATE('20240110','YYYY-MM-DD')  FROM DUAL;

-- 일(DAY) 덧셈 연산 가능 
SELECT TO_CHAR(SYSDATE,'hh24:mi:ss')FROM dual;		-- 11:30:34
SELECT TO_CHAR('15:00:00', 'hh24:mi:ss') - TO_CHAR(SYSDATE,'hh24:mi:ss')   FROM DUAL;
































