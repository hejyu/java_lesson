package object.day7;

import java.util.Scanner;

public class B07ConstructorExam {
    
    /* 자바 클래스의 생성자로 메소드 오버로딩 알아보기 
     * `    -String 클래스 
     * 
     */
    
    public static void main(String[] args) {
        
        // 문자열 리터럴은 message변수로 참조 
        String message = "Hello~";
        String temp = "Hello~";

        //문자열 객체 생성하기 
        //1) 메소드 오버로딩 : 메소드  이름이 같으면서 리턴타입과 인자의 개수와 형식을 다르게 정의
        String str1 = new String(); // 생성자 인자 없음
        String str2 = new String("Hello~"); // 생성자 인자 1개-문자열리터럴
        String str3 = new String(new char[]{'h','e','l','l','l','o'});  // 생성자 인자 여러개 -문자 배열
        
        System.out.println(str1);   //길이가 0인 객체 
        System.out.println(str2);
        System.out.println(str3);

        //2)문자열 리터럴의 특징: 문자열 내용이 같으면 또 메모리 새로 저장하지 않는다

       /*message가 참조하는  "Hello~"가 동일한 리터럴을 temp가 참조할 때, 
        "Hello~"를 또 저장해서 temp를 참조하지 않고 이미 저장되어있는 "Hello~"를 참조*/
        System.out.println((message==temp));    //true : 참조값 비교, 즉, message와 temp는 기억장소가 동일하다 
        System.out.println((message==str2));    //False :  단, new 연산으로 생성된 객체는 언제나 매모리 새로 할당한다 
        
        //3) 문자열 내용 비교 : equals메소드
        System.out.println(message.equals(temp));//true
        System.out.println(message.equals(str2));//true

        Scanner sc =new Scanner(System.in); //InputStream 클래스로 만들어진 객체 System.in을 생성자 인자로 하여 객체를 생성
        // System.in은 키보드 입력을 원초적인 방법으로 처리한다 
        // 키보드 입력값을 다양하게 처리 할수있는 Scanner 클래스 사용

        int num = sc.nextInt();         //입력값을 정수 형식으로 변환
        double pi = sc.nextDouble();    //입력값을 실수 형식으로 변환
        sc.nextLine();                  // 키보드 입력을 저장하는 버퍼에서 실수 입력의 숫자 뒤에 엔터 친것이 남아있으므로 처리하기 
        String name = sc.nextLine();    //입력값을 문자열 형식으로 변환
        // nextInt, nextDouble는 엔터처리를 안하므로 sc.nextLine(); 을 일일이 써야한다. 
        // -> 이렇게 sc.nextLine() 넣어야되는 번거러움을 해결하기 위해 쓴 방법은 
        temp = sc.nextLine();           

        num = Integer.parseInt(temp);   //문자열을 int로 변환하는 메소드
        temp = sc.nextLine();           
        pi = Double.parseDouble(temp);    //문자열을 double로 변환하는 메소드

        



    }
    
}
