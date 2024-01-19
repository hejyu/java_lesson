

import java.util.Scanner;

public class D01TryCatchTest {

    public static void main(String[] args) {


        // 비정상적인 종료에 대해 사용
        try {
            // 예외가 발생할 수 있는 명령문
            indexException();
        } catch (NumberFormatException e) {  // ( 인자 ) : 처리할 예외의 종류
            // 예외가 발생할 때 실행할 명령
            System.out.println("정수는 숫자만 입력하세요");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Index range must be array length - 1");
        }


        System.out.println("end");
    }

    

    public static void indexException() {
        int[] arrays = {11,22,33,44,55};
        System.out.println(arrays[arrays.length]);

    }

    public static void numberException() {

        Scanner sc = new Scanner(System.in);
        System.out.println("정수를 입력하세요");
        int number = sc.nextInt();
        System.out.println("입력한 값 : " + number);
        sc.close();
        
    }


}
