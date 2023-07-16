public class Current extends Account{
    public Current(int account_number, String branch, int balance, int amount) {
        super(account_number, branch, balance, amount);
    }

    public void printaccount() {
        System.out.println("Current Account");
    }
}
