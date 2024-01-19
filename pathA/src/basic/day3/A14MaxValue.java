package basic.day3;

public class A14MaxValue {

    public static void main(String[] args){

        int n1 = 10;
        int n2 = 20;
        int n3 = 50;
        int temp, max;   //  max value

        if( n1 > n2 ){
            temp = n1;
        }else{
            temp = n2;
        }

        if(temp < n3){
            temp = n3;
        }


        System.out.println(String.format("입력된 n1,n2,n3 : %d, %d, %d", n1,n2,n3));
        System.out.println(String.format("최댓값: %d", temp));

        max = (n1 > n2) ? n1 : n2;
        max = (max > n3) ? max : n3;

        System.out.println(String.format("입력된 n1,n2,n3 : %d, %d, %d", n1,n2,n3));
        System.out.println(String.format("최댓값: %d", max));

        
    }
}
