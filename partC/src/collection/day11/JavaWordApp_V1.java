package collection.day11;

import java.util.ArrayList;
import java.util.List;

import collection.day10.JavaWord;

public class JavaWordApp_V1 {
    //private : hide from other files
    private List<JavaWord>  wordsList = new ArrayList<>();

    //프로그램 실행 시작 함수
    public void start() {
        initialize();       // words 초기화
        // menu
        System.out.println("English Dictionary Programm START " + "~".repeat(30));

        while(true) {
            System.out.println("Choose one to do below ");
            System.out.println("\t 1. Create Word");
            System.out.println("\t 2. Get Word List");
            System.out.println("\t 3. Search Word");
            System.out.println("\t 4. Remove Word");
            System.out.println("\t 5. End Programm");
            System.out.print("선택 _");
            int sel = Integer.parseInt(System.console().readLine());    // keyboard typing smth.. -> number
            // System.console() : return system console Obj  -> readLine() 
            switch(sel){
                case 1: addWord(); break;
                case 2: listWord(); break;
                case 3: schWord(); break;
                case 4: removeWord(); break;
                case 5: 
                    System.out.println("Programm is End");
                    System.exit(0);             // stop main() running

                    break;
                default:
                    break;

            }
        }
    }

    private void initialize() {
        // test code
        wordsList.add(new JavaWord("public", "공용의", 1));
        wordsList.add(new JavaWord("private", "개인적인", 1));
        wordsList.add(new JavaWord("iterator", "반복자", 3));
        wordsList.add(new JavaWord("app", "응용프로그램", 2));
    }

    private void removeWord() {
        System.out.println("단어목록 ");
        listWord();

        System.out.println("삭제할 영어단어를 입력 _ ");
        String en = System.console().readLine();
        boolean isSearched = false;

        for (int i = 0; i < wordsList.size(); i++) {
            if(en.trim().equals(wordsList.get(i).getEn())) {
                System.out.print("단어를 찾았습니다\n 삭제하시겠어요?( 엔터를 누르면 삭제될거에요)\n 취소는 n 을 입력하세요  _ ");
                
                if(System.console().readLine().equals("n")) {
                    continue;
                }else {
                    wordsList.remove(en);   // index 사용시 => wordsList.remove(인덱스)
                    isSearched = true;
                    System.out.println("단어가 삭제되었어요");
                }
            }
        }
        
        if(!isSearched)
            System.out.println("삭제할 단어가 단어장에 없습니다.");
        
        listWord();
    }


    private void schWord() {
        System.out.println("단어목록 ");
        listWord();

        System.out.println("검색할 영어단어를 입력 _ ");
        String en = System.console().readLine();
        boolean  isSearched = false;

        for (JavaWord word : wordsList) {
            if(en.trim().equals(word.getEn()) ) {    // 동일 문자열인지 비교 => 무조건 eqauls
                System.out.println("SEARCH RESULT\n" +  word.getEn() + " = " + word.getKor()
                                    + "level : " + word.getLevel());
                isSearched = true;                  // 같은 단어 2개 이상 있을 때
            }
        }

        if(isSearched == false)
            System.out.println("찾는 단어가 단어장에 없습니다.");
    }

    private void listWord() {
        System.out.println(String.format("%-20s %-20s %-20s",
                                                    "English", "KOREAN", "LEVEL"));

        for (JavaWord word : wordsList) {
            System.out.println(String.format("%-20s %-20s %-20s",
                                                    word.getEn(), word.getKor(), word.getLevel()));
        }
    }

    private void addWord() {
        System.out.print("영어단어입력 _ ");
        String en = System.console().readLine();

        System.out.println("한글 의미 입력 _ ");
        String kor = System.console().readLine();
        System.out.println("level _");
        int level = Integer.parseInt(System.console().readLine());
        
        wordsList.add(new JavaWord(en, kor, level));
    }

    public static void main(String[] args) {
        //프로그램 실행하는 객체 생성하고 
        //  (메소드로 기능을 분리할 때 main 함수에 static 호출되지 않기 위해)
        //      start(): 프로그램 실행 내용을 코딩
        JavaWordApp_V1 app = new JavaWordApp_V1();
        app.start();
    }
}
