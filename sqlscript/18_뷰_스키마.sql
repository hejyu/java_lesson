/**
* 스키마 : 	데이터베이스에서 자료의 구조, 자료의 표현 방법, 자료 간의 관계를 형식 언어로 정의한 구조
* 			자료 간의 관계를 `형식 언어로 정의한 구조`이다
* 			ㄴ 풀이 : 사용자가 계정을 받아서 여러가지 방법으로 데이터(자료)를 저장하고 관리하는 공간
* 					오라클 등 dbms 는 스키마에 여러 객체를 생성하여 사용합니다
* View (뷰) : 가상 테이블
* 					ㄴ select 결과를 미리 컴파일해서 오라클 객체로 저장
* 					ㄴ select 결과를 테이블처럼 사용, insert, update, delete, merge 는 제약이 많고 잘 사용되지 않음.
* create view : 권한이 별도로 필요합니다 		=> 관리자 계정 sys or system 
* 
* 
*  비즈니스 로직 처리 쿼리는 조인 및 서브쿼리 횟수가 많아집니다
*		 => 자주 사용하면서 일회용으로 처리가 되면 성능 비효율 발생
*		 => 해결방법 중 하나로 가상테이블(뷰) 또는 프로시져(트랜잭션 작업단위) 를 사용합니다 
*/

--  grant create view to c##idev; 
CREATE OR REPLACE VIEW V_CUSTOMSALE
AS
	SELECT	  
			tb.CUSTOMID 
			, tb.pcode
			, SUM(tp.price * tb.quantity) AS sum
			, RANK() 
					over(PARTITION BY tb.customid
						 ORDER BY sum(tp.price * tb.quantity) DESC) AS RANK	-- OVER () 안에는 순위를 매기기 위해 어떤 컬럼으로 정렬 할지를 작성 
	FROM 
		TBL_BUY tb, 
		TBL_PRODUCT tp
	WHERE tb.pcode = tp.pcode
	GROUP BY tb.customid, tb.pcode;
	

-- 예시
SELECT *
FROM V_CUSTOMSALE vc
WHERE rank  = '1';


