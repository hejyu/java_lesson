package basic.day4;

import java.util.Scanner;

// Google Drive 제출 
public class A26Test25 {

    // A22 번 1) ~ 5) 번을 메소드로 작성해보기  - 메소드에 출력함수 사용하지 않음
    // 1) sumToN    2) multiplyToN  3) sumMToN  4) mutiplyMToN 5) multiplayNof2
    // 6) 구구단 출력 메소드, 리턴은 void, printGuguDan
    public static void main(String[] args) {
        long res = A25MySampleMethod.sumMToN(10, 13);
        System.out.println(res);

        // 메소드가 private 으로 정의되면 다른 클래스에서 사용 불가능
        //  A25MySampleMethod.checkJumsu(67);    // 오류 

        // 자바 ( 또는 다른 프로그래밍 언어) 로 코드를 작성할 때
        // 1. 자바에서 제공하는 클래스와 메소드를 잘 활용하기
        // 2. 필요에 따라 개발자가 직접 잘 만들어서 사용하기

        Scanner sc = new Scanner(System.in);

        System.out.println("시작값 입력 : ");
        int start = sc.nextInt();

        System.out.println("마지막 값 입력 : ");
        int end = sc.nextInt();

        System.out.println(String.format("%d ~ %d 까지 곱하기 => %d", start, end, A25MySampleMethod.mutiplyMToN(start, end)));

    }

    




}
