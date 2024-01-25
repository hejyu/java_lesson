package koreait.test;

/**
 * 작성자 : 조하연
 */
public abstract class Product {     // [0]
  
    protected int price;
    protected String prdName;       // [1]

    public abstract String sell(Object obj);    // [2]

    public Product(int price, String prdName) {
        this.price = price;
        this.prdName = prdName;
    }

    public int getPrice() {
        return price;
    }

    public String getPrdName() {
        return prdName;
    }

    @Override
    public String toString() {
        return "price=" + price + ", prdName=" + prdName;
    }

    

    
}
