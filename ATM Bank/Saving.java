public class Saving extends Account{
    int rate = 5/100;
    
    public void interest(){
        int interest = balance * rate;
        System.out.println("Interest is : "+interest);
    }

    public void printaccount() {
        System.out.println("Saving Account");
    }
}
