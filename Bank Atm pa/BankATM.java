import java.util.Scanner;
import java.util.ArrayList;

class BankATM{
    // scanner to get input from user
    static Scanner atmScanner = new Scanner(System.in);
    private static ArrayList<Transaction> allTransactions = new ArrayList<Transaction>();
    private BankClient loggedInClient;

    // Get pin from user and try to login
    // if login is successful return true
    public boolean login(){
        
        // client is shown “Welcome!” and asked to enter the PIN
        System.out.println("\nWelcome!");
        
        int pin = -1;
        while(pin == -1){
            pin = inputPin();
        }

        // get client associated with the pin
        // if client exits show all accounts of the client
        BankClient client = getClient(pin);
        loggedInClient = client;
        return client != null;
    }

    private int inputPin() {
        System.out.print("Enter the Pin: ");
        int pin = inputChoice();
        return pin;
    }

    public void process() {
        // ask for the account to be used for processing
        BankAccount account = selectAccount();
        if(account == null){
            return;
        }
        // create new transaction 
        Transaction transaction = new Transaction(account);

        // perform transaction
        performTransaction(transaction);

        // log out current client
        logout();
    }

    private void performTransaction(Transaction transaction) {
        int choice = selectOption();
        switch(choice){
            case 1:
                transaction.checkBalance();
                break;
            case 2:
                System.out.print("\nEnter amount to withdraw: ");
                double amount = inputTransactionAmount();
                transaction.withDrawal(amount);
                break;
            case 3:
                System.out.print("\nEnter amount to deposit: ");
                double amountToDeposit = inputTransactionAmount();
                transaction.deposit(amountToDeposit);
                break;
            case 4:
                System.out.println("\nATM closed!");
                System.exit(0);
                break;
        }

        allTransactions.add(transaction);
    }

    private double inputTransactionAmount() {
        double amount = atmScanner.nextDouble();
        atmScanner.nextLine();
        return amount;
    }

    private void logout() {
        loggedInClient = null;
    }

    private BankClient getClient(int pin){
        for(BankClient client : BankATMWebsite.clients){
            if(client.obtainPin() == pin){
                return client;
            }
        }
        return null;
    }

    private static int selectOption(){
        System.out.println("1. View Balance");
        System.out.println("2. Withdraw money");
        System.out.println("3. Deposit money");
        System.out.println("4. Exit");

        System.out.print("\nEnter your choice: ");
        try{
            int choice = inputChoice();
            if(choice < 1 || choice > 4)
                return selectOption();
            return choice;
        }
        catch(Exception e){
            System.out.println("Invalid choice");
            return selectOption();
        }
    }

    private static int inputChoice() {
        int choice = atmScanner.nextInt();
        atmScanner.nextLine();
        return choice;
    }

    private BankAccount selectAccount(){
        BankClient client = loggedInClient;
        if(client == null){
            return null;
        }
        
        System.out.println("\nSelect account to use from the following - ");
        client.showAccounts();

        String accountNumber = "";
        while(accountNumber.isEmpty()){
            System.out.print("\nEnter selected account number: ");
            accountNumber = atmScanner.nextLine();
        }        

        return client.getAccount(accountNumber);
    }
}