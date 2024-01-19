package object.day9_interface;

import java.util.Arrays;
import java.util.Comparator;

public class C21ArraySortTest {

    public static void main(String[] args) {
        int[]  numbers = {67,34,77,89,82};

        System.out.println("numbers = " + Arrays.toString(numbers));
        Arrays.sort(numbers);
        System.out.println("정렬 후 numbers = " + Arrays.toString(numbers));

        String[] names = {"momo", "nayeon", "dayeon", "Zewi", "Bio"};

        System.out.println("초기 names = " + Arrays.toString(names));
        Arrays.sort(names);
        System.out.println("정렬 후 names = " + Arrays.toString(names));

        // Array.sort(배열변수) : 기본형 배열, String 배열 오름 차순 정렬 가능
        // -> 내림 차순 정렬 또는 다른 참조타입에 대한 정렬은 두 번째 인자로 정렬 기준 공식을
        //   인터페이스로 전달합니다.

        // 순차정렬 알고리즘    : 가장 기본적인 알고리즘.

        // 내림차순 정렬 - Comparator 는 <> 제너릭타입에 기본형을 참조할 수없다
        //                  기본형데이터는 Wrapper 객체를 사용
        Integer[] numbers2 = {67,34,77,89,92};

        // 람다식 예시 
        // (인자1,인자2) ->//화살표 {//body}
        Arrays.sort(numbers2, (o1, o2) -> {
                // 내림차순 리턴
                return o2 - o1;
        });

        System.out.println("내림차순 정렬 후 numbers2 : " + Arrays.toString(numbers2));





    }
}
