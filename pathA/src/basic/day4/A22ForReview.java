package basic.day4;


//for문 복습: 1) ~ 5) 까지 작성.    6)구구단 출력(for in for)
public class A22ForReview {
    public static void main(String[] args) {
        int n,m;
        int sum = 0;
        int result = 1;     


        //1) 1부터 정수 n까지 더하기
        n=200000;
        long longSum = 0;
        for(int i = 0 ; i <= n ; i++){
            longSum += i;
            
        }
        System.out.println(String.format("문제1) 1부터 %d까지의 합계 : %,d", n, longSum));


        //2) 1부터 정수 n까지 곱하기
        //int 타입은 정수 -2147483648 ~ +2147483648 
        // 범위가 큰 데이터에는 long 타입을 사용
        // -5,968,160,532,966,932,480 => - 음수 값이 나오는 것, 오버플로우
        long longResult = 1;
        n=28;
        for(int i = 1 ; i <= n ; i++){
            longResult *= i;
            
        }
        System.out.println(String.format("문제2) 1부터 %d까지의 곱하기 : %,d", n, longResult));

        //3) 시작값 정수 m부터 마지막 값 n까지 더하기
        m=100000000;
        n=200000000;
        longSum = 0;
        for(int i = m ; i <= n ; i++){
            sum += i;
        }

        System.out.println(String.format("문제3) %d부터 %d까지의 더하기 : %d", m, n, sum));

        //4) 시작값 정수 m부터 마지막 값 n까지 곱하기
        m=1;
        n=5;
        longResult = 1;
        for(int i = m ; i <= n ; i++){
            result *= i;
        }
        
        System.out.println(String.format("문제4) 시작값 정수 m부터 마지막 값 n까지 곱하기 : %d", m, n, result));

        //5) 2의 n의 제곱 구하기 : 2를 n번 곱하기(2진수에서 많이 사용되는 연산)
        n=53;
        longResult = 1;
        for(int i = 1 ; i <= n ; i++){
            longResult *= 2;
        }
        
        System.out.println(String.format("문제5) 2의 n의 제곱 구하기 : 2를 %d번 곱하기 : %,d",  n, longResult));
        //1) 1부터 정수 n 까지 더하기
        //2) 1부터 정수 n 까지 곱하기
        //3) 시작값 정수  m 부터 마지막값 n까지 더하기
        //4) 시작값 정수  m 부터 마지막값 n까지 곱하기

        //5) 2의 n의 제곱 구하기 : 2를 n번 곱하기(2진수에서 많이 사용되는 연산)


    }
}
