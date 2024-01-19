package basic.day3;

public class A16MaxMinValue {

    public static void main(String[] args){

        int n1 = 10, n2 = 20, n3 = 50;
        int min, max;

        if( n1 < n2 ){
            min = n1;
            max = n2;
        }else{
            min = n2;
            max = n1;
        }

        if(min > n3){
            min = n3;
        }
        
        if(max < n3){
            max = n3;
        }

        System.out.println(String.format("입력된 n1,n2,n3 : %d, %d, %d", n1,n2,n3));
        System.out.println(String.format("최소값, 최댓값: %d, %d", min, max));

        min = (n1 < n2) ? n1 : n2;
        min = (min < n3) ? min : n3;

        max = (n1 > n2) ? n1 : n2;
        max = (max > n3) ? max : n3;

        System.out.println(String.format("입력된 n1,n2,n3 : %d, %d, %d", n1,n2,n3));
        System.out.println(String.format("최소값, 최댓값: %d, %d", min, max));


        
    }
}
