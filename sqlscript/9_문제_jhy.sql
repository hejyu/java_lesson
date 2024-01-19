-- 2024-01-19 9_문제
DROP TABLE exbuy;
DROP TABLE exproduct;
DROP TABLE excustomer;

--고객(회원)
CREATE TABLE excustomer(	
	customer_id  varchar2(100),
	name varchar2(50) NOT NULL,					-- NULL 허용
	email varchar(50) UNIQUE,
	age NUMBER, 	-- NULL 허용
	enter_dttm DATE default sysdate NOT NULL,
	PRIMARY KEY(customer_id)
);
-- 샘플데이터 
INSERT INTO excustomer(customer_id,name,email,age,enter_dttm)
VALUES ('mina012','김미나','kimm@gmail.com88',20,TO_DATE('2022-03-10 14:23:25','yyyy-mm-dd hh24:mi:ss'));
INSERT INTO excustomer(customer_id,name,email,age,enter_dttm)
VALUES ('hongGD','홍길동','gil@korea.com',32,TO_DATE('2021-10-21 11:12:23','yyyy-mm-dd hh24:mi:ss'));
INSERT INTO excustomer(customer_id,name,email,age,enter_dttm)
VALUES ('twice','박모모','momo@daum.net',29,TO_DATE('2021-12-25 19:23:45','yyyy-mm-dd hh24:mi:ss'));
INSERT INTO excustomer(customer_id,name,email,age,enter_dttm)
VALUES ('wonder','이나나','lee@naver.com',40,sysdate);
-- 확인
SELECT * FROM excustomer;

--상품
CREATE TABLE exproduct(	
	code varchar2(100),
	category varchar2(50) NOT NULL,	
	name varchar(50) NOT NULL,
	price NUMBER NOT NULL,
	PRIMARY KEY(code)
);
-- 샘플데이터 
INSERT INTO exproduct(code,category,name,price)
VALUES ('DOWON123a','B2','동원참치선물세트',54000);
INSERT INTO exproduct(code,category,name,price)
VALUES ('CJBAb12g','B1','햇반 12개입',14500);
INSERT INTO exproduct(code,category,name,price)
VALUES ('JINRMn5','B1','진라면 5개입',6350);
INSERT INTO exproduct(code,category,name,price)
VALUES ('APLE5kg','A1','청송사과 5kg',66000);
INSERT INTO exproduct(code,category,name,price)
VALUES ('MANGOTK4r','A2','애플망고 1kg',32000);
-- 확인
SELECT * FROM exproduct;

--구매
CREATE TABLE exbuy(	
	customer_id  varchar2(100),
	code varchar2(100),	
	amount  NUMBER NOT NULL,
	buy_dttm  DATE  default sysdate NOT NULL,
	FOREIGN KEY
			(customer_id) 			
	REFERENCES 
			excustomer(customer_id),
	FOREIGN KEY
			(code) 			
	REFERENCES 
			exproduct(code)  
);
-- 샘플데이터 
INSERT INTO exbuy(customer_id, code, amount, buy_dttm)
VALUES ('mina012','CJBAb12g','5',TO_DATE('2022-03-10 14:33:15','yyyy-mm-dd hh24:mi:ss'));
INSERT INTO exbuy(customer_id, code, amount, buy_dttm)
VALUES ('mina012','APLE5kg','2',TO_DATE('2022-03-10 14:33:15','yyyy-mm-dd hh24:mi:ss'));
INSERT INTO exbuy(customer_id, code, amount, buy_dttm)
VALUES ('mina012','JINRMn5','2',TO_DATE('2022-04-16 10:13:15','yyyy-mm-dd hh24:mi:ss'));
INSERT INTO exbuy(customer_id, code, amount, buy_dttm)
VALUES ('twice','JINRMn5','3',TO_DATE('2021-12-25 19:32:15','yyyy-mm-dd hh24:mi:ss'));
INSERT INTO exbuy(customer_id, code, amount, buy_dttm)
VALUES ('twice','MANGOTK4r','2',TO_DATE('2021-12-25 19:32:15','yyyy-mm-dd hh24:mi:ss'));
INSERT INTO exbuy(customer_id, code, amount, buy_dttm)
VALUES ('hongGD','DOWON123a','1',TO_DATE('2021-10-21 11:13:25','yyyy-mm-dd hh24:mi:ss'));
INSERT INTO exbuy(customer_id, code, amount, buy_dttm)
VALUES ('hongGD','APLE5kg','1',TO_DATE('2021-10-21 11:13:25','yyyy-mm-dd hh24:mi:ss'));
-- 확인
SELECT * FROM exbuy;


-- 조하연 : ID가 'mina012' 인 회원의 가입날짜부터 현재까지 며칠이 지났는지 출력하시오. 
SELECT TO_DATE(SYSDATE,'YYYY-MM-DD') - TO_DATE(enter_dttm,'YYYY-MM-DD')
FROM excustomer 
WHERE customer_id = 'mina012';

-- 한진만 : twice ID를 사용하는 고객이 구매한 상품을 모두 구하시오
SELECT customer_id, code, amount, buy_dttm 
FROM exbuy 
WHERE customer_id = 'twice';


-- 한주영 : 고객이 가장 많이 구매한 상품을 구하시오(판매 갯수로 내림차순)
SELECT code, 
	   SUM(amount) AS 판매수량 
FROM exbuy
GROUP BY code 
ORDER BY 판매수량 DESC;

-- 황병훈 : 카테고리별로 상품갯수 구하기 (앞에 카테코리 번호 나와야 됨)
SELECT category,COUNT(*) 
FROM exproduct 
GROUP BY category;

-- 조지수 :이름 내림차순 정렬하기
SELECT * 
FROM excustomer
ORDER BY NAME DESC;

-- 차정호 : 위 표를 보고 구글 이메일 유저를 구하세요
SELECT * 
FROM excustomer 
WHERE email LIKE '%gmail%';

-- 연습문제
-- '2022년 7월'부터 현재날짜 사이에 가입하지 않는 사원의 이름과 이메일을 출력하시오.
SELECT customer_id, email
FROM excustomer
WHERE enter_dttm NOT BETWEEN TO_DATE('2022-07-01','yyyy-mm-dd') AND SYSDATE;


-- 가입한지 6개월이 안된 회원의 수를 출력하시오
SELECT  sum(count(*))
FROM excustomer
WHERE enter_dttm >= (sysdate  - INTERVAL '6' MONTH)
GROUP BY customer_id;





