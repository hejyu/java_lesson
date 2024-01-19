package object.day8_interface.beable;

public class Dog implements Runnable {

    
    @Override
    public String beAble() {
        return "달리기";
    }
    
    @Override
    public String run(int speed) {
        return "휴먼은 "+speed + "km/h로 달립니다. \n 최대속도 50km/h";
    }
    

    
    
}
