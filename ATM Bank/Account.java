public class Account extends Client{
    static int account_number;
    String currency="Rs ";
    String branch;
    int balance;
    int amount;
    
    public Account(int account_number, String branch, int balance) {
        account_number += 1;
        this.branch = branch;
        this.balance = balance;
    }

    public void Balance() {
        System.out.println("Remaining balance is : "+ balance);
    }

    public void Withdrawal(int amount) {
        balance -= amount;
        System.out.println("Remaining balance is : "+ balance);
    }

    public void Deposit(int amount) {
        balance += amount;
        System.out.println("Remaining balance is : "+ balance);
    }

}
