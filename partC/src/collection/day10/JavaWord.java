package collection.day10;

public class JavaWord {
    
    private String en;
    private String kor;
    private int level;

    

    public JavaWord(String en, String kor, int level) {
        this.en = en;
        this.kor = kor;     
        this.level = level;
    }



    @Override
    public String toString() {
        return this.en + ", " + this.kor + ", " + this.level;
    }


    //getter                    //setter    는 필요할 때 작성
    public String getEn() {
        return en;
    }

    public String getKor() {
        return kor;
    }



    public int getLevel() {
        return level;
    }

    
    
}
