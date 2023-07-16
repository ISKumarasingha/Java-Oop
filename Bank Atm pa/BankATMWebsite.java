import java.util.ArrayList;

public class BankATMWebsite{

    // the list of clients in the bank
    protected static ArrayList<BankClient> clients = new ArrayList<BankClient>();
    protected static BankATM bankATM = new BankATM();
    public static void main(String[] args) {

        addDummyData();
        
        while(true) {      

            boolean loginSuccessful = bankATM.login();      
            // check if authentication is successful
            if(!loginSuccessful){
                System.out.println("Invalid Pin");
                continue;
            }

            // start transaction
            bankATM.process();
        }    
    }

    private static void addDummyData() {
        // create new client
        BankClient dummyClient = new BankClient(
            "Client name",
            "Client nationality",
            "Client occupation",
            "Client address",
            20,
            Gender.Male
        );

        // add accounts to the client
        dummyClient.addAccount(new SavingsAccount("LKR", "Branch 1"));
        dummyClient.addAccount(new CurrentAccount("LKR", "Branch 2"));

        // dummy data for 
        clients.add(dummyClient);
    }
}





class SavingsAccount extends BankAccount{
    public SavingsAccount(String currency, String branch) {
        super(currency, branch);
    }

    public void payInterest(){
        // pay interest to the account
    }
}

class CurrentAccount extends BankAccount{
    public CurrentAccount(String currency, String branch) {
        super(currency, branch);
    }
}

class BankLoan{
    private double amount;
    private double interestRate;
    private double duration;
    private String paymentMethod;

    public BankLoan(double amount, double interestRate, double duration, String paymentMethod) {
        this.amount = amount;
        this.interestRate = interestRate;
        this.duration = duration;
        this.paymentMethod = paymentMethod;
    }
}

enum TransactionStatus{
    SUCCESS,
    FAILURE,
    CANCELLATION
}

