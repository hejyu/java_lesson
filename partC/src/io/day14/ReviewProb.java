package io.day14;

import java.io.IOException;

import collection.day10.JavaWord;
import io.javaword.JavaWordList;

public class ReviewProb {
    public static void main(String[] args) {
        
        prob_10();
    }

    private static void prob_8() {
        JavaWordList words = new JavaWordList("단어장.txt");
        words.fileLoad();
        
        words.add(new JavaWord("null", "아무것도 없는", 1));
        // words.remove(-9);
        // 개발자가 만드는 예외 : 
        //      1) 예외가 발생되는 문법오류, 실행 오류 없지만 값의 범위를 제한하기 위해 예외를 발생시킴
        //      2) 기존에 발생하는 예외를 새로운 내용으로 변경할 때
    
    
    }


    public static void prob_10() {
        byte[] buffer = new byte[20];

        try {
            int b=System.in.read(buffer);   // System.in : 터미널에서 입력 가능한 클래스 
            System.out.println(String.format("입력한 바이트 수 : %d B", b));    // 한글자당 3 B
            // System.out.println(String.format("입력 문자 : %s" , new String(buffer)));
       
            System.out.println("입력한 문자열 정수 변환 : " + Integer.parseInt(new String(buffer).trim()));
            Integer.parseInt(new String(buffer).trim());
        } catch (IOException | NumberFormatException e) {   // 2개의 예외를 처리합니다
            System.out.println("IOException 또는 NumberFormatException 예외처리 ");
            // || : 논리적인 OR , | : 비트단위 OR
            // System.out.println(e.getMessage());

            e.printStackTrace();
        }
    }
}


