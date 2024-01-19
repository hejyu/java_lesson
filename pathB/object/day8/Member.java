package object.day8;

import object.day7.Triangle;

public class Member {

    private int age;
    private String name;
    
    //생성자
    public Member() {
    }

    public Member(int age, String name) {
        this.age = age;
        this.name = name;
    }


    public int getAge() {
        return age;
    }
    public String getName() {
        return name;
    }

    // 메소드 인자가 부모 클래스 타입일 때  실제 인스턴스는 여러 자식 클래스의 객체가 될 수 있다 
    /**
     * 동물 보호소 규정
     * 강아지는 15세이상, 고양이는 18세이상, 토끼는 13세 이상 그 외 동물은 20세 이상부터 분양 가능합니다
     * @param animal
     * @return
     */
    public boolean isAdopt(Animal animal) {
        boolean bol = false;

        if (animal instanceof Puppy && this.age > 14) {
           bol =  true;
        }else if (animal instanceof Cat && this.age > 17) {
            bol =  true;
        }else if (animal instanceof Rabbit && this.age > 12) {
            bol =  true;
        }else if(this.age > 19)   {
            bol =  true;
        }

        return bol;
    }
    
}
