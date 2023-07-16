import java.sql.Date;

public class ATM extends Account{

    static int transction_id;
    int bankaccount_id;
    Date date;

    public ATM(int account_number, String branch, int balance, int amount, int bankaccount_id, Date date) {
        super(account_number, branch, balance, amount);
        transction_id += 1;
        this.bankaccount_id = bankaccount_id;
        this.date = date;
    }

    public void Status() {
        System.out.println("Success");
    }
}
