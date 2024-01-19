package basic.day2;

public class A08PreViewTest {

    public static void main(String[] args){
        char start = 'A';   // code 값 65
    
        // while 맛보기 : ... 하는 동안에 
        while (start <= 'Z') {  // code 값 90
            System.out.print(start++);
        }
        System.out.println();
        while (start > 'A') {
            System.out.print(--start);
        }
    }    
}
