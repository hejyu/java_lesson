package koreait.test;


/**
 * 작성자 : 조하연
 */
public class ProductApp {
    
    public static void main(String[] args) {
    

        Product[] cart = new Product[10];
        cart[0] = new Bike(123000, "MTB", 25);
        cart[3] = new Bike(99000, "삼천리", 15);

        cart[1] = new Electronics(35000, "USB");
        cart[5] = new Electronics(527000, "스마트TV");
        cart[7] = new Electronics(2250000, "lg냉장고");

        //[2] power 메소드 : Electronics 자식 클래스의 메소드
        //     ㄴ 다운캐스팅: 현재 부모타입으로 참조하는 것을 자식타입으로 변경
        Electronics tv = null;

        // 다운캐스팅시 안전하게 타입 체크를 해줍니다
        if(cart[5] instanceof Electronics){
            tv = (Electronics) cart[5];
            tv.setKwh(0.9);
            System.out.println(tv.power());
        }else 
            System.out.println("Electronics 메소드 사용 불가능");
        

        //[3]  배열 10개 중 객체가 참조된 것은 5개
        //      => null 이면 메소드 실행 예외 발생. NullPointerException   
        System.out.println("------ 10만원 이상인 상품 ------ ");
        for (int i = 0; i <= cart.length - 1; i++) {
            if(cart[i] != null && cart[i].getPrice() >= 100000 ) 
                System.out.println(cart[i]);
        }
        // ------------------------ [3] ----------------------------
        for (Product p : cart) {
            if(p != null && p.price >= 100000) 
                System.out.println(p);      // toString()
        }
        // ---------------------------------------------------------


        //[4]
        System.out.println("------ 바이크 객체 ride ----- ");
        for (int i = 0; i < cart.length - 1; i++) {
            if(cart[i] != null && cart[i] instanceof Bike)
                System.out.println(((Bike) cart[i]).ride());
        }
        // ------------------------ [4] ----------------------------
        for (Product p : cart) {
            if (p != null && p instanceof Bike) {
                Bike b = (Bike) p;
                System.out.println(b.ride());
            }
        }
        // ---------------------------------------------------------

        //[5]
        if(cart[3] instanceof Bike){
            Bike b = (Bike) cart[3];    // 다운캐스팅: 현재 부모타입으로 참조하는 것을 자식타입으로 변경
            System.out.println(b.sell(20));
        }


        //[6]
        if(cart[5] instanceof Electronics){
            Electronics e = (Electronics) cart[5];
            System.out.println(e.sell("사운드바"));
        }

    }
}


/* 
 * 라이브러리 클래스 : 프로그래밍에 필요한 재료로 사용되는 클래스
 *                      ㄴ 인스턴스 메소드와 static 메소드로 제공되는 기능을 사용
 *                      ㄴ Product, Bike, Eletronics, **그리고 제일 중요한 자바 클래스
 * 
 * 실행 클래스 : 메인 메소드를 포함하여 프로그램을 실행하는 클래스
 *              ㄴ 메인 메소드는 반드시 static 정적 클래스 이어야 함
 *              ㄴ 메인 메소드를 위한 객체를 먼저 생성할. 그래서 static 
 *              ㄴ ProductApp
 * 
 * 실행 예시 : Bike 클래스 sell 메소드 Object 인자값은 외부에서 줍니다
 *              ㄴ 여기서 외부는 이 메소드를 사용하는 메인 또는 다른 클래스
 *              ㄴ 라이브러리 클래스 인스턴스 필드값은 실행될 때 결정됨
 */
