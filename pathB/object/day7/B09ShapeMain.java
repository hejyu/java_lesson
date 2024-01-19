package object.day7;


// Shape, Triangle 객체 생성 후 메소드 테스트 해보세요.
public class B09ShapeMain {

    public static void main(String[] args) {
        Shape shape = new Shape("Shape", 20, 15);
        Triangle tr = new Triangle("세모", 10, 5, 60);

        
        System.out.println("~~~~~ 재정의 메소드 실행 확인 ~~~~~");
        System.out.println(shape.getShapeName() + ", " + shape.calculateArea());    // Shape, 300
        System.out.println(tr.getShapeName() + ", " + tr.calculateArea());          // 세모, 25
        System.out.println("부모타입 참조지만 객체는 Triangle 이므로 너비는 재정의 메소드로 실행된다");
        
        System.out.println("~~~~~ 부모  클래스가 정의한 메소드 실행 확인 ~~~~~");
        shape.print();  // final 메소드 테스트-Shape의 너비:20,높이:15,면적:300
        tr.print();     // final 메소드 테스트-세모의 너비:10,높이:5,면적:25   

        //getWidth, getHeight 는 부모클래스 Shape 에서 정의함. 자식이 실행 가능
        System.out.println(tr.getWidth());      // 10
        System.out.println(tr.getHeight());     // 5
        // 자식 클래스에서 정의한 메소드 실행 확인
        System.out.println(tr.getAngle());      //60
        //shape.getAngle()    //  부모가 자식객체 메소드 실행 불가능
        
        // 상속에서 변수 참조 타입 - 자식클래스, 부모클래스 타입
        //1) 자식 객체를 부모 타입으로 참조(*******)
        System.out.println("~~~~~ 자식 클래스 생성시 부모 클래스로 받는 경우 생성자 실행 확인 ~~~~~");
        Shape temShape = new Triangle("세모2", 30, 40, 90);
        System.out.println(temShape.getShapeName() + ", " + temShape.calculateArea());          // 세모2, 600
        temShape.printInfo();       // super 메소드 테스트-세모2의 너비:40,높이:30,면적:600

        Shape temShape2 = new Diamond("💎💎💎💎", 30, 40);       // 💎💎💎💎, 1200
        // Diamond temShape2 = (Diamond) new Shape("💎💎💎💎", 30, 40);   // 자식이지만 부모가 private으로 해놨으므로 불가능!!
        System.out.println(temShape2.getShapeName() + ", " + temShape2.calculateArea());          // 세모2, 600
        temShape2.printInfo();       // super 메소드 테스트-세모2의 너비:40,높이:30,면적:600

        //2) 부모 객체를 자식 타입으로 참조 불가능 
        // Triangle temTr = new Shape("temp shape", 30, 30);

        // 부모 객체를 자식 타입으로 참조하기 위해 강제 캐스팅
        // Triangle temTr = (Triangle) new Shape("temp shape", 30, 30);
        // 강제 캐스팅은 했지만 인스턴스 필드가 하나 안만들어져서 오류가 발생
        
        

        tr.printAngle();        // 자식클래스의 메소드 호출
        tr.print();    // 부모클래스의 메소드 호출
        tr.printInfo();    // 부모클래스의 메소드 호출


        System.out.println("세모 너비 : " + tr.getWidth());


    }
}
