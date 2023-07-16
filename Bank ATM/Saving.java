public class Saving extends Account{
    
    public Saving(int account_number, String branch, int balance, int amount) {
        super(account_number, branch, balance, amount);
    }

    int rate = 5/100;
    
    public void interest(){
        int interest = balance * rate;
        System.out.println("Interest is : "+interest);
    }
}
