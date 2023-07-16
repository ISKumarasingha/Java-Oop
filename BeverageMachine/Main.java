import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Tea ga = new Tea();
        ga.printName();
        ga.printCalories();
        ga.printGreeting();
        
        Coffee ba = new Coffee();
        ba.printName();
        ba.printCalories();
        ba.printGreeting();

        Scanner input = new Scanner(System.in);
        int command = input.nextInt();

        switch (command){
            case 0: System.out.println("A");Water.printCalories();break;
            case 1 : System.out.println("B");break;
            case 2 : System.out.println("C");break;
            case 4 : System.out.println("D");break;
            default : System.out.println("End switch");
        }
        input.close();
        
    }   
}
