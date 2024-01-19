package basic.day4;

import java.util.Arrays;
import java.util.Scanner;

// 문자열은 문자의 집합
// 문자열 구성하는 문자 하나씩 가져와 배열에 저장
public class A28CharArray {
	
	public static void main(String[] args) {
		
		String message = "Hello~ World 자바는 맛있다.";

		// 배열의 길이 지정, 문자열의 길이
		char[] messageArray = new char[message.length()];

		for(int i=0 ; i < message.length() ; i++){
			char temp = message.charAt(i);
			System.out.println(temp);
			messageArray[i] = temp;
		}

		// char 배열의 특징. 배열 이름을 출력시 문자열을 출력
		System.out.println(messageArray);	// Hello~ World 자바는 맛있다.


		// 고대 암호 : 	'모모'가 '나연'에게 비밀 메시지를 보냄. 암호문을 만듬
		// 				두 사람이 알고 있는 비밀키는 key=7	. 암호문은?

		int key = 7;
		for(int i=0; i < message.length() ; i++){
			messageArray[i] += key;
		}

		System.out.println("~~~~~~모모가 나연이에게 보낸 메시지");
		System.out.println(messageArray);

		System.out.println("~~~~~~ 나연이는 메시지를 받고 암후문을 풀었습니다.");
		key = -7;
		for(int i=0; i < message.length() ; i++){
			messageArray[i] += key;
		}
		System.out.println(messageArray);
	}

}
