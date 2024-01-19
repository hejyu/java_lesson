package io.day13;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.nio.charset.Charset;

public class D10FileWriter {

    public static void main(String[] args) {
       
        writeByPrintWriter();
    }


    // BufferedWriter 사용 내용 쓰기
    public static void writeByBuffer(){
        String filePath = "단어장2.txt";
        int count=0;
      

        try( BufferedWriter bw = new BufferedWriter(new FileWriter(filePath,true))){
            // 파일의 끝까지 반복
            for(int i=0;i<10;i++) {
                bw.append("안녕하세요요요요~"+i+"\r\n");        
                // append() : 기존 내용 뒤에 이어쓰기
                // new FileWriter(filePath,true) 생성자에 옵션 셋팅 필요
                // bw.write("안녕~"+i+"\r\n");     // 덮어쓰기
                count++;
            }
    } catch (Exception e) { }

        System.out.println("저장한 라인수 : "+count);
    }

    // PrintWriter 사용 내용 쓰기
    public static void writeByPrintWriter(){        
        String filePath = "단어장3.txt";
        int count=0;
        File file = new File(filePath);
        // PrintWriter 와 BufferdWriter 객체 차이
        //  - print, println 메소드 사용할 수 있음.
        //  - 인자에 File 인스턴스, 문자인코딩 전달
        try(
            FileOutputStream fo = new FileOutputStream(file);
            PrintWriter pw = new PrintWriter(new FileWriter(filePath,true))
            ){

            // 파일의 끝까지 반복
            for(int i=0;i<10;i++) {
                pw.append("할로~"+i+"\r\n");
                // pw.print("안녕하세요"+i+"\r\n");       
                count++;
            }
            
    } catch (Exception e) { }

        System.out.println("저장한 라인수 : "+count);
    }
}
