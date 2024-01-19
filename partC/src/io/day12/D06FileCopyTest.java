

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

// 파일입력스트림으로 이미지를 읽어옵니다
// ==> 파일출력스트림으로 파일을 출력합니다
//      (파일복사)
public class D06FileCopyTest {
    
    public static void main(String[] args) {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        int data;

        try {
            fis = new FileInputStream("C:\\Users\\Administrator\\Downloads\\jenny.jpg");
            fos = new FileOutputStream("jenny.png");
            int count = 0;

            while((data=fis.read()) != -1){      // 1바이트씩 복사( fis에서  fos로)  
                fos.write(data);                 // 파일출력스트림으로 데이터 보내기
                count++;     
            }

            System.out.println("총 입력 바이트 수 : " + count);

        } catch (IOException e) {
            System.out.println("예외 : " + e.getMessage());
        }finally {
            // 입출력 자원해제. 예외 발생 상관없이 처리할 내용을 작성
            try {
                fos.close();
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
