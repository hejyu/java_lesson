package object.day8;


public abstract class Animal {
	public static final String TYPE ="동물";	//상수 Type 문자열
	
	//필드: 공통적인 특성
	protected String color;
	protected String name;    //동물 이름 예)마루
	
	//생성자
	public Animal() {
		// 동작 확인용 출력문
		System.out.println("☆새로운 반려동물 가족이 생겼습니다.☆");
	}
	

	public Animal(String name,String color) {
		this();		//기본생성자의 메소드를 호출합니다
		this.name=name;
		this.color=color;
	}
	
	//추상메소드: 자식클래스들이 공통적으로 가져야할 기능
	//				ㄴ 자식클래스들은 반드시 재정의하도록 강요하는 것
	//				ㄴ 추상메소드가 있는 클래스는 반드시 abstarct class 로 정의
	//				ㄴ 추상메소드는 실행코드를 작성하지 않고 선언만 함
	//				ㄴ 부모는 자식을 위한 형식만 정의함  (추상화)
	//				ㄴ 자식클래스에서 실체화함. 부모 클래스 이름으로는 메소드 사용 불가능 
	public abstract void sound();
	
	
	// getter,
	public String getColor() {
		return this.color;
	}

	public String getName() {
		return name;
	}
	
	//   setter
	public void setColor(String color) {
		this.color = color;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		// 상수는 this 가 적용이 안됨
		// this는 객체 필드와 메소드에만 씀
		return TYPE + "[color=" + color + ", name=" + name + "]";
	}

	

	
}
