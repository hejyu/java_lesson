
import java.io.FileOutputStream;
import java.io.IOException;

// 표준입출력 테스트
// 키보드 입력을 파일로 출력하는 예제
public class D04KeyInputFileOut {
    public static void main(String[] args) {
        
        int b;
        System.out.println("입력하세요  > ");
        FileOutputStream fos = null;

        try {
            fos = new FileOutputStream("note.txt");   // 인자로 파일명 전달
            int count = 0;

            while((b=System.in.read()) != 13){      //  엔터 (입력끝)  
                fos.write(b);                       // 파일출력스트림으로 데이터 보내기
                count++;
            }

            System.out.println("총 입력 바이트 수 : " + count);
           

        } catch (Exception e) {
           
            System.out.println("예외 : " + e.getMessage());
        
        } finally {
            // 입출력 자원해제. 예외 발생 상관없이 처리할 내용을 작성
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}