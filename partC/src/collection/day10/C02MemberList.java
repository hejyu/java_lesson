package collection.day10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class C02MemberList {

    public static void main(String[] args) {
        List<Member> list = new ArrayList<>();

        list.add(new Member("jisu", 23));
        list.add(new Member("jeny", 22));
        list.add(new Member("lisa", 25));
        list.add(new Member("rose", 25));
        list.add(new Member("sana", 26));


        System.out.println("현재 리스트  : " + list + ", 크기 : " + list.size());

        System.out.println(list.hashCode());
        System.out.println(list.get(4).equals(new Member("sana", 26)));

        // hashCode, equals 메소드 재정의 전과 후를 비교합니다
        // 컴파일러는 객체의 1)해쉬코드가 같으면 2)equals 를 검사합니다. 둘 다 통과하면 객체가 같다고 판단.
        //              ㄴ remove, indedOf 메소드에 동일 객체 검사할 때 사용 


        System.out.println("현재 리스트  : " + list + ", 크기 : " + list.size());

        System.out.println("특정 멤버 조회 : " + list.indexOf(new Member("sana", 23)));

        // new Member(sana, 23) 에서 인스턴스 필드값이 같다고 동일한 객체가 아닙니다.
        // remove, indexOf 등의 메소드는 동일한 객체를 찾아서 삭제하고 조회합니다.
        //  String은 문자열 리터럴이(내용) 같으면 주소가 같아서 찾을 수 있습니다.
        // 일반적으로, 만들어진 클래스는 hashcode 로 메모리 참조(주소) 위치가 결정됩니다. (hashcode 가 같으면 주소가 같은 객체)
        //              인스턴스 필드 내용이 같으면 hashcode를 동일하게 만들도록 재정의합니다


        // 정렬 함수형 인터페이스 람다식 복습
        list.sort((o1, o2) -> { return o1.getAge() - o2.getAge(); });
        System.out.println("나이 적은 순 정렬 후 list : " + list) ; //  [Member [이름=jeny, 나이=22], Member [이름=jisu, 나이=23], Member [이름=lisa, 나이=25], Member [이름=rose, 나이=25], Member [이름=sana, 나이=26]]

        list.sort((o1, o2) -> { return o1.getName().compareTo(o2.getName()); });
        System.out.println("abc 순 정렬 후 list : " + list) ; //  [Member [이름=jeny, 나이=22], Member [이름=jisu, 나이=23], Member [이름=lisa, 나이=25], Member [이름=rose, 나이=25], Member [이름=sana, 나이=26]]


        // List 의 static 메소드
        //      테스트용 데이터 생성시 많이 사용됨. 불변 객체
        List<String> list2 = List.of("jeny", "jisu","rose");
        System.out.println("name 리스트 : " + list2);

        // list2.add("xxxyyy");        // 변경 불가능 ImmutableCollections 



    }
}
