package koreait.test;

/**
 * 작성자 : 조하연
 */
public class Bike extends Product{  // [0]
    
    // [4]
    private int speed;

    
     // [3]
    public Bike(int price, String prdName, int speed) {
        super(price, prdName);
        this.speed = speed;
    }



    // [8]
    @Override
    public String sell(Object obj) {
        String msg = String.format("[%s] 행사 - %d %% 인하", prdName, obj);
        return msg;
    }

    // [5]
    public String ride(){
        String msg = "당신은 이것을 시속"+this.speed+"km 로 탈수 있습니다";
        return msg;
    }

    // [4]
    public int getSpeed() {
        return speed;
    }


    public void setSpeed(int speed) {
        this.speed = speed;
    }


    
    // [10]
    @Override
    public String toString() {
        return "price=" + price + ", prdName=" + prdName + ", speed=" + speed ;
    }

}

class Electronics extends Product{

    // [6]
    private double kwh;


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


    // [10]
    @Override
    public String toString() {
        return "price=" + price + ", prdName=" + prdName + ", kwh=" + kwh ;
    }
    




    

}