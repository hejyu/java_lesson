package object.day8;

import object.day7.Diamond;
import object.day7.Shape;
import object.day7.Triangle;
import object.test.Square;

/**
 * 모든 클래스의 부모 클래스는 Object 클리스(모든 자바 클래스와 상속 관계)
 */
public class B14ObjectTest {


    public static void main(String[] args) {

        Object ob1 = new String("hello ");      // Up Casting to Object Type
        Object ob2 = new Diamond();      // Up Casting to Object Type
        Object ob3 = 3;                 // 3 -> Integer instance -> Object로 참조

        //기본형 타입은 Wrapper 클래스 객체로 캐스팅되어 Object Class로 캐스팅
        // ㄴ Byte, Character, Short, Integer, Long, Float, Double
        // ㄴ ** 다른 자료구조 List Map Set 등 은 객체(클래스) 타입만 다룸

        // notifiyAll() ~ cast() =>  related Thread method
        // Object Class Method -> 모든 자바 클래스가 상속받는다
        //                  ㄴ getClass toString hashcode equals
        //                  ㄴ String Class equals() => Object Method를 재정의 한 Method (Override)
        System.out.println("getClass는 클래스 타입 정보를 리턴함");
        System.out.println(String.format("ob1 getClass = %s", ob1.getClass().getName()));    
        System.out.println(String.format("ob2 getClass = %s", ob2.getClass().getName()));
        System.out.println(String.format("ob3 getClass = %s", ob3.getClass().getName()));   


        System.out.println("hashcode(return instance addr val) Test");
        System.out.println("\t ob1 hashcode = " + ob1.hashCode() + ", " + Integer.toHexString(ob1.hashCode())); // -1220935282, b73a018e
        System.out.println("\t ob2 hashcode = " + ob2.hashCode() + ", " + Integer.toHexString(ob2.hashCode())); // 455659002, 1b28cdfa
        System.out.println("\t ob3 hashcode = " + ob3.hashCode() + ", " + Integer.toHexString(ob3.hashCode())); // 3, 3
    

        System.out.println("toString Test");
        System.out.println("\t ob1 toString = " + ob1.toString());  // hello, String 클래스 -> toString 메소드 재정의
        System.out.println("\t ob2 toString = " + ob2.toString());  // object.day7.Diamond@1b28cdfa
        System.out.println("\t ob3 toString = " + ob3.toString());  // Integer 클래스 -> toString 메소드 재정의
        System.out.println("\t ob1 toString = " + ob1); // hello        toString 메소드는 생략되고 실행됨.
        System.out.println("\t ob2 toString = " + ob2); // object.day7.Diamond@3af49f1c
        System.out.println("\t ob3 toString = " + ob3); // 3


        System.out.println("우리가 만든 클래스의 toString() 재정의 테스트");
        Shape sh2 = new Shape("undefinded", 25,20);
        Shape diamond = new Diamond();   // 새로운 도형이 만들어졌습니다. 초기화 필요합니다. 인스턴스의 Field 는 초기화하지 않아도 초기값이 0이다.0 
        Shape square = new Square();     // 새로운 도형이 만들어졌습니다. 초기화 필요합니다.
        Shape triangle = new Triangle("삼각형",20,30,65);

        System.out.println("\t sh2 = " + sh2);  // Shape [도형이름=undefinded, 너비=25, 높이=20][면적=500]
        System.out.println("\t diamond = " + diamond);      //  Diamond [27d6c5e0]
        System.out.println("\t square = " + square);        //  Shape [도형이름=null, 너비=0, 높이=0][면적=0] . 부모 클래스에서 정의한 toString() 메소드가 실행
        System.out.println("\t triangle = " + triangle);    //  Shape [도형이름=삼각형, 너비=20, 높이=30][면적=300] . Triangle 클래스에서 정의한 toString() 메소드가 실행



    }
}
