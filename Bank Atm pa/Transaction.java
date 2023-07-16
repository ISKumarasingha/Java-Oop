class Transaction{
    // keep track of transaction ids
    private static int previousId = 0;

    private int id;
    private int bankAccountId;
    private BankAccount accountInstance;
    private String date;
    private TransactionStatus status;

    public Transaction(BankAccount bankAccount) {
        this.id = ++previousId;
        this.bankAccountId = bankAccount.getId();
        this.accountInstance = bankAccount;
    }

    // status should be set internally
    private void setStatus(TransactionStatus status){
        this.status = status;
    }

    // date should be set internally
    private void setDate(String date){
        this.date = date;
    }

    public void endTransaction(TransactionStatus status){
        setStatus(status);
        setDate("Current Date");
        // free the memory allocated for account instance
        accountInstance = null;
    }

    public void withDrawal(double amount){
        // withdraw amount from the account
        // if successful, set status to success
        // else set status to failure
        try{
            accountInstance.withdraw(amount);
            System.out.println("Amount withdrawn: "+ accountInstance.showBalance());
            endTransaction(status.SUCCESS);
        }
        catch(Exception e){
            // print the exception message
            System.out.println(e.getMessage());
            endTransaction(status.FAILURE);
        }
    }


    public void deposit(double amount){
        accountInstance.deposit(amount);
        System.out.println("Amount deposited: "+ accountInstance.showBalance());
        endTransaction(status.SUCCESS);
    }

    public void checkBalance(){
        System.out.println("Balance: "+ accountInstance.showBalance());
        endTransaction(status.SUCCESS);
    }
}

