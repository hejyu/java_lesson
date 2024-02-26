package collection.day10;

import java.util.ArrayList;
import java.util.List;

public class C01ListExample {

    public static void main(String[] args) {
        List<String> strList = new ArrayList<>();
        // ArrayList : List 인터페이스를 구현한 클래스

        strList.add("Twice");           // index 0
        strList.add("ITZY");
        strList.add("IVE");
        strList.add("Wonder Girls");
        strList.add("New Jeans");       // index 5

        System.out.println("문자열 LIST strList size : " + strList.size());     // 5
        System.out.println("\n 데이터 추가");
        strList.add("LSERAPIM");        // index 6

        System.out.println("항목 추가 후 strList 리스트 : " + strList);         // [Twice, ITZY, IVE, Wonder Girls, New Jeans, LSERAPIM]
                                                                               //  ㄴ ArrayList 클래스의 toString 제정의 메소드 실행
        System.out.println("\n 데이터 삭제");
        strList.remove("Wonder Girls");
        strList.remove(1);

        System.out.println("항목 삭제 후 strList 리스트 : " + strList);     // [Twice, IVE, New Jeans, LSERAPIM]

        // add set 메소드 비교
        System.out.println("\n 데이터 변경");
        strList.add(1, "????");     // 중간삽입 (추가)
        System.out.println("항목 변경 후 strList 리스트 : " + strList);     // [Twice, ????, IVE, New Jeans, LSERAPIM]

        strList.set(2, "!!!");      // 수정
        System.out.println("항목 변경 후 strList 리스트 : " + strList);     // [Twice, ????, !!!, New Jeans, LSERAPIM]


        // 특정 위치의 요소 가져오기
        System.out.println("\n 특정 위치의 요소 가져오기");
        System.out.println("strList.get(0) " + strList.get(0));     // Twice
        System.out.println("strList.get(3) " + strList.get(3));     // New Jeans
        // System.out.println("strList.get(9) " + strList.get(9));     // 요소 없음!! Exception in thread "main" java.lang.IndexOutOfBoundsException: Index 9 out of bounds for length 5

        
        List<String> strList2 = new ArrayList<>();
        strList2.add("TXT");    strList2.add("BLACK PINK");
        System.out.println("\n List의 addAll 메소드 테스트");
        System.out.println(strList.addAll(strList2));  // true
        System.out.println("항목 변경 후 strList 리스트 : " + strList);     // [Twice, ????, !!!, New Jeans, LSERAPIM, TXT, BLACK PINK]

        strList.add("!!!");      // 중복값 저장 가능 !!
        System.out.println("항목 변경 후 strList 리스트 : " + strList);     // [Twice, ????, !!!, New Jeans, LSERAPIM, TXT, BLACK PINK]


        System.out.println("\n List의 contanis indexOf lastIndexOf 메소드 테스트");
        System.out.println(strList.contains("IVE"));  // true
        System.out.println(strList.contains("New Jeans"));  // true
        System.out.println(strList.indexOf("New Jeans") + " => " + strList.get(strList.indexOf("New Jeans")));      // 3
        System.out.println(strList.lastIndexOf("IVE"));          // -1
        
        strList.add("IVE");
        System.out.println(strList.indexOf("IVE") + " => " + strList.get(strList.indexOf("IVE")));          //4
        
        System.out.println("\n\n리스트에서 항목 찾기");
        System.out.println("\t 리스트에 처음 `!!!` 어디 있음? " + strList.indexOf("!!!"));
        System.out.println("\t 리스트에 마지막 `!!!` 어디 있음? " + strList.lastIndexOf("!!!"));
        System.out.println("\t 리스트에 `블랭핑크` 있음? " + strList.contains("BLACK PINK"));
        System.out.println("\t 리스트에 `블랭핑크` 어디 있음? " + strList.indexOf("BLACK PINK"));



    }
    
}

/* 
 * List  구현 특징  
 *  - 인덱스를 가짐(데이터의 순서가 있다는 의미)
 *  - 삭제, 조회, 추가 가능
 *  - 조회 관련 조작 가능 
 * 
 */
