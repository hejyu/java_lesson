package basic.day3;

import java.text.DecimalFormat;
import java.util.Scanner;

//switch 는 if 조건식이 equal (==) 을 여러번 검사하는 경우에 사용.
//		   조건식에서 검사하는 값은 정수(byte,short,int,long), char, 문자열 형식만 가능합니다.
public class A20BankExam {

	public static void main(String[] args) {

		int menu;
		int money;	// 입금액 또는 출금액
		int balance = 0;	// 잔액
		boolean run = true;

		Scanner sc = new Scanner(System.in);
		DecimalFormat df = new DecimalFormat("#,### 원");
		while (run) {
			System.out.println("--------------------------------------");
			System.out.println("1:예금 |  2:출금  |  3.잔액  |  4.종료");
			System.out.println("--------------------------------------");
			System.out.print("메뉴 선택 >>>> ");
			menu = sc.nextInt();

			switch (menu) {
				case 1:
					System.out.println(String.format("예금액 >"));
					money = sc.nextInt();
					balance += money;
					
					System.out.println(String.format("고객님의 잔액은 %s입니다", df.format(balance)));
					break;
				case 2:
					System.out.println("출금액 >");
					money = sc.nextInt();

					if(balance < money)
						System.out.println("잔액이 부족합니다.");
					else
						balance -= money;
					
					System.out.println(String.format("고객님의 잔액은 %s입니다",  df.format(balance)));
					break;
					
				case 3:
					System.out.println(String.format("현재 잔고 : %s",  df.format(balance)));
					break;
				case 4:
					System.out.println("종료 입니다.");
					run = false;
					break;
				default:   //값이 1,2,3,4 모두 아닌경우
					System.out.println("잘못된 선택 입니다.");
					break;
			}   //switch 끝
		}

	} //main 끝

} //class end
