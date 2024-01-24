/*
 * 시퀀스 : 오라클의 객체. 정수 값을 자동으로 만들어줍니다.
 * 			일련번호로 사용하는 값에 사용
 * 			행을 식별하는 목적으로 사용
 * 			MySQL에서는 AUTO INCREMENT 속성으로 사용
 *			
 **/


-- 1 시퀀스 생성하기
CREATE SEQUENCE test_seq;

-- 2. 시퀀스 사용을 위한 함수 
--		nextval(다음 시퀀스 값) currval(현재 시퀀스 값)
-- 		** 현재시퀀스값은 NEXTVAL 을 처음 한번 꼭 실행한 후에 (값이 만들어진 후) 실행 가능 
--SELECT TEST_SEQ.CURRVAL FROM DUAL;
SELECT TEST_SEQ.NEXTVAL FROM DUAL;

-- 3. 시작값 변경하기
CREATE SEQUENCE TEST_SEQ2 START WITH 2001;
SELECT  TEST_SEQ2.CURRVAL FROM DUAL;

-- 4. 증가값 변경하기
CREATE  SEQUENCE TEST_SEQ3 INCREMENT BY 5;
SELECT TEST_SEQ3.NEXTVAL FROM DUAL;