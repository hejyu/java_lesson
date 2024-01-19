package io.javaword;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import collection.day10.JavaWord;


/**
 * JavaWordApp_V4 : 아래의 List 
 *                  변경할 수 있습니다.
 * 
 */
public class JavaWordList  implements WordList {

    
    private List<JavaWord> words;       //private : 현재 클래스에서만 사용할 목적으로 접근을 제한
    private String filePath;
    
    public JavaWordList(String filePath) {
        System.out.println("최대 저장 가능 단어 개수 : " + WordList.MAX_LENGTH);
        this.words = new ArrayList<>();
        this.filePath = filePath;
    }

    // 새로운 단어등록, 기존단어 삭제 등의 변경사항을 파일에 저장
    public void fileSave() {
        File file = new File("단어장.txt");
        
        try (PrintWriter pw = new PrintWriter(file)) {
           
            // words 리스트에 있는 모든 데이터를 파일로 내보내기
            // 파일의 끝까지 반복
            for (JavaWord word : this.words) 
                pw.println(word);
            

        } catch (Exception e) {
            System.out.println("파일 출력 예외 발생 : " + e.getMessage());
        }
    }
   
    /**
     * 단어 인스턴스(JavaWord) 생성2
     * @param line
     * @return
     */
    public static JavaWord makeWord(String line) {
        String[] temp = line.split(",");

        JavaWord word = null;
        if (temp.length == 3) {
            word = new JavaWord(temp[0].trim()
                                        , temp[1].trim()
                                        , Integer.parseInt(temp[2].trim()));
        }

        return word;
    }

    // 단어장.txt 데이터를 읽어와 "words 리스트에 담기"
    /**
     * words 리스트에(List<JavaWord>) 단어 인스턴스 추가 
     */
    public void fileLoad() {

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;

            while ((line= br.readLine()) != null ) {

                if(line.trim().length() == 0) continue;
                
                JavaWord word = makeWord(line);
                
                if(word == null) continue;
                
                this.words.add(word);

            }
            
        } catch (Exception e) {
            System.out.println("파일 입출력 오류 : " + e.getMessage());
        }
    }

    public void addList() {
        
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
        if(words.size() == 5) 
            throw new IllegalArgumentException("단어장이 꽉찼습니다.");
           
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
        
        if(index < 0 || index > words.size())
            // throw new Exception("삭제할 인덱스 범위가 잘못된 값입니다 ");    // 체크드 익셉션
            throw new IllegalArgumentException("삭제할 인덱스 범위가 잘못된 값입니다"); // 언체크드 
            // 새로운 Exception 객체를 생성하면 개발자가 만든 예외가 발생됩니다 
            //  발생시킬 익센션 종류는 IllegalArgumentException 와 같은 이름으로 많이 사용
            //  예를 들면 웹개발할 때 모든 예외를 한번에 처리하기 위한 방법으로 이런 방법을 사용합니다

        JavaWord word = this.words.remove(index);       // 삭제할 위치의 단어 인스턴스를 리턴
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