
import java.io.File;
import java.io.IOException;

// File 클래스 : 운영체제의 파일 시스템을 다루는 클래스 
public class D02CheckedExceptionTest {
    

    public static void main(String[] args) {
        // File file = new File("F:\\테스트.md");    // 없는 드라이브 지정 -> 예외 발생 
        File file = new File("테스트.md");    // 파일의 이름을 인자로 전달해 File 객체를 정의
        // 디렉토리를 지정하지 않으면 프로젝트와 같은 폴더에 만들어짐


        try {

            System.out.println(file.exists());  // 파일이 존재 하나요

            file.createNewFile();
            
            System.out.println("파일 크기 > " + file.length());  // 파일 크기

        } catch (IOException e) {

            // 예외 객체는 변수 e로 참조
            System.out.println("파일 생성에 오류가 발생했습니다");
            System.out.println(e.getMessage()); 

        }  catch(ArrayIndexOutOfBoundsException e) {

            System.out.println("인덱스 범위는 배열 -1 입니다");
            System.out.println(e.getMessage());

        } 
    }
}