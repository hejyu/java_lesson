package collection.day10;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class C03MemberListPrint {

    public static void main(String[] args) {
        List<Member> list = new ArrayList<>();

        list.add(new Member("jisu", 23));
        list.add(new Member("jeny", 22));
        list.add(new Member("lisa", 25));
        list.add(new Member("rose", 25));
        list.add(new Member("sana", 26));

        //toString 재정의된 출력을 사용하지 않고 list 리스트 이름과 나이 출력
        System.out.println(String.format("1234567890123456789012345678901234567890123456789012345678901234567890" ));
                    
        System.out.println(String.format("%15s \t %15s", "name", "age" ));
        for(int i=0; i<list.size(); i++) {
            Member temp = list.get(i);
            System.out.println(String.format("%15s \t %15d", temp.getName(), temp.getAge()));
            System.out.println(String.format("%15s \t %15d", list.get(i).getName(), list.get(i).getAge()));
        }

        //컬렉션에서는 반복자 Iterator 를 이용해 요소에 접근합니다
        //Iterator 이용은 인덱스가 없는 자료구조가 많이 씀(인형 뽑기같은 방식)
        System.out.println("~~~~~~~~~ 반복자를 이용한 출력 ~~~~~~~~~");
        Iterator<Member> info = list.iterator();            // List 로 선언된 자료구조에 접근하는 Iterator 인터페이스 선언
        int count = 0;      
        while(info.hasNext()){                              // Iterator 가 접근할 다음 요소가 있으면 true를 리턴
            Member temp = info.next();                      // Iterator 가 다음 요소 값을 가져옵니다
            System.out.println("\t count = "+count++ +", 요소= "+temp);
        }


        // 향상된 for 문: Iterator 를 이용해 작동
        System.out.println("~~~~~~~~~  향상된 for 문: Iterator 를 이용해 작동  출력 ~~~~~~~~~");
        count = 0;
        for (Member temp : list) {
            System.out.println("\t count = "+count++ +", 요소= "+temp);
        }

    }
    
}
