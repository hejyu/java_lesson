package object.day8;

public class Puppy extends Animal {
	public static final String TYPE ="강아지 ";
	
	public Puppy() {
	}
	
	public Puppy(String name, String color) {
		super(name,color);		// 부모클래스 생성자를 호출, 인자를 전달(생략시 부모의 생성자(인자1, 인자2) 호출 불가능)
	}
	
	
	@Override
	public void sound() {
		System.out.println(this.color +" 강아지는 멍멍 🐶🐶하고 짖습니다. ");

	}

	@Override
	public String toString() {
		return TYPE+"[color=" + color + ", name=" + name + "]";
	}


	// toString을 재정의 하지 않으면 부모 toString이 실행되고 부모의 TYPE 상수값을 출력

}
