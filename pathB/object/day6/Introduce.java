package object.day6;

public class Introduce {

    // 필드 선언
    //  private 키워드 : 현재 클래스 외에 다른 클래스에서 사용 못함.
    private String name;        // 이름
    private int age;            // 나이
    private String[] major;     // 전공
    private String[] personality;   // 성격
    private String[] strengh;            // 관련 강점 

    


    // 인자 5개인 생성자 생성
    public Introduce(String name, int age, String[] major, String[] personality, String[] strengh) {
        this.name = name;   //  name 변수의 값을 클래스의 
        this.age = age;
        this.major = major;
        this.personality = personality;
        this.strengh = strengh;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    public String[] getMajor() {
        return this.major;
    }

    public String[] getPersonality() {
        return this.personality;
    }

    public String[] getStrengh() {
        return this.strengh;
    }

    public String getInfo(String info) {
        return info;
    }
    

}
