package collection.day11;

import java.util.ArrayList;
import java.util.List;

import collection.day10.JavaWord;

/**
 * JavaWordApp_V2 : 메소드 만드는 연습
 *                  검색 메소드, print 메소드 리팩토링(refactoring)
 */
public class JavaWordApp_V2 {
    
//private : hide from other files
    private List<JavaWord>  wordsList = new ArrayList<>();

    //프로그램 실행 시작 함수
    public void start() {
        initialize();       // words 초기화
        // menu
        System.out.println("English Dictionary App START " + "~".repeat(30));

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
                case 3: schWordBy(); break;         //schWord(); break;
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
            if(en.equals(wordsList.get(i).getEn())) {
                System.out.print("단어를 찾았습니다\n 삭제하시겠어요?( 엔터를 누르면 삭제될거에요)\n 취소는 n 을 입력하세요  _ ");
                
                if(System.console().readLine().equals("n")) {
                    continue;
                }else {
                    wordsList.remove(i);
                    isSearched = true;
                    System.out.println("단어가 삭제되었어요");
                }
            }
        }
        
        if(!isSearched)
            System.out.println("삭제할 단어가 단어장에 없습니다.");
        
        listWord();
    }

    private void listWord() {
        System.out.println(String.format("%-20s %-20s %-20s",
                                                    "English", "KOREAN", "LEVEL"));

        printWordList(wordsList);
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

    private void schWord() {
        System.out.println("단어목록 ");
        listWord();

        System.out.println("검색할 영어단어를 입력 _ ");
        String en = System.console().readLine();
        
        List<JavaWord> result = schAllJavaWords(en);
        if(result.size() == 0) 
            System.out.println("찾는 단어가 단어장에 없습니다.");
        else 
            System.out.println("result : " + result);

        
    }
    
    // 단어를 검색할지 레벨 검색할지 선택받아 검색결과를 출력하는 함수
    private void schWordBy() {
        System.out.println("\t ::단어 검색합니다(단어 검색 : 1, 레벨 검색 : 2 ) :: ");
        String schTxt = null;
        List<JavaWord> list = null;

        switch (System.console().readLine()) {
            case "1":
                System.out.print("검색할 영어단어를 입력하세요 _ ");
                schTxt = System.console().readLine();
                list = schAllJavaWords(schTxt);
                
                printWordList(list);

                break;
            case "2":
                System.out.println("검색할 레벨을 입력하세요");
                int level = Integer.parseInt(System.console().readLine());
                list = schAllJavaWords(level);

                break;
            default:
                break;
        }
    }

    // 여러 JavaWord 객체를 매개변수로 받아 출력하는 함수
    private void printWordList(List<JavaWord> list) {
        for (JavaWord word : list) {
            System.out.println(String.format("%-20s %-20s %-20s",
                                                    word.getEn(), word.getKor(), word.getLevel()));
        }
    }

    // 새로운 검색 메소드 정의
    // 1.단어 검색 : 첫 번째로 일치하는 결과만 리턴
    //      실행에 꼭 필요한 인자를 입력 매개변수로 넘겨서 결과에 맞는 타입으로 리턴
    private JavaWord schFirstWord(String en){
        for (JavaWord word : wordsList) {
            if(word.getEn().equals(en)){
                return word;        // 찾으면 word 인스턴스를 넘겨줌
            }
        }
        
        return null;                // 찾는 단어 없으면 null 리턴 
    }

    // 2.단어 검색 : 검색하는 단어와 일치하는 결과를 모두 리턴
    private List<JavaWord> schAllJavaWords(String en){
        List<JavaWord> list = new ArrayList<>();

        for (JavaWord word : wordsList) {
            if(word.getEn().equals(en)){
                list.add(word);        // 일치하는 단어를 만날 때마다 저장
            }
        }
        
        return list;                    // JavaWord 클래서에서 toString() 재정의된 메소드 실행
    }

    
    // 3.레벨 검색 : 검색하는 단어와 일치하는 결과를 모두 리턴
    private List<JavaWord> schAllJavaWords(int level){
        List<JavaWord> list = new ArrayList<>();
        
        for (JavaWord word : wordsList) {
            if(word.getLevel() == level){
                list.add(word);        // 일치하는 단어를 만날 때마다 저장
            }
        }
        
        return list;                    // JavaWord 클래서에서 toString() 재정의된 메소드 실행
    }

    public static void main(String[] args) {
        //프로그램 실행하는 객체 생성하고 
        //  (메소드로 기능을 분리할 때 main 함수에 static 호출되지 않기 위해)
        //      start(): 프로그램 실행 내용을 코딩
        JavaWordApp_V2 app = new JavaWordApp_V2();
        app.start();
    }



}