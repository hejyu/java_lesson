package object.day9;

public class Student {
    
    private String name;
    private int age;
    private char grade;



    public Student(String name, int age, char grade) {
        this.name = name;
        this.age = age;
        this.grade = grade;
    }


    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public char getGrade() {
        return grade;
    }
    public void setGrade(char grade) {
        this.grade = grade;
    }
    

    @Override
    public String toString() {
        return String.format("Student [name= %s , age= %d, char= %c \n", this.name, this.age, this.grade);
    }



    /* 
     * Member 클래스 compateTo 문제점
     *  비교 기준 또는 정렬 (오름, 내림) 을 변경하려면 
     *  클래스 내부의 compateTo 메소드의 return을 변경해야 합니다.
     *  Member 객체를 사용하고 있는 다른 프로그램에 영향을 줍니다.
     */


    
}
