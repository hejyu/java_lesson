package basic.day1;
/* 패키지?
 * 인터넷 주소 https://developers.kakao.com/  와 같은 형식에서  developers.kakao.com 을 도메인네임이라고 하며 , 
 * 자바의 패키지이름은 보통 이것을 com.kakao.developers 와 같이 높은 단계 부터 표시하여 이름을 정한다.
 * 클래스의 소속 그룹을 표시하는 이름이다. 자바 객체지향프로그램은 클래스 단위로 작성됩니다.
 */
public class A01DataTest {
    
    public static void main(String[] args) {
         //(1) 데이터 저장 
        int m_my_age = 19;
        double m_weight = 57.89123456789;
        boolean m_is_adult;
        char m_grade = 'C';

        //(2) 데이터 값 변경 - 대입문 또는 연산자 활용

        //예, 다이어트 한달 후에 1.3kg 감량된 몸무게
        m_weight = m_weight - 1.3;

        //예, 7년동안 직장생활을 열심히 하면 나이가 몇살이 되나요?
        m_my_age = m_my_age + 7;

        m_is_adult = m_my_age >= 20;

        m_grade = '8';


    }
    /*
    * vs code 단축키 : 
    *   저장 : Ctrl+s , 실행 : F5 , 입력 취소 : Ctrl+z
    *   한줄 복사 : Alt+Shift+위/아래방향키 , 한줄 삭제 :Ctrl+ShiftK+ 
    *   줄바꿈 : Ctrl + Enter , 같은 단어에 대한 다중 커서 : Ctrl+ Shift +L 
    *   변수명 변경 : F2  (파일명,폴더명 등등 모든 이름 변경 F2 와 동일)
    *   자동 완성 : Ctrl+스페이스바 , 라인 이동 : Alt + 위/아래방향키
    *   오류 수정 가이드 보기 : ctrl+ .
    *   왼쪽 액티브바 보이기/숨기기 ctrl + b
    * 
    */
   
}
