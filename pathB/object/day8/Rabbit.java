package object.day8;

public class Rabbit extends Animal{
    public static final String TYPE ="토끼 ";
	
	// 생성자가 없으면 자동으로 부모 생성자 super()를 호출한다
    // 복습 : 자식 객체가 생성될 때 먼저 부모 객체를 생성하고 자식 인스턴스 요소가 추가됨
    //        이 때 부모 생성자는 super()가 기본

    public Rabbit() {
    }

    public Rabbit(String color){
        this.color = color;     //super(color); 와 같음
    }

	@Override
	public void sound() {
		System.out.println(this.color +" 토끼는 🐰🐰조용합니다. ");

	}

	@Override
	public String toString() {
		return TYPE+"[color=" + color + ", name=" + name + "]";
	}


	// toString을 재정의 하지 않으면 부모 toString이 실행되고 부모의 TYPE 상수값을 출력

}
