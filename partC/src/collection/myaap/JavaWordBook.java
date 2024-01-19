package collection.myaap;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import collection.day10.JavaWord;

public class JavaWordBook {

    private Map<String, JavaWord> wordBook;
    // key : key  값은 중복이 안되고 순서가 없음
    // value : JavaWord(영어,한글,레벨)


    public JavaWordBook() {
        this.wordBook = new TreeMap<>();    
        //key 값인 영어 단어 순으로 정렬됨
    }

    // getter
    public Map<String, JavaWord> getWordBook() {
        return this.wordBook;
    }

    // 영어 단어 추가/수정
    /**
     * 추가할 단어를 입력받아 객체의 wordBook에 추가/수정하는 함수
     * @param word
     */
    public void addWord(JavaWord word) {
        this.wordBook.put(word.getEn(), word);
    }

    // Map 의 특징 - key 값을 이용해서 조회와 삭제 가능
    // 조회
    public JavaWord schWord(String word) {
        return this.wordBook.get(word);
    }

    // 삭제
    public void removeWord(String word) {
        this.wordBook.remove(word);
    }


    public void wordAllPrint(){
        // TreeMap은 정렬되어 있으므로 Map의 values 를 리스트로 변환하여 출력메소드로 전달
        List<JavaWord> all = new ArrayList<JavaWord>(this.wordBook.values()); // ***
        wordListPrint(all);
    }

    // statc 메소드로 작성 가능 
    public static void wordListPrint(List<JavaWord> list) {
        System.out.println("단어장");
        System.out.println(String.format("%-15s %-30s \t %-3s", "<english>","<korean>", "<level>"));

        for(JavaWord word : list ) {
            System.out.println(String.format("%-15s %-30s \t %-3d", 
                                                                                        word.getEn(), word.getKor(), word.getLevel()));    
        }

    }

    /**
     * 레벨을 매개변수로 받아 단어 검색
     * @param level
     * @return
     */
    public List<JavaWord> schWord(int level) {

        System.out.println("wordbook map values : " + this.wordBook.values());
        List<JavaWord> result = new ArrayList<>();    

        //매개변수로 전달받은 level만 result 리스트에 저장
        for (JavaWord word : this.wordBook.values()) {
            if (word.getLevel() == level)   result.add(word);

        }

        return result;
    }

    




}
