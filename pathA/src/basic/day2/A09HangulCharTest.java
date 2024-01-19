package basic.day2;

public class A09HangulCharTest {
    public static void main(String[] args){
        
        char m_start = '나';			// \\u 는 유니코드를 나타내는 이스케이프 문자(16진수로 표시)
        char m_end   = '낟';
        int m_code_start = m_start;
        int m_code_end   = m_end;        // 유니코드는 한글로 자동형변환 
        

        try {

            while (m_start <= m_end) {
                System.out.print(m_start++ + " ");
            }
            System.out.println();
            System.out.println("총 " + (char)m_code_start +" ~ " + (char)m_code_end + " 까지 코드 갯수 " + (m_code_end - m_code_start + 1) + " 개");

        } catch (Exception e) {

            System.out.println(e);

        }

    }
}
