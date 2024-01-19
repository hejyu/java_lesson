package basic.day4;

public class ProbStringReverse {
    public static void main(String[] args) {
        String msg = "Hello World";
        
        reverseString(msg);

        reverseString2(msg);
    }

    // 문자열을 뒤집는 메소드
    private static void reverseString(String msg) {
        char[] arr = msg.toCharArray();

        for(int i = (arr.length - 1) ; i >= 0; i--) {
            System.out.print(arr[i]);
        }
    }
    // 문자열을 뒤집는 메소드2
    private static void reverseString2(String msg) {
        char[] arr = new char[msg.length()];
        int idx = msg.length() - 1;

        for(int i = 0 ; i < msg.length() ; i++) {
            char temp = msg.charAt(i);
            arr[idx] = temp;
            // i=1일때 idx=9, i=2일때 idx=8 ...

            idx--;     
        }
        
        System.out.println("뒤집기 :");
        System.out.println(arr);
    }

    
}
