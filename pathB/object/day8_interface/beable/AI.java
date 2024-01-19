package object.day8_interface.beable;

public class AI implements Thinkable{

    protected char op;
    
    public void setOp(char op) {
        this.op = op;
    }

    public char getOp() {
        return op;
    }

    @Override
    public int calculate(int a, int b) {
        int result = 0;
        switch (op) {
            case '+':
                result = a + b;
                break;
            case '-':
                result = a - b;
                break;
            case '*':
                result = a * b;
                break;
            case '/':
                result = a / b;
                break;
            default:
                result = -999999;
                break;
        }
        return result;
    }

    @Override
    public void think() {
        System.out.println("학습된 정보를 수집");
        
    }

    @Override
    public String beAble() {
        return "생각할 수 있음";
    }

    @Override
    public String toString() {
        return "AI [op=" + op + "]";
    }


    
    


    
    
}
