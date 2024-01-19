package io.day13;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class D09StringSplit {

    //전역변수 : 모든 메소드에서 사용 가능
    private static String filePath = "score.txt";

    public static void main(String[] args) {
        
        List<Score> list = makeList();
        System.out.println(list.toString());    

        for (Score stu : list) {
            System.out.println(stu);        // list.get(i) 
        }
    }

    public static Score makeScore(String line) {
        String[]  temp = line.split(",");
        Score score = new Score(temp[0], 
                                Integer.parseInt(temp[1]), 
                                Integer.parseInt(temp[2]), 
                                Integer.parseInt(temp[3]));
        
        return score;
    }


    // score.txt 파일의 데이터를 읽어와  Score 객체로 받아 리스트에 담고 리턴하기
    public static List<Score> makeList() {

        List<Score> list  = new ArrayList<Score>();
        int count = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath)))
        {
            String line;

            while((line = br.readLine()) != null) {

                String[] temp = line.split(",");
                Score stu = makeScore(line);
                list.add(stu);

                count++;
            }

        } catch (IOException e) {
            System.out.println("파일 입출력 오류 : " + e.getMessage());
        }
        
        return list;
    }

    // BufferReader 클래스는 라인단위로 읽어옵니다
    //      1줄 읽고 -> Score 각 필드에 값 저장 (객체는 4개) 
    //      변수명 모두 stu를 참조하고 출력
    public static void split_test2() {
        String filePath = "score.txt";
        int count = 0;
        Score stu = null;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath)))
        {
            String line;

            while((line = br.readLine()) != null) {

                String[] temp = line.split(",");
                stu = makeScore(line);
                count++;
                System.out.println(String.format("인스턴스 : %s, 순서: %d", stu.datas(),count));
            }

        } catch (IOException e) {
            System.out.println("파일 입출력 오류 : " + e.getMessage());
        }
        
    }


    public static void split_test1() {
        String stu = "김모모,67,77,88";
    
        // split 메소드는 지정된 구분자(구분기호)를 매개변수로 받아
        //      문자열을 분리해 String 배열로 리턴합니다
    
        String[] temp = stu.split(",");
        System.out.println("1. split 실행한 결과 문자열은 ? ");        
        System.out.println(Arrays.toString(temp));

        for (String t : temp) {
            System.out.println(t);
        }
        
        System.out.println("2. 분리된 결과로 Score 인스턴스 필드에 값 저장 ");
        //temp[0]   은 이름, temp[1] ~ temp[3] 까지는 점수 문자열
        Score score = new Score(temp[0], 
                                Integer.parseInt(temp[1]), 
                                Integer.parseInt(temp[2]), 
                                Integer.parseInt(temp[3]));

        System.out.println("Score 출력 1 : " + score.datas());
        System.out.println("Score 출력 1 : " + score);
        
    }
    

    


}
