package koreait.test;

/**
 * 작성자 : 조하연
 */
public class ProductApp {
    
    public static void main(String[] args) {
    
        //[1]
        Product[] cart = new Product[10];
        cart[0] = new Bike(123000, "MTB", 25);
        cart[3] = new Bike(99000, "삼천리", 15);
        cart[1] = new Electronics(35000, "USB");
        cart[5] = new Electronics(527000, "스마트TV");
        cart[7] = new Electronics(2250000, "lg냉장고");

        //[2]
        ((Electronics) cart[5]).setKwh(0.9);
        System.out.println(((Electronics) cart[5]).power());

        //[3]   
        System.out.println("------ 10만원 이상인 상품 ------ ");
        for (int i = 0; i < cart.length - 1; i++) {
            if(cart[i] == null ) continue;
            
            if( cart[i].getPrice() > 100000 ) 
                System.out.println(cart[i]);
            
        }

        //[4]
        System.out.println("------ 바이크 객체 ride ----- ");
        for (int i = 0; i < cart.length - 1; i++) {
            if(cart[i] == null ) continue;

            if( cart[i] instanceof Bike ) 
                System.out.println(((Bike) cart[i]).ride());
        }

        //[5]
        System.out.println(((Bike)cart[3]).sell(20));


        //[6]
        System.out.println(((Electronics)cart[5]).sell("사운드바"));




    }
}
