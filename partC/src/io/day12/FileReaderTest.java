
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class FileReaderTest {
    public static void main(String[] args) {
        
        Reader fr =null;
        int data =0;
        
        try {
            fr = new FileReader("D:\\Class231228\\java\\test.md");
            int count = 0;
			// FileInputStream을 이용해서 파일내용을 읽어 화면에 출력한
			// 1 byte 출력 -> 한글깨짐
			// while((data=fis.read())!=-1) {
			// 	System.out.print((char)data);
            //     count++;            // 한글 : 3바이트 , 영어 : 1바이트
			// }

			System.out.println("\n");
			
			// FileReader를 이용해서 파일내용을 읽어 화면에 출력한
			// 2 byte 출력
			while((data=fr.read())!=-1) {
				System.out.print((char)data);
                count++;            // 한글 : 2바이트 , 영어 : 1바이트
			}

			System.out.println();		

            System.out.println("총 입력 바이트 수 : " + count);

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
            // try {
            //     fr.close();
                
            // } catch (IOException e) {
            //     System.out.println("예외 : " + e.getMessage());
            // }
        }
    }
}
