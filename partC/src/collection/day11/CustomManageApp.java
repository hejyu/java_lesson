package collection.day11;

import java.util.ArrayList;
import java.util.List;


public class CustomManageApp {
    
    // Create Customer data structure
    private List<Customer> customerList = new ArrayList<>();


    public static void main(String[] args) {
        CustomManageApp app = new CustomManageApp();
        app.start();
    }

    private void start() {
        initialize();        // create Test use Customer data

        // choose one to do below : create, search(name, group), remove, modify, printAll
        System.out.println("Customer Management App START " + "~".repeat(30));

        while(true) {
            System.out.println("Choose one to do below ");
            System.out.println("\t 1. Create Customer");
            System.out.println("\t 2. Get Customer List");
            System.out.println("\t 3. Search Customer");
            System.out.println("\t 4. Remove Customer");
            System.out.println("\t 5. Modify Customer");
            System.out.println("\t 6. End Programm");

            System.out.print("선택 _");
            
            int sel = Integer.parseInt(System.console().readLine());    // keyboard typing smth.. -> number
            // System.console() : return system console Obj  -> readLine() 
            
            switch(sel){
                case 1: addCustomer(); break;
                case 2: listCustomer(); break;
                case 3: schList(); break;        
                case 4: removeCustomer(); break;
                case 5: modifyCustomer(); break;
                case 6: 
                    System.out.println("Application Stopped");
                    System.exit(0);             // stop main() running

                    break;
                default:
                    break;

            }
        }

    }

    private void modifyCustomer() {
        System.out.println("고객목록 ");
        listCustomer();

        System.out.println("수정할 고객이름 입력 _ ");
        String input = System.console().readLine();
        boolean isSearched = false;
        String phone = null;
        int group;

        for (int i = 0; i < customerList.size(); i++) {
            if(customerList.get(i).getName().equals(input)) {
                System.out.print("고객를 찾았습니다\n 수정하시겠어요?( 엔터를 a누르면 삭제될거에요)\n 취소는 n 을 입력하세요  _ ");
                
                if(System.console().readLine().equals("n")) {
                    continue;                   // 다음 고객 검색 
                }else {
                    isSearched = true;

                    System.out.print("전화번호 : ");
                    phone = System.console().readLine();
                    System.out.print("그룹 : ");
                    group = Integer.parseInt(System.console().readLine());
                    
                    customerList.get(i).modify(phone, group);
                    customerList.set(i, customerList.get(i));

                    System.out.println("고객이 수정되었어요");
                }
            }
        }
        
        if(!isSearched)
            System.out.println("수정할 고객이 단어장에 없습니다.");
        
        listCustomer();

    }

    private void removeCustomer() {
        System.out.println("고객목록 ");
        listCustomer();

        System.out.println("삭제할 고객이름 입력 _ ");
        String input = System.console().readLine();
        boolean isSearched = false;

        for (int i = 0; i < customerList.size(); i++) {
            if(input.equals(customerList.get(i).getName())) {
                System.out.print("고객을 찾았습니다\n 삭제하시겠어요?( 엔터를 누르면 삭제될거에요)\n 취소는 n 을 입력하세요  _ ");
                
                if("n".equals(System.console().readLine())){
                    continue;
                }else{
                    customerList.remove(i);
                    isSearched = true;
                    System.out.println("고객이 삭제되었어요");
                }
            }
        }

        if(!isSearched) {
            System.out.println("삭제할 고객이 없습니다.");
        }

        listCustomer();
    }

    private void schList() {
        System.out.print("\t ::고객을 검색합니다(고객명 검색 : 1, 분류 검색 : 2 ) ::  ");
        String schTxt = null;
        List<Customer> schList = null;

        switch (System.console().readLine()) {
            case "1":
                System.out.print("검색할 고객명을 입력하세요 _ ");
                schTxt = System.console().readLine();
                schList = schAllCustomer(schTxt);

                printCustomerList(schList);
                break;
            case "2":
                System.out.println("검색할 그룹을 입력하세요");
                int schInput = Integer.parseInt(System.console().readLine());   
                schList = schAllCustomer(schInput);
                
                printCustomerList(schList);
                break;
        
            default:
                break;
        }
    }

    private List<Customer> schAllCustomer(String schInput) {
        List<Customer> schList = new ArrayList<>();

        for(Customer customer : customerList) {
            if(customer.getName().equals(schInput)){
                schList.add(customer);
            }
        }

        return schList;
    }

    private List<Customer> schAllCustomer(int schInput) {
        List<Customer> schList = new ArrayList<>();

        for(Customer customer : customerList) {
            if(customer.getGroup() == schInput){
                schList.add(customer);
            }
        }

        return schList;
    }

    private void listCustomer() {
        System.out.println(String.format("%-20s %-20s %-20s",
                                                    "Name", "Phone", "Group"));
        printCustomerList(customerList);
    }

    private void addCustomer() {
        System.out.print("고객명 _ ");
        String name = System.console().readLine();

        System.out.println("연락처 _ ");
        String phone = System.console().readLine();
        
        System.out.println("분류 _ ");
        int group = Integer.parseInt(System.console().readLine());
        
        customerList.add(new Customer(name, phone, group));
    }

    private void printCustomerList(List<Customer> list) {
        for (Customer customer : list) {
            System.out.println(String.format("%-20s %-20s %-20s",
                                            customer.getName(), customer.getPhone(), customer.getGroup()));
        }
    }

    private void initialize() {
        customerList.add(new Customer("momo","010-1234-5678", 1));
        customerList.add(new Customer("rose","010-1235-5678", 2));
        customerList.add(new Customer("lisa","010-1236-5678", 2));
        customerList.add(new Customer("jisu","010-1237-5678", 2));
        customerList.add(new Customer("sana","010-1238-5678", 1));
    }


}
