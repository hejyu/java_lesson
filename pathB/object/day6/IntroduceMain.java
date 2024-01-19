package object.day6;

public class IntroduceMain {

    public static void main(String[] args) {
        String name = "hayeon";
        int age = 26;
        String[] major = {"informaiton communication, computer science"};       // 크기가 2인 배열 초기화
        String[] personality = {"positive", "attenetive","observant" };         // 크기가 3인 배열 초기화
        String[] strengh = {"sorting out code","honest", "attention to detail"};       // 크기가 3인 배열 초기화

        // 인자가 5개인 커스텀 생성자 초기화
        Introduce template = new Introduce(name, age, major, personality, strengh);

        System.out.println(String.format("Hi, I'm %s", template.getName()));    // 생성자를 이용해 저장한 name 값을 출력 
        System.out.println(String.format("I'm %d", age));   // 생성자를 이용해 저장한 age 값을 출력 
        
        System.out.print("I am ");          // 생성자를 이용해 저장한 age 값을 출력 
        for (int i = 0 ; i < personality.length ; i++) {
            if(i > 0 && i < personality.length ) {
                System.out.print(", ");
            }
            
            System.out.print(String.format("%s" , personality[i]));

            if(i == personality.length -1) {
                System.out.println(".");
            }
        }
        
        System.out.print("I'm good at ");          // 생성자를 이용해 저장한 age 값을 출력 
        for (int i = 0 ; i < strengh.length ; i++) {
            if(i > 0 && i < strengh.length ) {
                System.out.print(", ");
            }
            
            System.out.print(String.format("%s" , strengh[i]));

            if(i == personality.length -1) {
                System.out.println(".");
            }
        }


    }
}
