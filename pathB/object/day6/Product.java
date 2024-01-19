package object.day6;

import java.util.Arrays;

public class Product {


    private String productName;
    private int price;
    private String company;
    private String[] etc;

    // 커스텀 생성자 만들기
    // public Product() {

    // }

    public Product(String productName, int price, String company, String[] etc) {
        this.productName = productName;
        this.price = price;
        this.company = company;
        this.etc = etc;
    }

    public String getProductName() {
        return productName;
    }

    public int getPrice() {
        return price;
    }

    public String getCompany() {
        return company;
    }

    public String[] getEtc() {
        return etc;
    }

    // 모든 필드값을 이용해 문자열을 만들어 리턴
    public String getData() {

        // 자리 지정시
        // -를 붙이면 왼쪽 정렬, 기본은 가운데 정렬
        return String.format("%-20s\t %,-20원d\t %10s\t %-20s", this.productName, this.price, this.company, Arrays.toString(this.etc));
    }






    
}
