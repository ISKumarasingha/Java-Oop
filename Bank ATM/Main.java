import java.util.*;
public class Main {
    public static void main(String[] args) {

        Client c1 = new Client("sanjana", "Sinhala", "Doctor", "ABC", 45, "Male",1234); // Create 1 st client
        c1.addaccount(2023001, "ABC", 10000, "Saving");  // Create saving account
        c1.addaccount(2023002, "ABC", 20000, "Current"); // Create Current account

        System.out.println("Welcome");
        System.out.print("Input your Pin : ");

        Scanner input = new Scanner(System.in); // Create a Scanner object
        int Pin = input.nextInt(); // Read user Pin

            if (c1.getPin()==Pin) {
                System.out.println("Your Accounts are");
                for (Account Account:c1.getArray_List()) {
                    System.out.println(Account.getAccount_number());
                }
        
            }else {
                System.out.println("Wrong pin");
            }

        System.out.print("Enter your account number : ");
        int AccountNum= input.nextInt();

        for (Account Account: c1.getArray_List()) {
            if (Account.account_number==AccountNum) {
                while (true) {
                    System.out.println("\nMain Menu");
                    System.out.println("1)View Balance.");
                    System.out.println("2)Withdraw money.");
                    System.out.println("3)Deposit money.");
                    System.out.println("4)Exit.");
                    System.out.print("Enter the number: ");
                    int choice = input.nextInt();

                    switch (choice) {
                    case 1:
                        Account.Balance();
                        break;
                    case 2:
                        System.out.print("Enter the money ");
                        int cash = input.nextInt();
                        Account.Withdrawal(cash);
                        break;
                    case 3:
                        System.out.print("Enter the money ");
                        int money = input.nextInt();
                        Account.Deposit(money);
                        break;
                    case 4:
                        return;
                    default :
                        System.out.println("Input valid number");
                    }
                }
            }
        } 
        input.close();
    }    
}
