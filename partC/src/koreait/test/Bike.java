package koreait.test;

/**
 * 작성자 : 조하연
 */
// [0]  객체의 구성요소 : 인스턴스 필드와 인스턴스 메소드 
//      클래스 구성 요소 : 객체 구성  요소 + (static 메소드 + static 필드)
//      ㄴ  클래스는 객체가 만들어지는 인스턴스의 구성 요소를 정의하는 상위개념이다
public class Bike extends Product{  
    
    // [4]
    private int speed;

    
    // [3]
    public Bike(int price, String prdName, int speed) {
        super(price, prdName);  
        // ㄴ   super.price = price;
        //      super.prdName = prdName;
        // ㄴ   this.price = price;
        //      this.prdName = prdName;
        //          ㄴ price, prdName 필드는 protected 필드이므로 자식이 바로 접근 가능
        this.speed = speed;
    }

    // 인스턴스 메소드 : getter, setter, ride 메소드, 인스턴스를 대상으로 처리 기능을 갖는 메소드를 의미
    
    // [4]
    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    // [5]
    public String ride(){
        // this 는 생략 가능, 하지만 speed 필드가 객체의 필드 변수라는 것을 가독성 있게 해줍니다
        String msg = "당신은 이것을 시속" + this.speed + "km 로 탈수 있습니다";
        return msg;
    }

    // [8]  추상메소드를 상속받았기 때문에 반드시 추상메소드를 재정의한다
    @Override
    public String sell(Object obj) {
        String msg = String.format("[%s] 행사 - %d %% 인하", prdName, obj);
        return msg;
    }

    // [10]
    @Override
    public String toString() {
        return super.toString() + ", speed=" + speed;
    }

    



}

class Electronics extends Product{

    // [6]
    private double kwh;         // 필드 : 클래스에 소속된 변수, 클래스 전역(Global) 변수


    // [3]
    public Electronics(int price, String prdName) {
        super(price, prdName);
    }


    // [9]
    @Override
    public String sell(Object obj) {
        String msg = String.format("[%s] 증정 - %s", prdName, obj);
        return msg;
    }

    // [7]
    public double power(){
        return (this.kwh*24); 
    }

    // [6]
    public double getKwh() {
        return kwh;
    }

    public void setKwh(double kwh) {
        this.kwh = kwh;
    }


    // [10]   부모클래스애서 재정의한 것을 자식클래스가 또(다시) 재정의
    @Override
    public String toString() {
        return super.toString() + ", kwh=" + kwh ;
    }
    




    

}