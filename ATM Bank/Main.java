import java.util.*;
public class Main {
    public static void main(String[] args) {

        Client c1 = new Client("sanjana", "Sinhala", "Doctor", "ABC", "Male", "001"); // Creae 1 st client

        System.out.println("Welcome");
        System.out.println("Input your Pin");

        Scanner input = new Scanner(System.in); // Create a Scanner object
        String Pin = input.nextLine(); // Read user Pin

        System.out.println(Client(pin).printaccount());
        System.out.println("Your Accounts ");
        c1.printaccount(); // print every occount user 

        System.out.println("1)View Balance.");
        System.out.println("2)Withdraw money.");
        System.out.println("3)Deposit money.");
        System.out.println("4)Exit.");
        
    } 
}
