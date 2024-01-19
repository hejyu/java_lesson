package object.day6;

public class B06ProductMain {

    public static void main(String[] args) {
        
        Product snack = new Product("고래밥", 1200, "농심", new String[3]);
        Product drink = new Product("칠성사이다", 2200, "롯데", new String[3]);
        Product fruit = new Product("바나나", 1200, "우리농원", new String[3]);
        Product icecream = new Product("투게더", 1200, "빙그레", new String[3]);

        System.out.println(snack);
        System.out.println(drink);
        System.out.println(fruit);
        System.out.println(icecream);

        // object.day6.Product@372f7a8d     -> 372f7a8d 은 객체 참조값 : 주소
        // object.day6.Product@2f92e0f4     -> object.day6.Product 는 패키지경로.클래스이름
        // object.day6.Product@28a418fc
        // object.day6.Product@5305068a

        System.out.println(snack.getData());
        System.out.println(drink.getData());
        System.out.println(fruit.getData());
        System.out.println(icecream.getData());

        // snack.etc 필드에서 배열요소 0번째에 "10개 묶음" 문자열을 저장하기
        String[] temp = snack.getEtc();
        temp[0] = "10개 묶음";
        System.out.println(snack.getData());


        Product[] mycarts = new Product[5]; // Product 객체 배열 Product 객체의 참조값 저장 배열 
        mycarts[0] = drink;
        mycarts[1] = icecream;
        mycarts[2] = drink;
        mycarts[3] = fruit;
        mycarts[4] = snack;

        System.out.println("~~ my carts ~~~");
        for(int i=0; i < mycarts.length ; i++){
            System.out.println(String.format("mycarts[%d] : %s",i, mycarts[i].getData()));
        }


    }
}
