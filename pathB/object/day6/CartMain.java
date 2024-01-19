package object.day6;

import java.util.Arrays;
import java.util.Scanner;

public class CartMain {

    public static void main(String[] args) {
        
        CartJHY cart = new CartJHY(); // 참조 클래스를 생성

        // 고객 식별 데이터
        String userId = "모모";
        
        // 담기한 상품이름 데이터
        String[] productsNames = {"몽글몸글", "라이프", "몬스터", "미켈란"};
        
        // 상품가격 데이터
        int[] prices = {150000, 300000, 25000};
        
        Scanner sc = new Scanner(System.in);
        // 선택한 상품 데이터
        int[] select= new int[productsNames.length-1];
        int k = 0;
        int sel = 0;
        
        cart.setUserId(userId);
        cart.setProductNames(productsNames);
        cart.setPrices(prices);

        // 상품 데이터
        System.out.println("🎁🎁🎁장바구니🎁🎁🎁");
        for(int i = 0 ; i < productsNames.length-1 ; i++){
            System.out.println(String.format("%d : %s , %,d 원", i, productsNames[i], prices[i]));
        }
        
        // 선택
        System.out.println("구매할 상품 번호 선택하세요. 종료하시려면 -1 을 입력하세요");
        while (sel != -1) {

            System.out.print("상품 선택 : " );
            sel = sc.nextInt();
            
            if(sel < -1  || sel > productsNames.length-1){
                System.out.println("존재하지 않는 상품입니다.");
                continue;
            }    
            

            try {
                select[k++] = sel;
                System.out.println("🎁 상품이 담겼습니다 🎁");
            } catch (ArrayIndexOutOfBoundsException e){
                System.out.println("담을 수 있는 상품을 초과하였습니다 🎢🎢");
                break;
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        
        System.out.println(String.format("📌선택하신 상품은 %s", Arrays.toString(select)));

        System.out.println(String.format("%s 님이 구매를 선택한 상품의 합계는 %d 원 입니다.", cart.getUserId(), cart.sum(select)));
        
        // 필요에 따라서는 기존의 setter 메소드를 사용하지 않고
        //      추가적인 비즈니스로직을 구현하는 메소드를 만듭니다  => total_Moeny() 메소드
    }
}
