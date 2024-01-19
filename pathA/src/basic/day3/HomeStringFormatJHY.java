package basic.day3;

import java.util.Date;
import java.util.Locale;

public class HomeStringFormatJHY {
    public static void main(String[] args) {
        // String 클래스의 format 메소드
        // - 문자열 출력 메소드
        // - 정수,실수, 국가별 데이터형식, 문자열, 날짜형식, 유니코드 문자 등 형식 지정자를 사용
        // %s : String Formatting
        // %f : Floating point Formatting
        // %c : Unicode char Formatting
        // %tA(day of Week, Full name): 목요일, %ta: 목
        // %tB(month, Full name): 3월, %tb: 3월
        // %tB(month, Full name): March, %tb: Mar
        // %tc(= %ta %tb %td %tT %tZ %tY): 목 3월 05 14:07:09 KST 2020
        // %tD(MM/dd/yy): 03/05/20
        // %td(02d): 05, %te(d): 5
        // %tF(yyyy-02M-02d): 2020-03-05
        // %tH(02H, 00-23): 14, %tk(H, 0-23): 14
        // %tI(02h, 01-12): 02, %tl(h, 1-12): 2
        // %tj(day of Year, 001-366): 065
        // %tp(오전 또는 오후): 오후

        String m_data = "tete";
        Date m_date = new Date();

        System.out.println(String.format("안녕하세요 저는 %s이고 %d살 입니다", "조하연", 26));	//안녕하세요 저는 조하연이고 26살 입니다 
        System.out.println(String.format(Locale.ENGLISH, "%tp", m_date));	// am
        System.out.println(String.format("97 → %c, 122 → %c", 97, 122));		// 97 → a, 122 → z
        System.out.println(String.format("%-12s_", m_data));			// tete        _
    }
}
