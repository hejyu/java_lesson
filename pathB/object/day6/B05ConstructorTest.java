package object.day6;

import java.util.Arrays;

public class B05ConstructorTest {

    public static void main(String[] args) {
    
        MyClass4 my = new MyClass4();
        System.out.println("field2 : " + my.getField2());

        System.out.println("인자 1개 커스텀 생성자 실행");
        
        MyClass4 my1 = new MyClass4(999);
        System.out.println("\tmy1 field2 : " + my1.getField2());
        
        MyClass4 my2 = new MyClass4("Hello");
        System.out.println("\tmy2 field1 : " + my2.getField1());

        System.out.println("인자 2개 커스텀 생성자 실행");
        MyClass4 my3 = new MyClass4("Hello", 999);
        System.out.println("\tmy3 field1 : " + my3.getField1());
        System.out.println("\tmy3 field2 : " + my3.getField2());

        System.out.println("인자 3개 커스텀 생성자 실행");
        MyClass4 my4 = new MyClass4("Hello", 999, new double[3]);
        System.out.println("\tmy4 field1 : " + my4.getField1());
        System.out.println("\tmy4 field2 : " + my4.getField2());
        System.out.println("\tmy4 field3 : " + Arrays.toString(my4.getField3()));


        // 기본생성자와 setter가 없는 MyClass5 객체를 생성
        MyClass5 my5 = new MyClass5("language", 1111, new double[3]);
        // MyClass5 my6 = new MyClass5();  // error,  The constructor MyClass5() is undefined 클래스에 기본생성자가 없음

        System.out.println("Myclass5 객체를 확인");
        System.out.println("\tfield1 : " + my5.getField1());
        System.out.println("\tfield2 : " + my5.getField2());
        System.out.println("\tfield3 : " + my5.getField3());

        MyClass3 test = new MyClass3();
        test.setField1("python");
        test.setField2(999);
        test.setField3(new double[]{1.2, 67.55, 123.57});

        // 기본 생성자는 필드를 초기화 하는 것이 조금 불편
        //           -> 초기화를 위해 커스텀 생성자를 사용하는 것이 좋다

        // 결론 : 생성자 메소드가 직접 정의된 것이 없으면 기본 생성자만 사용 가능
        //      MyClass5 와 같이 커스텀 생성자 메소드가 하나라도 정의되어 있으면
        //          기본생성자는 생략하고 사용 못함
        //          사용하고 싶으면 직접 정의해야 함




    }
}
