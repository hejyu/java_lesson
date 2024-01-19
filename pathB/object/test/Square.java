package object.test;

import object.day7.Shape;       // 부모 클래스와 다른 패키지에서 사용하고 있으면import를 사용

public class Square extends Shape{

    // etc setter 
    public void setEtc(String etc) {
        this.etc = etc;
    }

    // round setter
    public void setRound(int round) {
        //this.round = round;             // Shape 과 같은 패키지가 아니므로 직접 사용 불가
    }

    @Override
    public void draw() {
        System.out.println("도형 그리기 >>> " + this.getShapeName());
    }
}
