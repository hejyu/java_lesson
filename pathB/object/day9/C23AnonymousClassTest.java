package object.day9;

import object.day8_interface.beable.BeAble;
import object.day8_interface.beable.Cookable;

public class C23AnonymousClassTest {
    

    public static void main(String[] args) {
        
        Cookable aiCooker = new Cookable() {
            
            // 추상메소드 구현해야함

            @Override
            public String beAble() {

                return "cookingm achine";
            }

            @Override
            public void cook(String material) {
            
                System.out.println("요리하는 기계입니다." + material + "레시피를 주세요");
            }

        };

        System.out.println(aiCooker.beAble());
        aiCooker.cook("생닭");

        // 함수형 인터페이스 :재정의 해야할 메소드가 1개인 것. => BeAble 인터페이스의 추상메소드가 1개
        //      - 익명클래스 정의한 함수형 인터페이스는 람다식으로  줄여서 정의 가능
        BeAble beAble = new BeAble() {

            @Override
            public String beAble() {
                return "무엇이든 합니다~~";
            }

        };

        System.out.println(beAble.beAble());

        BeAble beAble2 = () -> {
                return "무엇이든 합니다~~112222" ;
            };

        System.out.println(beAble2.beAble());

        // 자바스크립트 (웹) 에서는 화살표 함수로 같은 형식으로 사용됩니다.
        

    }
}

// 함수형 인터페이스 정의 (참고) functioin 키워드는 c 나 자바스크립트에서 함수 정의시 사용
// 인터페이스 중 추상메소드가 1개인 것 은 다른 언어에서도 '함수'의 형식으로 사용 가능!!
//      함수와 메소드 
//      - 공통점 : 인자와 리턴값이 있다는 것. 
//      - 다른 점:  메소드는 클래스(또는 객체)에 구성요소, 함수는 클래스의 구성요소로 존재하지 않아도 가능
//      자바에서 함수형 인터페이스를 람다식으로 많이 사용.

//  (참고)자바 라이브러리에는 인자의 형식과 개수와 리턴 타입 등 여러 유형에 따라 
//          Consumer, Producer(자바8까지 이후 Supplier), Function, Predicate 등의
//          함수형 인터페이스가 미리 정의되어 있습니다.
//  @FunctionalInterface         //함수형 인터페이스에 사용
//       애노테이션이라는 주석으로 `코드를 체크하는 기능`

