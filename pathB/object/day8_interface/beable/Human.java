package object.day8_interface.beable;

public class Human implements Thinkable, Cookable, Runnable {

    @Override
    public int calculate(int a, int b) {
        int result = 0;
        if(a >= 99999 && b >= 99999) {
            System.out.println("암산 할 수 없는 연산입니다");  
            result = -99999;
        }else{
            System.out.println("암산할 수 있는 덧셈 ");
            result = a + b;
        }

        return result;
    }

    @Override
    public void think() {
        System.out.println("휴먼은 창의적으로 생각할 수 있습니다.\n" +
                        "단 너무 많으면 포기합니다.");
        
    }

    @Override
    public String beAble() {
        return "생각도하고 요리도하고 달리기도합니다.";
    }

    @Override
    public void cook(String material) {
        System.out.println(material + "를 사용해서 여러가지 요리를 합니다.");
    }

    @Override
    public String run(int speed) {
        return "휴먼은 "+speed + "km/h로 달립니다. \n 최대속도 10km/h";
    }

    @Override
    public String toString() {
        return "Human ";
    }


    
}
