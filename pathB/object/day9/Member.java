package object.day9;


/**
 * 인터페이스 예시 - 비교 가능한 객체 만들기
 *                  방법 1. Comparable 인터페이스 구현
 * Comparable<Member>  는 제너릭 타입, <> 안에 타입을 표시
 *                      -   클래스 또는 인터페이스 메소드에게 타입을 매개변수로 전달하는 방식
 *                      -   이 때 타입이 실행 시점에서 결정되기 때문. 기본형은 Wrapper 클래스로 사용
 *                      -   Comparable 인터페이스가 실행하는 메소드에 Member 타입을 전달함
 * Comparable : 비교할 수 있는
 */
public class Member implements Comparable<Member> {
    
    private String id;
    private int age;


    public Member(String id, int age) {
        this.id = id;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public String getId() {
        return id;
    }

    //Comparable 인터페이스의 추상메소드 compareTo 를 구현
    @Override
    public int compareTo(Member o) {        // 매개변수 타입 객체는 <> 안에 제너릭 타입과 같게 만들어집니다.
        // 현재 객체 this를 인자로 전달되는 Member객체와 비교합니다.
        // 비교 기준은 요구사항에 따라 개발자가 정합니다.
        // 만약 나이로 하는 경우
        //      return this.age - o.age;
        //      return o.age - this.age;

        // 만약 이름으로 한다면
        //      return o.id.compareTo(this.id); 
        return this.id.compareTo(o.id);
    }

    @Override
    public String toString() {
        return "Member [id=" + id + ", age=" + age + "]";
    }




    
}
