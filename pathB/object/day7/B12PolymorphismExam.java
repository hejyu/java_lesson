package object.day7;

import object.test.Square;

/**
 * 다형성 구현 예제
 *  자료구조 개념이 필요. 우리는 배열을 사용
 */
public class B12PolymorphismExam {

    public static void main(String[] args) {
        
        Shape[] shapes = new Shape[5];

        shapes[0] = new Diamond();
        shapes[0].setShaeName("💎💎💎");

        shapes[1] = new Triangle("세모님", 120,40,45);
        
        shapes[2] = new Square();
        shapes[2].setShaeName("🎁");

        shapes[3] = new Diamond();
        shapes[3].setShaeName("💎💎💎✨");

        shapes[4] = new Square();
        shapes[4].setShaeName("🎲🎲🎲");

        // 부모타입 클래스 배열에 자식 객체를 추가해 부모 클래스를 참조시킴 
        
        // 자료구조에 저장된 객체가 하나의 타입 shape 이지만 실행되는 draw 동작은 모두 다르다
        for(int i = 0; i < shapes.length; i++) {
            System.out.println(String.format("%d 빈 도형입니다", i));
            shapes[i].draw();
        }

        System.out.println("~~~ 자식 인스턴스의 실제 타입을 검사하는 instance 연산 ~~~");
        for(int i = 0; i < shapes.length; i++) {
            System.out.println("도형 : " + shapes[i].getShapeName());
            System.out.println("\t shapes[i] instantce of Triangle ? " + (shapes[i] instanceof Triangle));
            System.out.println("\t shapes[i] instantce of Diamond ? " + (shapes[i] instanceof Diamond));
            System.out.println("\t shapes[i] instantce of Square ? " + (shapes[i] instanceof Square));
        }

        System.out.println("~~~ shapes 배열에 저장된 객체 중 삼각형 Triangle 객체는 넓이를 구해서 출력하기 ~~~ ");
        for(int i = 0; i < shapes.length; i++) {
            if(shapes[i] instanceof Triangle) {
                System.out.println(String.format("%d 번째. 삼각형 넓이 : %d", i, shapes[i].calculateArea()));
            }
        }
        // 4번째 Shape 도형을 Triangle 객체 참조
        shapes[4] = new Triangle("🔺🔺🔺", 45, 12, 65);
        System.out.println("삼각형이면 angle 필드도 출력");
        for(int i = 0; i < shapes.length; i++) {
            if(shapes[i] instanceof Triangle) {
                // Triangle 객체 일때만 강제캐스팅, 아니면 오류
                Triangle temTr = (Triangle) shapes[i];
                System.out.println(String.format("%d 번째. %s 넓이 : %d", i, shapes[i].getShapeName() , shapes[i].calculateArea()));
                temTr.printAngle();     // 삼각형 각도 : 65
            }
        }


        System.out.println("~~~ shapes 배열에 저장된 객체 중 다이아몬드를 draw 하기 ~~~ ");
        //for 반복실행문 실행시 알아서 순서대로 1개씩 배열 요소를 가져오는 방법.
        //index 를 사용할 수 없음
        for(Shape temp : shapes){
            if(temp instanceof Diamond)
                temp.draw();

        }
        
        //index 사용 가능 for 반복실행문
        for(int i = 0; i < shapes.length; i++) {
            if(shapes[i] instanceof Diamond) {
                System.out.print(String.format("%d 번째. 다이아몬드. draw() :  ", i));
                shapes[i].draw();
            }
        }

        //index 사용 가능 for 반복실행문
        for(int i = 0; i < shapes.length; i++) {
            if(shapes[i] instanceof Square) {
                System.out.print(String.format("%d 번째. 정사각형. draw() :  ", i));
                shapes[i].draw();
            }
        }

        for(Shape temp : shapes){
            if(temp instanceof Square)
                temp.draw();        // 도형 그리기 >>> 🎁

        }
        

        System.out.println("");


    }
}
