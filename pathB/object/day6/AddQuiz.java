package object.day6;

public class AddQuiz {

    private int data1;          // 랜덤 숫자 1
    private int data2;          // 랜덤 숫자 2
    private int userAnswer;     // 제출한 숫자

    public AddQuiz() {
    }
    

    public AddQuiz(int start, int end) {    //매개변수가 2개인 커스텀 생성자를 생성
        createQuiz(start, end);             //11~99사이의 덧셈 문제 생성
    }
    
    public void setUserAnswer(int userAnswer) {
        this.userAnswer = userAnswer;
    }
    
    public int getData1() {
        return data1;
    }


    public int getData2() {
        return data2;
    }


    public int getUserAnswer() {
        return userAnswer;
    }
    

    public boolean checkAnswer(){
        return (this.userAnswer == this.data1 + this.data2) ? true : false;
    }

    // 랜덤 숫자를 생성하는 함수
    public int makeRandomNumber(int start, int end) {
        return (int)(Math.random()*(end-start+1)) + start;
    }

    /**
     * 시작값 마지막값 의 범위를 매개변수로 받아 
     * AddQuiz 인스턴스 필드를 초기화하는 함수
     * @param start
     * @param end
     */
    public void createQuiz(int start, int end){     
        this.data1 = makeRandomNumber(start, end);
        this.data2 = makeRandomNumber(start, end);
    }
    
    public String printResult() {
        StringBuilder sb = new StringBuilder();
        int answer;
        char isCorrect;        

        answer = this.data1 + this.data2;
        isCorrect = checkAnswer() ? 'O' : 'X';
        sb.append(String.format("문제 : %3d + %3d \t 제출한 답 : %3d \t 정답 : %3d \t 채점 : %c", this.data1, this.data2, this.userAnswer, answer, isCorrect));

        return sb.toString();
    }

    

    
}
