package object.day8_interface;


// CharSequence 는 자바에서 만든 인터페이스
public class B18CharSequenceTest {

    public static void main(String[] args) {
        CharSequence cssr = new String("Hello java");
        CharSequence cssb = new StringBuilder("Hi 자바");


        String temp = "Java Hello~ Hi Java";
        
        System.out.println("charsequce 타입을 인자로 하는 메소드 확인");
        // constains : temp 객체에 cssr 객체 문자열 값이 포함되어 있는가?
        System.out.println("constains : temp 객체에 cssr 객체 문자열 값이 포함되어 있는가?");
        System.out.println(temp.contains(cssb)); // false
        System.out.println(temp.contains(cssr)); // false
        System.out.println(temp.contains("Hello"));     // true


    }
}
