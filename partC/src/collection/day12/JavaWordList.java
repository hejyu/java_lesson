package collection.day12;

import java.util.ArrayList;
import java.util.List;

import collection.day10.JavaWord;



/**
 * JavaWordApp_V3 : 아래의 JavaWordList 를 이용해서 똑같이 메뉴가 동작하도록 
 *                  변경할 수 있습니다.
 * 
 */
public class JavaWordList  implements WordList {
    //private : 현재 클래스에서만 사용할 목적으로 접근 제한합니다.
    //필드
    private List<JavaWord> words;
    
    public JavaWordList() {
        System.out.println("최대 저장 가능 단어 개수 : " + WordList.MAX_LENGTH);
        this.words = new ArrayList<>();
    }
   
    public void initialize() {
        this.words.add(new JavaWord("public", "공용의", 1));
        this.words.add(new JavaWord("public", "공동의", 2));
        this.words.add(new JavaWord("private", "사적인", 1));
        this.words.add(new JavaWord("iterator", "반복자", 3));
        this.words.add(new JavaWord("application", "응용프로그램", 2));
    }

    // 지정된 인덱스 i 의 JavaWord 객체 리턴
    @Override
    public JavaWord getWord(int i) {
       return this.words.get(i);
    }


    //단어장 전체 리스트 리턴
    @Override
    public List<JavaWord> list() {     //getWords 에서 이름 변경
        return this.words;
    }

    //단어 추가
    @Override
    public void add(JavaWord word) {
        if(words.size() > WordList.MAX_LENGTH) {
            System.out.println("단어장이 꽉찼습니다.");
            return;
        }
        this.words.add(word);
    }

    //전달받은 영어 단어의 인덱스를 배열로 리턴합니다.
    //-조회 및 삭제 기능에 사용
    @Override
    public int indexOfWord(String word, int position){
        
        for(int i = position ; i < this.words.size() ; i++){    
            if(words.get(i).getEn().equals(word))
                return i;       //찾으면 인덱스넘버 리턴
        }   
        
        return -1;              //없으면 -1 리턴
    }

    /**
     * 인덱스를 매개변수로 전달받아 단어 삭제
     * @param index
     * @return
     */
    @Override
    public JavaWord remove(int index) {
        JavaWord word = this.words.remove(index);
        return word;
    }

    //단어 검색 : 첫 번째로 일치하는 결과만 리턴(여러개 일 때 먼저 나온 것 리턴)
    @Override
    public JavaWord schFirstWord(String en) {

        for(JavaWord word : this.words) {

            if(word.getEn().equals(en)) 
                return word;        // 찾으면 words 인스턴스를 넘겨줌
           
        }

        return null;            
    }
    
    //단어 검색
    @Override
    public List<JavaWord> schWordBy(String en){

        List<JavaWord> list = new ArrayList<>();    //검색 결과 저장할 리스트
        for(JavaWord word : this.words) {
            if(word.getEn().equals(en)) {
               list.add(word);                      //일치하는 하는 단어를 만날 때마다 저장
            }
        }

        return list;
    }

    // 단어 레벨 검색
    @Override
    public List<JavaWord> schWordBy(int level){
        List<JavaWord> list = new ArrayList<>();    //검색 결과 저장할 리스트
        for(JavaWord word : this.words) {

            if(word.getLevel() == level ) {
               list.add(word);                      //일치하는 하는 단어를 만날 때마다 저장
            }
        }
        return list;
    }

    // 인스턴스 필드 words 를 사용하여 동작하는 인스턴스 매소드
    @Override
    public void print(){
        for(JavaWord word : this.words) {
            System.out.println(String.format("%-20s %-30s %-20s",
                                    word.getEn(),word.getKor(),word.getLevel()));
        }
    }     
   
    // statc : 인스턴스 필드를 사용하지 않고 매개변수를 전달받아 동작
    public static void print(List<JavaWord> list){
        for(JavaWord word : list) {
            System.out.println(String.format("%-20s %-30s %-20s",
                                    word.getEn(),word.getKor(),word.getLevel()));
        }
    }

   
   

}