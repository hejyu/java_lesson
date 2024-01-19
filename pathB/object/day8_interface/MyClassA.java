package object.day8_interface;

//인터페이스 InterfaceA를 사용하는 구현 클래스 
// -> 인터페이스의 추상 메소드 반드시 작성!!
// -> 인터페이스의 객체가 생성됨
public class MyClassA implements InterfaceA {
//InterfaceA 의 추상메소드는 반드시 구현해야한다.
	
	// 오버라이드는 상속 관계에서 쓰는 표현
	// 인터페이스 에서는 구현이라는 표현이 맞습니다
	@Override
	public void methodA() {
		System.out.println("나는 methodA !!");
	}
	
	@Override
	public int methodB(int num) {
		System.out.println("나는 methodB !! " + num);
		return num;
	}
	
	
	//InterfaceA 의 static 메소드를 별도로 정의할 수 있습니다.
	//이름이 같아도 override 로 처리하지 않습니다.
	// ㄴ static 이므로.
	public static void methodD() {
		
	}
}
