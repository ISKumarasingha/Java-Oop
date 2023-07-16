public class Loan extends Account{
    int ammount;
    int interest;
    int duration;
    String paymentMethod;
    
    public Loan(int ammount, int interest, int duration) {
        this.ammount = ammount;
        this.interest = interest;
        this.duration = duration;
    }

    public void printaccount() {
        System.out.println("Loan Account");
    }

    public void requestloan(int ammount, int interest, int duration){
        System.out.println("Success");
    }
}
