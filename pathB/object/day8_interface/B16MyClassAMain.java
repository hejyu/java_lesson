package object.day8_interface;

/**
 *  인터페이스 테스트
 */
public class B16MyClassAMain {

    public static void main(String[] args) {
        
        // 인터페이스는 객체 생성 못함
        // 단, 익명 내부 타입으로 정의는 가능?
        // InterfaceA ifa = new InterfaceA();

        // create Object to MyClassA 
        MyClassA mya = new MyClassA();

        // Up Casting to InterfaceA
        InterfaceA ifa = new MyClassA();

        // Down Casting to MyClassA
        MyClassA temp = (MyClassA)ifa;

        System.out.println("참조타입 변수와 상관없이 똑같이 실행됩니다.");
        mya.methodA();
       
    }
}
