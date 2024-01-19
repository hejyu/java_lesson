package basic.day3;

public class HomeCharType {


    public static void main(String[] args) {
        /*
        :::: [과제-2024/01/03 22시까지 제출] 문자열을 구성하는 문자의 종류 분석하기 ::::
        1) 문자열을 임의로 저장합니다. 예시 : "Hello* Java Hi* Linux~~~" 

        2) 1)번의 문자열을 구성하는 문자 하나하나가  '대문자' '소문자' '숫자' '기호' 중 어떤 종류의 문자인지 검사합니다.

        3) 2)번의 검사를 통해서 문자열을 구성하는 문자의 종류와 개수를 구하여 출력합니다.
        변수명 :     대문자의 갯수  upperCount  , 
                    소문자의 갯수  lowerCount  , 
                    숫자의 갯수    numberCount , 
                    기호의 갯수    symbolCount 

        출력 예시 :  
        ------------------------------------------------------------
        문자열 : Hello* Java Hi* Linux~~~
        문자 종류 : 대문자 4개, 소문자 12개, 숫자 0개, 기호 8개  
        */

        // 문자열을 저장할 변수 message 선언
        // 문자열 분석에 사용할 변수를 작성
        // 대문자 구분 조건식을 작성, 65 ~ 90
        // 소문자 구분 조건식을 작성, 97 ~ 122
        // 숫자 구분 조건식을 작성, 48 ~ 57
        // 기호 구분 조건식을 작성,  나머지 
        // 문자열이 가리키는 인덱스를 이용해 아 반환
        String message = "Ho*''Hi*9";
        int upperCount=0;
        int lowerCount=0;
        int numberCount=0;
        int symbolCount= 0;
        int i = 0;
        int check = 0;
        while(i < message.length()){
            int code = message.codePointAt(i);
            if((int)'A' <= code && (int)'Z' >= code ) {
                upperCount++;
            }else if((int)'a' <= code && (int)'z' >= code) {
                lowerCount++;
            }else if((int)'0' <= code && (int)'9' >= code) {
                numberCount++;
            }else {
                symbolCount++;
            }

            i++;
        }

        check = upperCount + lowerCount + numberCount + symbolCount;

        if(message.length() == check){
            System.out.println(String.format("문자열 : %s", message));
            System.out.println(String.format("문자 종류 : 대문자 %d개, 소문자 %d개, 숫자 %d개, 기호 %d개  ", upperCount, lowerCount, numberCount, symbolCount));
        }


    }
}    