package basic.day4;


public class A24StaticMethod {

    // 프로그램을 실행시키는 main 메소드는 static 메소드
    //  다른 static 메소드 작성
    // 메소드 사용 목적 : 특정 처리 기능을 main 메소드와 분리하기 위해서(구조화)
    //      힌 번 만들어진 메소드는 여러번 필요할 때 재사용이 가능


    public static void main(String[] args) {
        
        // 메소드 호출
        // 이름과 형식이 맞는 메소드를 찾아서 실행함
        argumentTest();
        argumentTest(1000);     
        argumentTest(999,1000); // 999,1000 실 매개변수
        // 메소드가 실행될 때 실매개변수 값이 형식매개변수로 전달, 저장됨

        int result = resultIntTest();
        System.out.println("result = "+result);
        System.out.println("resultIntTest 리턴값 : " + resultStringTest());
        System.out.println(resultCharTest());

        double num = add(11111.123453, 0.000001, 0.000001);
        System.out.println("num = "+num);
        System.out.println("add 리턴값 : " + add(11111.123453, 0.000001, 0.000001));
    }

    // 1) 인자값 없는 메소드
    // 인자로 사용된 () 안의 변수는 메소드의 지역변수
    // 지역변수는 특정블럭(메소드, 반복실행문장 ... 등) 쓰는 변수
    public static void argumentTest() {
        System.out.println("인자값 없는 메소드입니다.");
    }
    // 2) 인자가 1개 있는 메소드
    public static void argumentTest(int i) {
        System.out.println("인자가 1개 있는 메소드입니다. i="+i);
    }
    // 3) 인자가 2개 있는 메소드
    // 메소드 인자는 가짜매개변수, 형식 매개변수
    public static void argumentTest(int i, int j) {
        System.out.println("인자가 2개 있는 메소드입니다.i="+i+",  j="+j);
    }

    // 4) 리턴이 int 정수인 메소드
    public static int resultIntTest(){
        return 999;
    }

    // 5) 리턴이 boolean인 메소드
    public static String resultStringTest(){
        return "Hello";
    }

    // 6) 리턴이 char인 메소드
    public static  char resultCharTest(){
        return 'A';
    }


    // 인자와 리턴값을 갖는 메소드
    public static double add(double a, double b, double c) {
        return a+b+c;
    }






}
