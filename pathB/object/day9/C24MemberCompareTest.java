package object.day9;

import java.util.Arrays;

public class C24MemberCompareTest {
    

    // Member 인스턴스끼리 비교하고 정렬하는 예제
    public static void main(String[] args) {
        
        Member momo = new Member("momo", 23);
        Member nana = new Member("nana", 20);

        System.out.println("모모와 나나를  이름 기준으로 비교 : ");
        System.out.println("\t " + momo.compareTo(nana));


        Member dahy = new Member("dahyeon", 21);
        Member sana = new Member("nana",22);

        Member[] members = new Member[4];
        members[0] = momo; members[1] = nana;   members[2] = dahy;  members[3] = sana;

        System.out.println("members 배열 : "+ Arrays.toString(members));

        Arrays.sort(members);
        System.out.println("정렬 후 memebers = " + Arrays.toString(members));


    }
}
