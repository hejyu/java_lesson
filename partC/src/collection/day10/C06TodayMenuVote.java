package collection.day10;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;     // Map 안에서 구성요소로 정의된 Entry 내부 클래스
import java.util.Scanner;
import java.util.Set;

public class C06TodayMenuVote {

    //Map 연습
    public static void main(String[] args) {
        String menu = "chicken, spaghetti, gochang, bulgogi, pork belly";

        Map<String, Integer> map = new LinkedHashMap<>();
        map.put("chicken",0);
        map.put("spaghetti",0);
        map.put("gochang",0);
        map.put("bulgogi",0);
        map.put("pork belly",0);
        System.out.println(map);

        System.out.println("오늘의 메뉴 투표해요");
        System.out.println("메뉴 : " + menu);       // chicken, spaghetti, gochang, bulgogi, pork belly
        Scanner sc = new Scanner(System.in);   
        while(true) {
            System.out.println("영문 메뉴 이름 입력 ==== ");
            String key = sc.nextLine();

            if(key.equals("end")) break;
            int cnt = 0;
            if(map.containsKey(key)){       // 선정된 메뉴에 입력한 메뉴가 포함되는지 검사
                map.put(key, map.get(key)+1);   
            }else{
                System.out.println("투표에 없는 메뉴이군요. 추가하겠습니다~~");
                map.put(key, 1);    // 새로운 메뉴 추가
                menu  += ", " + key;        // 메뉴 문자열 수정

            }   
            
        }

        System.out.println("투표를 종로합니다");
        System.out.println(map);


        // value 최대값의 key 구하기        // Key, Value 한쌍으로 만든 타입 Entry 
        Comparator<Entry<String, Integer>> comparator = (o1, o2) -> {
            return o1.getValue() - o2.getValue();       // 득표 많은 순으로 정렬
        };

        Entry<String,Integer> maxEntry = Collections.max(map.entrySet(), comparator);

        System.out.println("최다 득표  결과 ");
        System.out.println("\t 메뉴 이름 : " + maxEntry.getKey());
        System.out.println("\t 메뉴 이름 : " + maxEntry.getValue());


    }
    
}
