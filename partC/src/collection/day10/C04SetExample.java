package collection.day10;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class C04SetExample {
    
    
    public static void main(String[] args) {
        
        // Set<String> set = new HashSet<>();
        // Set<String> set = new LinkedHashSet<>();     // "아이브" 요소 생성시  "트와이스"의 주소를 가지고 있음 -> 참조값을 이용해 중복값비교 
        Set<String> set = new TreeSet<>();              // 가나다 abc 순 정렬
        //이진트리 알고리즘을 이용해 데이터를 정렬된 방식으로 접근
        set.add("가나");
        set.add("트와이스");
        set.add("아이브");
        set.add("블랭핑크");
        set.add("뉴진스");
        set.add("트와이스");
        set.add("잇지");
        set.add("잇지");
        set.add("소녀시대");
        
        int size = set.size();
        System.out.println(" set.size() = " +  size );      // 6 (똑같은 데이터는 제외)
        
        System.out.println(" 요소에 한 개씩 접근");
        for (String idol : set) {
            System.out.println("\t set 요소 : " + idol);
        }
    
    }

}

/* 
 * Set 집합 : 수학시간에 배운 집합
 *  - 인덱스(순서)가 없음
 *  - 중복값이 없음
 * Map 의 구성요소 : Key, Value 중에서 Key는 Set 의 특성
 */