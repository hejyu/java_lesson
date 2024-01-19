package collection.myaap;

import java.util.List;

import collection.day10.JavaWord;

public class JavaWordApp {

    public static void main(String[] args) {
        
        //단어장을 시작하는 프로그램입니다.
        //1. 단어장을 생성합니다
        JavaWordBook mybook = new JavaWordBook();

        //2. 단어를 추가합니다
        JavaWord word = new JavaWord("public", "모두에게 오픈함", 1);
        mybook.addWord(word);
        mybook.addWord(new JavaWord("private", "모두에게 숨김", 1));
        mybook.addWord(new JavaWord("protected", "자식클래스에게 오픈함", 1));
        mybook.addWord(new JavaWord("iterate", "인덱스(순서) 없는 자료구조 접근용 반복자", 3));
        mybook.addWord(new JavaWord("collection", "데이터 묶음, 수집", 2));
        mybook.addWord(new JavaWord("application", "응용프로그램", 2));
        mybook.addWord(new JavaWord("binary", "2진수의", 3));




        //3. 단어를 조회합니다.
        //  - 영어단어 입력하면 찾아주기
        String schTxt = "iterate";
        JavaWord result = mybook.schWord(schTxt);
        System.out.println("검색 : "+ schTxt + "\t 조회결과 : " + mybook.schWord("iterate"));  //iterate, 인덱스(순서) 없는 자료구조 접근용 반복자, 3
        
        //  - List<JavaWord>    schWord(int level) : 단어 조회 
        List<JavaWord> res = mybook.schWord(1);
        JavaWordBook.wordListPrint(res);


        //4. 단어를 삭제합니다.
        String keyword = "application";
        mybook.removeWord(keyword);
        System.out.println("🧨" + keyword + "  삭제되었어요 🧨");
        mybook.wordAllPrint();

        //5.영어 abc순으로 정렬합니다

        //6.레벨 오름차순으로 정렬합니다

        //7.영어단어를 매개변수로 받아 단어를 조회합니다




    }
    
}
