package collection.day11;

public class Customer {
    private String name;
    private String phone;
    private int group;      // 1. Silver    2. VIP      3. OTHERS


    // Custom Constructor
    public Customer(String name, String phone, int group) {
        this.name = name;
        this.phone = phone;
        this.group = group;
    }


    // getter
    public String getName() {
        return name;
    }


    public String getPhone() {
        return phone;
    }


    public int getGroup() {
        return group;
    }

    // 데이터 수정
    public void modify(String phone, int group) {
        this.phone = phone;
        this.group = group;
    }


    // toString(테스트용)
    @Override
    public String toString() {
        return "Customer [name=" + name + ", phone=" + phone + ", group=" + group + "]";
    }


    


}
