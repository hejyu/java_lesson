package basic.day3;

public class A17ForExam {

    public static void main(String[] args){

        String message = "Hello, World~ Hoi";

        System.out.println("1.문자열 길이 만큼 문자 1개를 추출하는 반복문 실행하기");
        
        try {
            for(int i=0; i<message.length(); i++) {
                // i는 for안에서만 사용합니다.
               char temp = message.charAt(i);
               System.out.println("i="+i+", 문자="+temp);
            }   // for end
            
        } catch (Exception e) {
            System.out.println(e);
        }
        
        // 위의 for문을 while문으로 바꾸어서 작성
        // 문자열 message 길이만큼 반복실행문장 작성
        // message 문자열을 하나씩 순서대로 저장
        // 출력
        try {
            int i = 0;
            while (i < message.length()) {
                char temp = message.charAt(i);
                System.out.println(String.format("i= %d, 문자 = %c", i += 1, temp));
                // i += 1;
            }
            
        } catch (Exception e) {
            System.out.println(e);
        }
        

        System.out.println("문자열 길이만큼 반복실행하면서 if 조건문을 이용해 문자열 검사");
        System.out.println("\t문자열에서 알파벳 o의 갯수 구하기");
        int m_count = 0;

        // message 문자열 길이만큼 반복실행 문장을 작성
        // o의 개수를 출력할 변수 m_count 선언
        // 문자열 안에 o가 들어가면 m_count 값 1 증가

        for(int i = 0 ; i < message.length() ; i++) {
            char temp = message.charAt(i);
            
            if(temp == 'o')     m_count += 1;
        }

        System.out.println(String.format("문자열 %s 에서 알파벳 o의 갯수 : %d", message, m_count));
















    }   // main end
} // class end
