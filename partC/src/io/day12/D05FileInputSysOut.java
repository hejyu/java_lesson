import java.io.FileInputStream;
import java.io.IOException;

// 표준입출력 테스트
// 키보드 입력 : new Scanner(System.in) or System.console().readLine()
public class D05FileInputSysOut {
    public static void main(String[] args) {

        FileInputStream fis = null;
        
        try {

            fis = new FileInputStream("테스트.md"); // 인코딩 UTF-8
            int b;
            int count=0;
            // 바이트기반 스트림 read 메소드는 데이터를 1바이트씩 읽어옵니다.

            while((b=fis.read()) != -1) {
                System.out.write(b);                                    // 윈도우 터미널 인코딩 MS949(ANSI 형식)
                count++;
            }

            System.out.println("\ncount ::: " + count);

        } catch (IOException e) {   // FileNotFoundException 부모로 예외 처리 
            System.out.println("파일 입력 중 오류 발생 : "+e.getMessage());
        } finally {
            // 입출력 자원해제. 예외 발생 상관없이 처리할 내용을 작성
            try {
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        

    }
}