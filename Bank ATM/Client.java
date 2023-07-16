import java.util.ArrayList;

public class Client {
    static int client_Id=1;
    String name;
    String nationality;
    String occipation;
    String address;
    int age;
    String gender;
    int pin;
    private ArrayList <Account> Array_List;
    
    public Client(String name, String nationality, String occipation, String address, int age,
            String gender, int pin) {
        client_Id += 1;
        this.name = name;
        this.nationality = nationality;
        this.occipation = occipation;
        this.address = address;
        this.age = age;
        this.gender = gender;
        this.pin = pin;
        Array_List = new ArrayList<>();
    }

    public void addaccount(int account_number, String branch, int balance, String type) {
        if (type=="Saving") {
            Saving s1=new Saving(account_number, branch, balance, account_number);
            Array_List.add(s1);
        }
        else if (type=="Current") {
            Current c1=new Current(account_number, branch, balance, account_number);
            Array_List.add(c1);
        }
    }

    public int getPin() {
        return pin;
    }

    public ArrayList<Account> getArray_List() {
        return Array_List;
    }
}
