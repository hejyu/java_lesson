package basic.day3;

public class A15MinValue {

    public static void main(String[] args){

        int n1 = 10, n2 = 20, n3 = 50;
        int min;

        if( n1 < n2 ){
            min = n1;
        }else{
            min = n2;
        }

        if(min > n3){
            min = n3;
        }


        System.out.println(String.format("입력된 n1,n2,n3 : %d, %d, %d", n1,n2,n3));
        System.out.println(String.format("최소값: %d", min));

        min = (n1 < n2) ? n1 : n2;
        min = (min < n3) ? min : n3;

        System.out.println(String.format("입력된 n1,n2,n3 : %d, %d, %d", n1,n2,n3));
        System.out.println(String.format("최댓값: %d", min));

        
    }
}
