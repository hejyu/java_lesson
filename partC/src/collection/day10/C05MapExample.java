package collection.day10;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

import javax.swing.text.html.HTMLDocument.Iterator;


public class C05MapExample {
    /* 
     * Map < key, value > : key 값으로 value 를 가져오기. key와 value는 모든 타입이 Object 입니다.
     *                        key 는 중복된 값을 가질 수 없습니다. key와 value 모두 순서가 없습니다.
     *                        ㄴ 맵에 입력한 순서대로 접근해야 한다면 LinkedHashMap
     *                        ㄴ 또는 정렬(Key 기준) 된 방식으로 접근해야 한다면 TreeMap
     * Map 구성요소 Key Value 중에서 Key 는 Set의 특성을 가짐
     */
    public static void main(String[] args) {
        Map<String,String> map = new HashMap<>();
        // Map<String,String> map = new LinkedHashMap<>();
        // Map<String,String> map = new TreeMap<>();
        map.put("tw", "트와이스");
        map.put("nu", "뉴진스");
        map.put("as", "에스파");
        map.put("gr", "소녀시대");
        map.put("tw", "원더걸스");
        map.put("js", "뉴진스");
        System.out.println("map 의 크기 = " + map.size());
        System.out.println("map 에 저장된 문자열 = " + map);    // {as=에스파, tw=원더걸스, nu=뉴진스, js=뉴진스, gr=소녀시대}
        System.out.println("== Iterator 반복자를 이용한 set 의 값 가져오기 ==");
        Scanner sc = new Scanner(System.in);
        System.out.println("map 의 크기 = " + map.size());
        System.out.println("map 에 저장된 문자열 = " + map);

        while(true) {
            System.out.println("찾을 값에 대한 key 입력하세요 >>> ");
            // String key = sc.nextLine();
            String key = "end";
            if(key.equals("end")) { // end 입력하면 while 종료
                break;
            }

            System.out.println("당신이 원하는 key 값 = " + map.get(key));
        }



        System.out.println("== Iterator 반복자를 이용한 set 의 값 출력 == ");
        System.out.println("\t map.keySet()  ?  " + map.keySet());      // map key 를 이용해 생성
        java.util.Iterator<String> iterator = map.keySet().iterator();      // key 값으로 반복자를 생성합니다.
        int cnt = 0;
        while(iterator.hasNext()) {
            String temp =iterator.next();
            System.out.println(String.format("count=%d , key= %s , value=%s", 
                                                                                    cnt++,
                                                                                    temp,       // key 
                                                                                    map.get(temp)));    // value
         }


         System.out.println("== for 반복자를 이용한 set 의 값 출력 == ");

        for (String key : map.keySet()) {
            System.out.println(String.format("count=%d , key= %s , value=%s", 
                                                    cnt++,
                                                    key,       // key 
                                                    map.get(key)));    // value
         
        }
        System.out.println("map.values() ? " + map.values());   //  [에스파, 원더걸스, 뉴진스, 뉴진스, 소녀시대]
        // 조회
        System.out.println("map.containsKey() ? " + map.containsKey("as"));     // true
        System.out.println("map.containsValue() ? " + map.containsValue("블랭핑크"));       // false
        
   
        
    }
      
}
