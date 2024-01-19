package basic.day4;

import java.util.Arrays;
import java.util.Scanner;

//배열 기본
public class A27ArrayBasic {
	// 괄호의 종류 : () 소괄호 => 메소드에서 사용
	//				{} 증괄호 => 블록(영역)을 만듬
	//				[] 대괄호 => 배열정의에 쓰임(초기화시에는 중괄호 사용)
	//				
	public static void main(String[] args) {
		
		//int age=23;  과 같은 변수선언 1개당 1개의 메모리 할당.
		
		//배열은 여러개의 데이터를 저장할 수 있는 변수.  저장할 데이터의 형식/이름/데이터의 개수(할당 받는 메모리 크기)를 선언해야 함.
		//	 index : 배열의 데이터 중 특정 위치를 표현
		int[] arr1 = {34,56,78,89,65};		//선언방법 1. 저장할 값 초기화 //인덱스는 0부터 4
		int[] arr2 = new int[2];		//초기값은 기본값 0 , 정수 10개 (40바이트 할당), 인덱스 0~9
		int sum = 0;
		int count = 0;

		//배열의 주요 속성 : length 는 배열의 길이(개수)를 갖습니다.
		System.out.println("배열의 크기를 구하는 속성 length 테스트 ");
		System.out.println(String.format("arr1 배열의 크기 : %d", arr1.length));
		System.out.println(String.format("arr2 배열의 크기 : %d", arr2.length));
		System.out.println("==인덱스 직접 지정해서 배열 요소값 출력하기 ==");
		System.out.println("i=0, arr1[0]=" + arr1[0]);	// 34, [] 기호 안에는 인덱스 정수 값 작성
		System.out.println("i=1, arr1[1]=" + arr1[1]);	// 56
		System.out.println("i=2, arr1[2]=" + arr1[2]);	// 78
		System.out.println("i=3, arr1[3]=" + arr1[3]);	// 89
		System.out.println("i=4, arr1[3]=" + arr1[4]);	// 65
		System.out.println();
		System.out.println("i=0, arr2[0]=" + arr2[0]);	// 013
		
		//배열에 저장된 값은 성적,포인트,이름 등등 같은 의미를 갖는 데이터들이며 따라서 처리 해야할 동작도 같습니다. => 반복문 필수
		System.out.println("\n~~~~~1. 반복문으로 배열 요소값 출력하기 ~~~~~");
		for(int i =0; i < arr1.length; i++){
			System.out.println(String.format("i = %d, arr1[%d] = %d",i, i,arr1[i] ));
		}
		System.out.println();
		for(int i =0; i < arr2.length; i++){
			System.out.println(String.format("i = %d, arr2[%d] = %d",i, i,arr2[i] ));
		}


		System.out.println("\n~~~~~2. arr1 배열의 합계 구하기 ~~~~~");
		for(int i =0; i < arr1.length; i++){
			sum  += arr1[i];
		}

		System.out.println(String.format("arr1 배열의 합계 :  %d", sum));
		
		
		System.out.println("\n~~~~~3. arr1 배열의 70이상 값 개수 구하기 ~~~~");
		
		for(int i =0; i < arr1.length; i++){
			if(arr1[i] >= 70){
				count++;
			}
		}
		System.out.println(String.format("%d 개", count));
		

		System.out.println("\n~~~~~4.arr2배열에 키보드 입력으로 값 저장하기~~~~~");
		Scanner sc = new Scanner(System.in);
		for(int i = 0 ; i < arr2.length ; i ++){
			System.out.println(String.format("arr2[%d] 번째 값 입력 : ", i));
			arr2[i] =  sc.nextInt();
		}
				
	
		
		printArray(arr2);	// arr2는 배열의 이름 => 배열의 시작주소
		System.out.println();
		printArray(arr1);	// 메소드가 실행될때 배열의 시작주소를 전달
	
		// 메모리에 전달되는 데이터는 주소를 가집니다.
		System.out.println(arr1);		// [I@10f87f48, arr1 배열의 이름은 배열의 시작 주소
		System.out.println(arr2);		// [I@b4c966a, arr2 배열의 이름은 배열의 시작 주소

	}

	// 배열 요소의 값을 출력
	private static void printArray(int[] arr) {	// 전달받은 배열의 시작주소로 데이터를 가져옴
		
		for(int i =0; i < arr.length; i++){
			System.out.println(String.format("i = %3d, array[%d] = %3d", i, i, arr[i] ));
		}

	}
}
