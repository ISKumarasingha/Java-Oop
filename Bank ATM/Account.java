public class Account {
    int account_number;
    static String currency="Rs ";
    String branch;
    int balance;
    int amount;

    public Account(int account_number, String branch, int balance, int amount) {
        this.account_number = account_number;
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

    public int getAccount_number() {
        return account_number;
    }

}
