package object.day8_interface;

import java.beans.beancontext.BeanContext;

import object.day8_interface.beable.AI;
import object.day8_interface.beable.BeAble;
import object.day8_interface.beable.Cookable;
import object.day8_interface.beable.Dog;
import object.day8_interface.beable.Human;
import object.day8_interface.beable.Runnable;
import object.day8_interface.beable.Thinkable;

public class B19BeAbleMain {
    
    public static void main(String[] args) {

        Thinkable th1 = new AI();
        AI ai = (AI) th1;
        ai.setOp('*');

        Thinkable th2 = new Human();
        // Thinkable th3 = new Dog();

        Runnable run1 = new Human();
        Runnable run2 = new Dog();
        // Runnable run3 = new AI();

        Cookable cook = new Human();
        
        BeAble[] beAbles = new BeAble[3];
        beAbles[0] = th1;
        beAbles[1] = th2;
        beAbles[2] = run2;

        System.out.println("BeAble 상속 인터페이스 테스트");
        for (BeAble able : beAbles) {

            System.out.println(able.getClass().getName()+ "의 인스턴스가 실행합니다");
            System.out.println(able.beAble());
            
            // 상속 인터페이스 다운 캐스팅
            if(able instanceof Thinkable) {
                Thinkable temp = (Thinkable) able;
                char op = temp instanceof AI ? ((AI)temp).getOp() : '+';
                System.out.println("연산 : " + op);
                System.out.println(temp.calculate(2024, 9));
        
            }else {
                System.out.println("계산 못함");
            }


        }   // 결론 : 업캐스팅 또는 다운캐스팅은 상속과 같은 방식으로 사용합니다.
            //              ㄴ 업캐스팅 : 다형성 때문에 
            //              ㄴ 다운캐스팅 : 업캐스팅 타입과 관계 없는 추상매소드가 아닌 메소드를 실행하기 위해

        
    }
}
