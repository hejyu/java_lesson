package object.day6;

import java.util.Scanner;

public class AddQuizMain {

    public static void main(String[] args) {
        // 두 자리 랜덤 숫자 범위 셋팅
        int start = 11;
        int end = 99;
        int correctCount = 0;                         //정답 개수
        
        // Scannere 사용, 문제 개수 입력받기 
        Scanner sc = new Scanner(System.in);
        
        // System.out.print("문제를 생성할 개수 입력 >>> ");

        //문제 개수 입력받기 
        // int m_count = sc.nextInt();     // 풀 문제 수
        int m_count = 2;
        if(m_count == 0) {
            System.out.println("프로그램을 종료합니다");
            return;
        }

        System.out.println(String.format("덧셈. %2d개 문제 퀴즈 시작", m_count));
        AddQuiz[] quizs = new AddQuiz[m_count];     // 객체 배열 초기화
        
        try {
            int i = 0;
            while (true) {
                if(i > (m_count-1)) break;
                
                quizs[i] = new AddQuiz(start, end);
                
                System.out.println(String.format("퀴즈 %d번.%3d +%3d ", i+1, quizs[i].getData1(), quizs[i].getData2()));
                System.out.print("답을 입력하세요>>> ");
                
                int userAnswer = sc.nextInt();           // 학생의 답 입력받기  
                quizs[i].setUserAnswer(userAnswer);      // 문제에 입력한 답을 저장
                boolean bol = quizs[i].checkAnswer();    // 정답인지 체크, 정답이면 true, 오답이면 false 를 리턴

                if(bol)     correctCount += 1;           // 정답이면 correcCount 1 증가

                i += 1;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        
        System.out.println("::: 채점하고 있습니다:::");
        for(int i=0 ; i < quizs.length ; i++ ) {
            System.out.println(quizs[i].printResult());
        }

        System.out.println(String.format("::: 정답 개수는 %d개 입니다:::", correctCount));
    }
    

    

}
