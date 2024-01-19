package object.day7;


// 대표적인 자바 클래스 static 필드 확인 예제
public class B13StaticFieldExam {  

    public static void main(String[] args) {
        //  Wrapper 클래스들 : 기본 자료형을 클래스 타입 즉 인스턴스로 사용하게 해줌
        //  Integer
        System.out.println("Integer.MAX_VALUE = " + Integer.MAX_VALUE);     // 2147483647
        System.out.println("Integer.MIN_VALUE = " + Integer.MIN_VALUE);     // -2147483648
        System.out.println("Integer.SIZE = " + Integer.SIZE);               // 32 (bit)
        System.out.println("Integer.BYTES = " + Integer.BYTES);             // 4
        
        //  Long
        System.out.println("Long.MAX_VALUE = " + Long.MAX_VALUE);     // 9223372036854775807
        System.out.println("Long.MIN_VALUE = " + Long.MIN_VALUE);     // -9223372036854775808
        System.out.println("Long.SIZE = " + Long.SIZE);               // 64 (bit)
        System.out.println("Long.BYTES = " + Long.BYTES);             // 8

        //  Double
        System.out.println("Double.MAX_VALUE = " + Double.MAX_VALUE);     // 1.7976931348623157E308
        System.out.println("Double.MIN_VALUE = " + Double.MIN_VALUE);     // 4.9E-324
        System.out.println("Double.SIZE = " + Double.SIZE);               // 64 (bit)
        System.out.println("Double.BYTES = " + Double.BYTES);             // 8

        //  Character
        System.out.println("Character.MAX_VALUE = " + (int)Character.MAX_VALUE);     // 65535
        System.out.println("Character.MIN_VALUE = " + (int)Character.MIN_VALUE);     // 0
        System.out.println("Character.SIZE = " + Character.SIZE);               // 16 (bit)
        System.out.println("Character.BYTES = " + Character.BYTES);             // 2

        // Shape
        System.out.println("Shape.MAX_WIDTH = " + Shape.MAX_WIDTH);     // 100

        // Diamond
        System.out.println("Diamond.MAX_WIDTH = " + Diamond.MAX_WIDTH);     // 100

        // Triangle
        System.out.println("Triangle.MAX_WIDTH = " + Triangle.MAX_WIDTH);     // 90 -> 상수 값 변경



    }

}
/**
 * 위 필드 값은 모두 public static final
 * public : 모두에게 오픈
 * static : 객체없이 사용할 수 있는 필드 또는 값 정적인 메모리 공유 영역
 * final 필드 : 값 변경 불가능 
 * (Ref) final method : 오버라이딩  불가능
 * 
 * 
 * public static int abc;
 * public final int xyz;
 * 
 * 위의 2개 경우보다는 의미상 조합이 public static final 이 맞음
 * 영원히 고정되는 값에 대해 기호를 부여하는 상수의 개념
 * 그리고 상수는 모두 대문자로 작성하기로 약속함.
 */
