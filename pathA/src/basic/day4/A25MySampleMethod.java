package basic.day4;


// Google Drive 제출 
public class A25MySampleMethod {

    // A22 번 1) ~ 5) 번을 메소드로 작성해보기  - 메소드에 출력함수 사용하지 않음
    // 1) sumToN    2) multiplyToN  3) sumMToN  4) mutiplyMToN 5) multiplayNof2
    // 6) 구구단 출력 메소드, 리턴은 void, printGuguDan
    public static void main(String[] args) {
        int num = 10;
        int end = 11;

        long result = sumToN(num);
        System.out.println(String.format("sum to %d = %,d",num, result));
        
        result = multiplyToN(num);
        System.out.println(String.format("multiply to %d = %,d",num, result));
        
        result = sumMToN(num, end);
        System.out.println(String.format("sum %d to %d = %,d",num, end, result));

        result = mutiplyMToN(num, end);
        System.out.println(String.format("multiply %d to %d = %,d",num, end, result));

        result = multiplayNof2(num);
        System.out.println(String.format("multiply %d = %,d",num, result));
    
        printGuguDan();


        int res = addToN(2,5);
        boolean check = checkJumsu(287);
        
    }

    private static boolean checkJumsu(int i) {
        return i>=0 && i<=100;
    }

    private static int addToN(int i, int j) {
        int sum = 0;

        for(int k = 0; k <= j ; k++) {
            sum += k;
        }

        return sum;
    }

    //1) 1부터 정수 n까지 더하기
    public static long sumToN(int count) {
        long sum = 0;
        
        for(int i = 0; i <= count; i++){
            sum += i;
        }

        return sum;
    }
  
    //2) 1부터 정수 n까지 곱하기
    public static long multiplyToN(int count) {
        long result = 1;
        
        for(int i = 1; i <= count; i++){
            result *= i;
        }
        
        return result;
    }

    //3) 시작값 정수 m부터 마지막 값 n까지 더하기
    public static long sumMToN(int  start, int end) {
        long sum = 0;
        
        for(int i = start; i <= end; i++){
            sum += i;
        }
        
        return sum;
    }
   
    //4) 시작값 정수 m부터 마지막 값 n까지 곱하기
    public static long mutiplyMToN(int  start, int end) {
        long result = 1;
        
        for(int i = start; i <= end; i++){
            result *= i;
        }
        
        return result;
    }

    //5) 2의 n의 제곱 구하기 : 2를 n번 곱하기
    public static long multiplayNof2(int count) {
        long result = 1;
        
        for(int i = 1; i <= count; i++){
            result *= 2;
        }
        
        return result;
    }

    //6) 2의 n의 제곱 구하기 : 2를 n번 곱하기
    public static void printGuguDan() {
        for (int i = 2; i <= 9; i++){
            for(int j = 1; j <= 9; j++){
                System.out.println(String.format("%3d * %3d = %3d", i,j,i*j));
            }
            System.out.println();
        }
    }





}
