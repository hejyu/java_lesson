package io.javaword;

import java.util.List;

import collection.day10.JavaWord;

// 자바 단어장 클래스 아래의 추상메소드는 꼭 구현해야함(기능 또는 규칙)
public interface WordList {

    // 최대 단어 개수 100개를 설정한다면
    // public static final  생략해도 상수
    int MAX_LENGTH = 100;

    //추상메소드 정의 - 구현 내용은 클래스의 특징에 따라 달라짐
    JavaWord getWord(int i);
    List<JavaWord> list();
    void add(JavaWord word);
    int indexOfWord(String word, int position);
    JavaWord remove(int index);
    JavaWord schFirstWord(String en);
    List<JavaWord> schWordBy(String en);
    List<JavaWord> schWordBy(int level);
    void print();


    
    // default : implements 클래스 외에 이후 구현하는 메소드에 붙임
    default List<JavaWord> search(Object object) {
        return null;
    }


} 
