package object.test;

import object.day7.Diamond;

public class B11DiamondTest {


    public static void main(String[] args) {
        Diamond diamond = new Diamond();
        System.out.println("Diamond Width : " + diamond.getWidth());    // Diamond Width : 0
        System.out.println("Diamond Height : " + diamond.getHeight());  // Diamond Height : 0
        System.out.println("Diamond area : " + diamond.calculateArea());    // Diamond area : 0

        // diamond.etc = "test package ~~";           // 부모클래스와 같은 패키지가 아님. 상속받은 자식 클래스가 아님
        // diamond.round = 1;                         // 현재 클래스는 Diamond의 부모 클래스를 상속받은 클래스가 아님

        // System.out.println("변경된 데이터 확인 >>> " + diamond.round);
        // System.out.println("변경된 데이터 확인 >>> " + diamond.etc);

        
    }
}
