-- JDBC 프로젝트를 위한 SQL 테스트
-- SQL 테스트하고 자바 프로그래밍 하기

-- 회원 정보 수정 : EMAIL.AGE

-- 회원 탈퇴

-- 회원 가입

SELECT * FROM TBL_CUSTOM tc ;

SELECT * FROM TBL_PRODUCT ;

-- 카테고리로 검색하기
-- 주요 정리 : 컬럼 조회 한 결과는 1개 또는 1개 이상에 따라 리턴 형식을 결정 하다 (List or Not List)
-- 1) 어떤 카테고리가 있는지
SELECT DISTINCT CATEGORY FROM TBL_PRODUCT tp;		-- 중복된 값은 한번만(중복 제거)


-- 상품 검색하기 SQL : ProductVO, TblProductDao 만들기
--									ㄴ selectByCategory, selectByPname 메서드 만들기
-- 2) 특정 카테고리에 대해 상품 목록 보여주기 
SELECT * 
FROM TBL_PRODUCT tp 		-- 조회 결과는 1 OR N 개
WHERE CATEGORY = 'B1'
ORDER BY PNAME;


-- 데이터 추가 
--INSERT INTO TBL_PRODUCT 
--		VALUES ('BUSA211','B2','부사 사과 3kg 박스', 25000);
		
-- 3) 상품명 유사(like) 검색 
SELECT * FROM TBL_PRODUCT tp 
WHERE PNAME LIKE '%' || '사과' || '%';


	
-- MyPage 기능의 메소드를 위한 SQL
-- mina012가 구매한 구매 목록
-- selectCustomBuyList => TblBuyDao 에 만드세요 
--							ㄴ 아래 조회된 행들에 대해 컬럼과 매핑되는 CustomBuyVO 를 만들어야 합니다.
SELECT buy_idx, tb.pcode, pname, price, quantity, buy_date 
FROM TBL_BUY tb 
JOIN TBL_PRODUCT tp 
ON tb.PCODE  = tp.PCODE 
WHERE tb.CUSTOMID = 'mina012'
ORDER BY BUY_DATE desc
;		-- 'mina012'는 매개변수 입니다.

SELECT * FROM TBL_PRODUCT tp \n
WHERE pname LIKE '%' ||  ?  +  || '%' 
;



	
	
	
	