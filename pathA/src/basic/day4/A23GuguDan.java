package basic.day4;


public class A23GuguDan {
    public static void main(String[] args) {
        
        // 몇 단인지
        for (int i = 2; i <= 9; i++){
            for(int j = 1; j <= 9; j++){
                System.out.println(String.format("%d * %d = %d", i,j,i*j));
            }
        }

    }
}
