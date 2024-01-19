package object.day8;

public class Cat extends Animal {
    public static final String TYPE ="고양이 ";
	
	public Cat() {
	}
	

    public Cat(String color) {
        super();
		this.color = color;
	}
	
	
	@Override
	public void sound() {
		System.out.println(this.color +" 고양이는 야옹 😺 😺 하고 짖습니다. ");

	}

	@Override
	public String toString() {
		return TYPE+"[color=" + color + ", name=" + name + "]";
	}


	// toString을 재정의 하지 않으면 부모 toString이 실행되고 부모의 TYPE 상수값을 출력

}
