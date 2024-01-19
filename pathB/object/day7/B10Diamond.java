package object.day7;

public class B10Diamond {

    public static void main(String[] args) {

        // Diamond 클래스에 extends Shape 외에 코드가 없습니다. 그러나 아래 메소드는 실행 가능합니다.
        Diamond diamond = new Diamond();    // 새로운 도형이 만들어졌습니다. 초기화 필요합니다.
        System.out.println("Diamond Width : " + diamond.getWidth());    // Diamond Width : 0
        System.out.println("Diamond Height : " + diamond.getHeight());  // Diamond Height : 0
        System.out.println("Diamond area : " + diamond.calculateArea());    // Diamond area : 0
        diamond.print();
        
        // 상속받은 필드값 저장하는 setter 생성 확인
        // 접근한정자 확인하기

        diamond.round = 3;
        diamond.etc = "access modifier test";
        
        System.out.println("변경된 데이터 확인 >>> " + diamond.round);  // 3
        System.out.println("변경된 데이터 확인 >>> " + diamond.etc);    // access modifier test

        
        
    }


}
