public class Loan extends Account{
    int ammount;
    int interest;
    int duration;
    String paymentMethod;

    public Loan(int account_number, String branch, int balance, int amount, int ammount, int interest, int duration,
            String paymentMethod) {
        super(account_number, branch, balance, amount);
        this.ammount = ammount;
        this.interest = interest;
        this.duration = duration;
        this.paymentMethod = paymentMethod;
    }

    public void requestloan(int ammount, int interest, int duration){
        System.out.println("Success");
    }
}
