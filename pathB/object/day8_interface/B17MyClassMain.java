package object.day8_interface;


public class B17MyClassMain  {

    public static void main(String[] args) {
        MyClassA myClassA = new MyClassA();

        MyClassB myClassB = new MyClassB();
        InterfaceA ifa = new MyClassB();
        InterfaceX ifx = new MyClassB();
        MyClassB myb = new MyClassB();

        myb.methodA();
        ifa.methodA();
        // ifx.methodA();  // InterfaceA 참조 타입은 사용 불가능
        // ifa.methodX();     // InterfaceB 참조 타입은 사용 불가능

        InterfaceX ix = (InterfaceX) ifa;  //  InterfaceA 참조 타입 -> InterfaceX 참조 타입으로 변경
        ix.methodX();
        

        myClassA.methodA();  // 나는 methodA !!
        myClassA.methodB(0);
        MyClassA.methodD();




    }
}
