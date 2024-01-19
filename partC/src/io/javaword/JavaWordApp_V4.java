package io.javaword;

import java.util.List;

import collection.day10.JavaWord;

/**
 * JavaWordApp_V4 : 단어장 인스턴스 생성한 후 단어장 파일을 전달
 *                  파일 데이터로 리스트를 초기화함
 */
public class JavaWordApp_V4 {
    
    //private : JavaWordList 객체
    private JavaWordList wordList = new JavaWordList("단어장.txt");

        
    public static void main(String[] args) {
        JavaWordApp_V4 app = new JavaWordApp_V4();
        app.start();    // 단어장 실행 메서드
    }


    public void start() {
        wordList.fileLoad();        // 파일에서 단어장 읽어오기

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
            
            switch(sel){
                case 1: addWord(); break;
                case 2: listWord(); break;
                case 3: schWordBy(); break;
                case 4: removeWord(); break;
                case 5: 
                    System.out.println("Programm is End");
                    wordList.fileSave();
                    System.exit(0);             // stop main() running

                    break;
                default:
                    break;

            }
        }

       
    }

    
    
    private void addWord() {
        System.out.println("\t::단어 등록합니다.::");
        //사용자 키보드 입력으로 데이터 생성
        System.out.print("영어 단어 입력하세요. _ ");
        String en = System.console().readLine();

        System.out.print("한글 의미 입력하세요. _ ");
        String kor= System.console().readLine();

        System.out.print("단어 레벨 입력하세요.(1:초급 2:중급 3:고급) _");
        int level = Integer.parseInt(System.console().readLine());

        wordList.add(new JavaWord(en, kor, level));
    }

    private void listWord() {
        System.out.println("\t::단어 목록 출력합니다.::");
        System.out.println(String.format("%-20s %-30s %-20s",
                                            "ENGLISH","KOREAN","LEVEL"));
        wordList.print();
    }

    
    private void schWordBy() {
        System.out.println("\t ::단어 검색합니다(단어 검색 : 1, 레벨 검색 : 2 ) :: ");
        String schTxt = null;
        List<JavaWord> list = null;

        switch (System.console().readLine()) {
            case "1":
                System.out.print("검색할 영어단어를 입력하세요 _ ");
                schTxt = System.console().readLine();
                list = wordList.schWordBy(schTxt);

                break;
            case "2":
                System.out.println("검색할 레벨을 입력하세요");
                int level = Integer.parseInt(System.console().readLine());
                list = wordList.schWordBy(level);

                break;
        
            default:
                break;
        }

        if(list.size() == 0)
            System.out.println("찾는 단어가 단어장에 없습니다.");   
        else
            JavaWordList.print(list);
            
    }

    private void removeWord() {

        wordList.print();

        System.out.println("삭제할 영어단어를 입력 _ ");
        String en = System.console().readLine();
        int position = wordList.indexOfWord(en,0);    //단어의 인덱스를 배열로 리턴
        
        if(position ==-1)      {        //인덱스 0부터 단어를 찾아서 -1 이면 찾는 단어가 없음.
            System.out.println("삭제할 단어는 단어장에 없습니다.");
            return;
        }
        
        while(position !=-1){           // 찾는 단어가 없을때 까지 반목하기
            System.out.println("삭제할 단어 - " + wordList.getWord(position));
            System.out.print("삭제하려면 엔터, 취소는 n 을 입력하세요._");
            
            if(!System.console().readLine().equals("n")) {
                //단어 삭제.
                wordList.remove(position); 
                System.out.println("단어 삭제 완료!!");
                position--;     // 삭제했을 때는 인덱스값이 position 뒤의 요소들은 모두 -1 씩 감소. 
            }            
            
            position = wordList.indexOfWord(en,++position); //position은 찾은 단어 다음 위치부터 다시 찾기
        }
    }
    
    
    
    




}