package io.day13;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import collection.day10.JavaWord;
public class D08FileReader {

    public static void main(String[] args) {
       
        long start = System.currentTimeMillis();        // 1000분의 1초
        
        // readByChar();                     // 소요시간 : 119  ms
        // readByCharArray();                // 소요시간 :  50  ms
        // readByCharButter();                  
        // readByScanner();
        readByScanner2();
        long end = System.currentTimeMillis();
        System.out.println(String.format("소요시간 : %,d  ms", (end-start)));


        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        System.out.println(str.length());

        


    }

    // StringBuilder 객체: 문자열 변경 및 저장이 가능한 가변객체
    public static void readByChar(){
        String filePath = "C:\\Windows\\PFRO.log";
        int charValue; 
        int count=0;

       try( FileReader fr = new FileReader(filePath)){

        while ((charValue = fr.read()) != -1) {    // 문자단위 입력을 1개씩 읽음
            
            System.out.print((char)charValue);    // 문자를 읽어올 수 있는지 확인, 문자이기 때문에 표준출력이 가능
            
            // 파일 줄바꿈은 2바이트 \r\n   (10과13)
            count++;
        }   
    } catch (Exception e) { }
        // FileReader 닫기
        System.out.println("\n***************************************");
        // 파일에서 읽은 내용 출력
        // System.out.println(content.toString());
        System.out.println("읽은 문자수 : "+count);
    }

    public static void readByCharArray(){

        // String filePath = "단어장.txt";
        String filePath = "C:\\Windows\\PFRO.log";
        char[] charValues = new char[256];
        int count=0; int charCount = 0;
        int b;

       try( FileReader fr = new FileReader(filePath)){
        
            while ((b = fr.read(charValues,0,256)) != -1) {    // read(배열이름, 시작인덱스, 최대문자길이)

                // 읽은 문자의 개수는 리턴, b에 저장
                System.out.print("읽은 내용 : " + new String(charValues,0,b)); // String 생성자(배열이름, 시작인덱스, 길이) 인자인 문자열을 생성
                
                // int 값을 char로 변환하여 StringBuilder에 추가
                charCount +=b;      // 읽은 문자의 개수를 세는 수식
                count++;           // 반복실행 횟수 수식
            } 
        } catch (Exception e) { }
        // FileReader 닫기

        System.out.println("~~~~~~~~~~~~~~~~~~~~");
        System.out.println("읽은 문자수 : "+charCount);
        System.out.println("반복 실행 횟수 : "+count);
    }


    public static void readByCharButter() {

        String filePath = "C:\\Windows\\PFRO.log";
        int count=0;        // 읽은 라인수, 문자 버퍼스트림은 라인 단위로 입출력 기능이 있습니다

       try(
            BufferedReader br = new BufferedReader(new FileReader(filePath))
        ) {
            String line;        // 라인단위를 저장할 변수
            
            while ((line = br.readLine()) != null) {   // readLine() 함수는 String을 반환한다
                System.out.println(line);
                count++;
            }
          
        } catch (Exception e) { }


        System.out.println("~~~~~~~~~~~~~~~~~~~~");
        System.out.println("읽은 라인 수 : "+count);
    }


    public static void readByScanner(){
        String filePath = "단어장.txt";
        int count=0;


        // Scanner 클래스  파일 읽는 방법 2가지 
        //  - nexLine() 메서드 
        //  - 구분기호로 읽어오는 방식
        try( Scanner fc = new Scanner(new FileReader(filePath))){

            fc.useDelimiter(",|\\n");   // 구분기호를 , 또는 엔터로 셋팅

            // 파일의 끝까지 반복
            while (fc.hasNext()) {  // hasNext() : 구분자로 가져온 분리된 것이 있으면 true 를 리턴하는 메서드
                String token = fc.next();
                System.out.println(token);
                count++;
            }

        } catch (Exception e) { }

        
        
        System.out.println("읽은 단어수 : "+count);
  
    }

    public static void readByScanner2(){
        String filePath = "단어장.txt";
        int count=0;
        List<JavaWord>  list = new ArrayList<>();

        // Scanner 클래스  파일 읽는 방법 2가지 
        //  - nexLine() 메서드 
        //  - 구분기호로 읽어오는 방식
        try( Scanner fc = new Scanner(new FileReader(filePath))){

            fc.useDelimiter(",|\\n");   // 구분기호를 , 또는 엔터로 셋팅

            // 파일의 끝까지 반복
            while (fc.hasNext()) {  // hasNext() : 구분자로 가져온 분리된 것이 있으면 true 를 리턴하는 메서드
                list.add(new JavaWord(fc.next(), 
                                      fc.next(), 
                                      Integer.parseInt(fc.next().trim() )));
                count++;
            }

        } catch (Exception e) { }

        System.out.println(list);
        System.out.println("총 단어수 : "+count);
        for (JavaWord word : list) {
            System.out.println("단어 :  " + word); 
        }
    }


}
