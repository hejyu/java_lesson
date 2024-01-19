package collection.day10;

/* 
 * Value Object(VO) 조건
 * 생성될 때 초기화한 이후 인스턴스 필드는 변경할 수 없습니다.  
 *                      hasn, equals 메소드 재정의 반드시 재정의!! 
 * 이러한 객체를 vo 라고 합니다 . Value Object 의 조건
 */
public class Member {
    
    private String name;
    private int age;

    public Member(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Member [이름=" + name + ", 나이=" + age + "]";
    }


    @Override
    public int hashCode() {     // 인스턴스 필드 값으로 해쉬코드를 만듭니다.
                                // name.hashCode() 와 age  두 개의 필드값을 이용해서 해쉬코드를 리턴합니다.
        final int prime = 31;   
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + age;
        return result;
    }

    /* 중요 : 객체의 동일성(같은 객체) 검사를 위해서 hashCode, equals 메소드를 재정의합니다.*/
    //      -> 해쉬코드가 같고 인스턴스 필드 값이 같으면 동일한 객체입니다.

    @Override
    public boolean equals(Object obj) { // 대상이 되는 obj 데이터와 현재 this 객체의 인스턴스 필드 값이 모두 같은지 검사합니다
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Member other = (Member) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (age != other.age)
            return false;
        return true;
    }

    

}
