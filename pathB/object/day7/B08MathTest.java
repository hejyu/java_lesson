package object.day7;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 자바의 기본 패키지는 java.lang 입니다
 * 지금 테스트할 Math 클래스는 java.lang에 속하여 import 필요없으나
 * Scanner 클래스와 같이 java.util 등 다른 채키지에 속한 클래스는 import 를 해야합니다.
 *          ㄴ import를 통해 이 프로그램에서 사용할 클래스를 메모리에 올립니다.
 * 이 예제는 Math 클래스의 메소드를 통해서 메소드 오버로딩을 다시 확인해 봅니다.
 */
public class B08MathTest {

    public static void main(String[] args) {
        System.out.println("1.최대값 max, 최소값 min 구하기 - 메소드 오버로딩 ");
        System.out.println("Math.max(56,12) ="+ Math.max(56,12));       // 인자와 리턴타입이 정수
        System.out.println("Math.max(56.34,99.123)="+ Math.max(56.34,99.123));  // 인자와 리턴타입이 실수
        int min = Math.min(45, 56);
        //double dmin = Math.min(45, 56);   //자동 캐스팅
        double dmin = Math.min(56.78, 111.44);
        //int imin = (int)Math.min(56.78, 111.44);      //강제 캐스팅
            
        System.out.println("min = "+min);
        System.out.println("dmin = "+dmin);

        System.out.println(String.format("3개의 정수 34, 56, 12 의 최대값  >>>",  Math.max(Math.max(34, 56),12)));
        System.out.println(String.format("3개의 정수 34, 56, 12 의 최솟값  >>>",  Math.min(Math.min(34, 56),12)));

        //Math클래스에서 기본 수학 공식을 해결하는 메소드(제곱근, 지스, 반올림, 올림, 내림...)를 제공합니다
        //복습 : static 메소드는 클래스의 객체생성하지않고 바로 클래스 이름으로 실행되는 메소드다


        //************************************************************************** */

        int[] iArr1 = {0,1,2,3,4,5,6};
        int sum=0;
        for (int i=0 ; i <iArr1.length ; i++ ) {
            
            sum += iArr1[i];
        }

        System.err.println(sum);

        String s = "hi_my_Name_is_3";
        String[] sArr1 = s.split("_");
        System.out.println(Arrays.toString(sArr1));
        
        List<String> list = Arrays.asList(sArr1);
        Collections.reverse(list);
        
        String[] sArr2 = list.toArray(sArr1);
   















    }
}
