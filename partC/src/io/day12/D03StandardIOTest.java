
// 표준입출력 테스트
// 키보드 입력 : new Scanner(System.in) or System.console().readLine()
public class D03StandardIOTest {
    public static void main(String[] args) {
        
        int b;
        System.out.println("입력하세요  > ");
        
        try {    
            int count = 0;
            while((b=System.in.read()) != -1){      // -1 (입력끝) ctrl + z 
                // System.out.println(b);
                System.out.write(b);
                count++;
            }
            System.out.println("총 입력 바이트 수 : " + count);

        } catch (Exception e) {
           
            System.out.println("예외 : " + e.getMessage());
        
        }

    }
}

// File Input 키보드에서 입력 -> 화면에서  출력
// File Input -> File Output (파일 복사)
// 바이트 기반 스트림은 문자형식의 파일이 아닐때
// 문자기반 스트림 : 문자단위 입출력.