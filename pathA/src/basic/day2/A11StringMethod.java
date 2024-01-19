package basic.day2;

public class A11StringMethod {
    public static void main(String[] args){

        try {
           
            // 메소드 메소드이름 뒤에 괄호가 따라옵니다
            // 괄호안의 값들은 메소드 처리에 필요한 입력 데이터
            //   메소드가 처리한 결과는 출력 데이터 => 메소드의 '리턴 값' 이라고 합니다.

            // 자바 String 중요한 메소드 7가지를 찾아서 테스트 해보기
            String m_message = "Hello, World~ H";
            System.out.println(m_message);
            // 1. 메소드 괄호 안에 아무것도 없는 것 : length, isEmpty, toupperCase, toLowerCase
            System.out.println("m_message.length() : " + m_message.length());    
            System.out.println("m_message.isEmpty() : " + m_message.isEmpty());    
            System.out.println("m_message.toUpperCase() : " + m_message.toUpperCase());    
            System.out.println("m_message.indexOf() : " + m_message.toUpperCase());    
            // 2. 메소드 괄호 안에 정수 1개를 쓰는 것 : charAt
            System.out.println("m_message.charAt(0) : " + m_message.charAt(0));       // 입력 이란 괄호 안에 들어가는 것, 출력이란 리턴되는 것
            System.out.println("m_message.charAt(3) : " + m_message.charAt(3));       // 입력 이란 괄호 안에 들어가는 것, 출력이란 리턴되는 것

            // 3. 메소드 괄호 안에 문자열 1개를 쓰는 것 : concat, equals, startsWith, endsWith, indexOf
            System.out.println("m_message.concat(\"~짱짱\") : " + m_message.concat("~짱짱"));
            System.out.println("m_message.equals(\"Hello, World~짱짱\") : " + m_message.equals("Hello, World~짱짱"));
            System.out.println("m_message.startsWith(\"~짱짱\") : " + m_message.startsWith("~짱짱"));
            System.out.println("m_message.endsWith(\"World~\") : " + m_message.endsWith("World~"));
            System.out.println("m_message.indexOf(\"H\") : " + m_message.indexOf("H"));
            // 4. 메소드 괄호 안에 정수 2개를 쓰는 것 : substring
            System.out.println("m_message.substring(0,4) : " + m_message.substring(0, 4));
            System.out.println("m_message.substring(2,4) : " + m_message.substring(2, 4));
            // 결국 추출하는 문자열 개수는 endIndex - beginIndex 공식이 성립합니다.

            // 5. 메소드 괄호 안에 문자 또는 문자열 2개를 쓰는 것 : replace (문자열 바꾸기)
            System.out.println();
            System.out.println(m_message.replace("ll", "**"));

            // 리턴값 형식 기준으로 정리하기
            // boolean : startsWith, endsWith, equals, isEmpty
            // String : replace, substring, toUpperCase, toLowerCase, concat
            // int :  length, indexOf
            // char : charAt
            
            // 출력 후 변수에 담는 것이 더 중요합니다.

            // 질문 공유
            String temp = m_message.toUpperCase().substring(3,6);
            //                      - 문자열리턴값으로 또 메소드를 실행할 수 있습니다.
            System.out.println(temp);
            
        } catch (Exception e) {
            System.out.println(e);
        }




    }
}
