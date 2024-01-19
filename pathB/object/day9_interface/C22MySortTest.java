package object.day9_interface;

import java.util.Arrays;

public class C22MySortTest {
    
    public static void main(String[] args) {
        int[] numbers = {67,34,65,89,54};
        System.out.println("초기 numbers : " + Arrays.toString(numbers));
    
        try {
            for(int i=0; i < (numbers.length-1);i++){
                
                for(int j=i+1; j< numbers.length ;j++) {
                    int temp;       // 빈 공간 생성
                    if(numbers[i] > numbers[j]) {   // numbers[i]가 numbers[j] 보다 작거나 같지 않을때 i와 j를 교환
                        temp = numbers[j];          // 빈 공간을 생성해서 작은 숫자(j)를 저장
                        numbers[j] = numbers[i];    // j에 더 큰 숫자(i) 의 값을 대입
                        numbers[i] = temp;          // i에 작은 숫자 대입
                    }
                }
            }    
            
        } catch (Exception e) {
            System.out.println(e);
        } 

        

        System.out.println("오름차순  정렬 후 numbers : " + Arrays.toString(numbers));

        System.out.println("내림차순  정렬 전 numbers : " + Arrays.toString(numbers));
        try {
            for(int i=0; i < (numbers.length-1);i++){
                
                for(int j=i+1; j< numbers.length ;j++) {
                    int temp;       // 빈 공간 생성
                    if(numbers[i] < numbers[j]) {   // numbers[i]가 numbers[j] 보다 크거나 같지 않을때 i와 j를 교환
                        temp = numbers[j];          // 빈 공간을 생성해서 작은 숫자(j)를 저장
                        numbers[j] = numbers[i];    // j에 더 큰 숫자(i) 의 값을 대입
                        numbers[i] = temp;          // i에 작은 숫자 대입
                    }
                }
            }    
            
        } catch (Exception e) {
            System.out.println(e);
        }

        System.out.println("내림차순  정렬 후 numbers : " + Arrays.toString(numbers));
    }
}
