package object.day6;


public class CartJHY {
    private String userId;          // 고객명
    private String[] productNames;  // 상품이름
    private int[] prices;           // 상품가격
    private int totalMoney;         // 구매를 선택한 상품의 총가격


    public void sum(int[] select){
        int sum = 0;

        for(int i=0; i< select.length; i++){
            if(select[i] == -1) break;
            sum += prices[select[i]];
        }

        this.totalMoney = sum;
    }

    public String getUserId() {
        return this.userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String[] getProductNames() {
        return this.productNames;
    }

    public void setProductNames(String[] productNames) {
        this.productNames = productNames;
    }

    public int[] getPrices() {
        return this.prices;
    }

    public void setPrices(int[] prices) {
        this.prices = prices;
    }

    public int getTotalMoney() {
        return this.totalMoney;
    }

    public void setTotalMoney(int totalMoney) {
        this.totalMoney = totalMoney;
    }


    //모든 인스턴스 값을 출력해주는메소드
	public void printData(){
        System.out.println("\n고객 식별 데이터: "+userId+" || 담기한 상품이름: "+productNames.toString()+" || 상품가격 데이터: "+prices.toString());
	}
    




}
