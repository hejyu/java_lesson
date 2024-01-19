package object.day8;

/**
 * 추상클래스 테스트
 */
public class B15AbstarctTest {

    public static void main(String[] args) {
        
        // Animal animal = new Animal() 객체 생성  불가능,추상 클래스여서

        // Anonymous(익명) Inner(내부클래스) Type : 클래스 이름이 없는 내부 클래스 형식 
        Animal animal = new Animal() {  // 추상메소드를 재정의하면서 추상 클래스를 정의함  (1회용)
            @Override
            public void sound() {
                System.out.println("익명의  동물 클래스 : 소리는 모름.");
                
            }
            
        };     

        animal.sound();
        System.out.println("animal toString() : " + animal);

        Puppy puppy = new Puppy("puddle", "brown");
        puppy.sound();              // 
        System.out.println("puppy toString() : " + puppy);      // 강아지 [color=brown, name=puddle]

    }
}
