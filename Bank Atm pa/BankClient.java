import java.util.ArrayList;

class BankClient{
    static int prevClientId = 0;
    static int prevPin = 0;

    private int id;
    private String name;
    private String nationality;
    private String occupation;
    private String address;
    private int age;
    private Gender gender;
    private int pin;
    private ArrayList<BankAccount> accounts;

    public BankClient(String name, String nationality, String occupation, String address, int age,
            Gender gender) {

        this.id = ++prevClientId;
        this.name = name;
        this.nationality = nationality;
        this.occupation = occupation;
        this.address = address;
        this.age = age;
        this.gender = gender;
        this.pin = ++prevPin;
        this.accounts = new ArrayList<BankAccount>();
    }

    public BankAccount getAccount(String accountNumber) {
        for(BankAccount account : accounts){
            if(account.getId() == Integer.parseInt(accountNumber)){
                return account;
            }
        }
        return null;
    }

    public int numberOfAccounts() {
        return accounts.size();
    }

    public void showAccounts() {
        for(BankAccount account : accounts){
            System.out.println(BankAccount.getTypeName(account)+ ": " + account.getId());
        }
    }

    // add new account to the client
    public void addAccount(BankAccount account){

        // if accounts is null, create new arraylist
        if(accounts == null)
            accounts = new ArrayList<BankAccount>();

        boolean noOtherAccounts = accounts.size() == 0;
        // can add only if account currency is the same as others        
        if(noOtherAccounts){
            accounts.add(account);
            return;
        }

        boolean sameCurrency = accounts.get(0).getCurrency().equals(account.getCurrency());
        if(sameCurrency){
            accounts.add(account);
        }
        else{
            System.out.println("\nCannot add account with different currency!");
        }
    }

    // set pin only once, else return the same pin
    public int obtainPin(){
       return pin;
    }
}

enum Gender{
    Male,
    Female
}

abstract class BankAccount{
    // keep track of account numbers
    private static int prevAccNumber = 0;

    private int number;
    private String currency;
    private String branch;
    private double balance;
    private BankLoan loan;


    public BankAccount(String currency, String branch) {
        this.number = ++prevAccNumber;
        this.currency = currency;
        this.branch = branch;
        this.balance = 0;
    }

    public static String getTypeName(BankAccount account) {
        return account.getClass().getSimpleName();
    }

    public int getId() {
        return number;
    }

    public void withdraw(double amount) throws Exception{
        if(amount > this.balance){
            throw new Exception("Balance is insufficient for withdrawal");    
        }
        this.balance -= amount;
    }
    
    public void deposit(double amount){
        this.balance += amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void requestLoan(double amount, double duration, String paymentMethod, double rate){
        // create loan object
        // set loan object to this loan
        loan = new BankLoan(amount, rate, duration, paymentMethod);
    }

    public String showBalance() {
        return this.balance + " " + this.currency;
    }

}