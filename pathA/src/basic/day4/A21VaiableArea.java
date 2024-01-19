package basic.day4;

public class A21VaiableArea {
    int number= 999;
    static int number2 = 9999;

    public static void main(String[] args) {
        
        int a = 23;     // main 메소드 범위에서 사용되는 변수

        for(int i=0;i<10;i++){
            System.out.println(String.format("i=%d", i));
        }

        while(a==23){
            int count;      // 특정 블럭while 안에서 사용되는 반복횟수 변수
            System.out.println(String.format("a= %d", a));

            count = 100;

            System.out.println(String.format("count= %d", count));
            a= 24;
        }

        System.out.println(String.format("a=%d",a));

        // System.out.println(String.format("i=%d",i));
        // System.out.println(String.format("count=%d",count));

        // System.out.println(String.format("a=%d",a));
        // System.out.println(String.format("num=%d",number)); //static이 아닌 클래스 필드 변수는 사용 못함
        System.out.println(String.format("statc num2=%d",number2));
    }
}
