package basic.day2;

public class A10StringVariable {
    public static void main(String[] args){

        try {
            // String 은 문자열 : 문자('')의 집합, 문자열음 기호 ""를 사용합니다.
    
            //char m_imo_chr ='😊';   // char 2바이트 이모지는 4바이트. 문자형으로 저장 안됨.
            String m_imo = "😊";     // 이모지는 문자열로 저장합니다.
            String m_message = "Hello 안녕 하이하이";

            System.out.println(m_message + "/" + m_message.length());
    
            // String 변수는 '객체'입니다.
    
            // ///// 자바  String 의 중요한 메소드 7가지씩 조사해서 테스트 해보기  /////
            // replace(CharSequence target, CharSequence replacement)	target 부분을 replacement로 대치한 새로운 문자열을 리턴합니다.
            m_message = m_message.replace("Hello", "하연");
            System.out.println(m_message);

            // substring(int beginIndex)	beginIndex 위치에서 끝까지 잘라낸 새로운 문자열을 리턴합니다.
            m_message = m_message.substring(1);
            System.out.println(m_message);
            
            // toLowerCase()	알파벳 소문자로 변환한 새로운 문자열을 리턴합니다.
            m_message = m_message.toLowerCase();
            System.out.println(m_message);
            
            // toUpperCase()	알파벳 대문자로 변환한 새로운 문자열을 리턴합니다.
            m_message = m_message.toUpperCase();
            System.out.println(m_message);
            
            // trim()	앞뒤 공백을 제거한 새로운 문자열을 리턴합니다.
            m_message = m_message.trim();
            System.out.println(m_message);
            
            // valueOf(int i)    valueOf(double d)	기본 타입 값을 문자열로 리턴합니다.
            m_message = String.valueOf(m_imo);
            System.out.println(m_message);
            

            



        } catch (Exception e) {
            System.out.println(e);
        }




    }
}
