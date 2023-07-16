//import java.util.*;

class Machine{

    static int cupId = 0;
    static int cup = 0;

    public void printName() {
        System.out.println( "This is your " + this.getClass().getName());
    }

    public void printGreeting() {
        System.out.println( "Enjoy your " + this.getClass().getName());
    }

    public int printCalories(){
      System.out.println( "Your " + this.getClass().getName() + " has ");
    }



        /*Psvm{
        //create a beverage machine
        // take console input
        if (command == 0)
         <beverage name>
        Get the beverage machine to produce the beverage
        print its name to console
        if (command == 1)
        Get the beverage machine to calculate the amount of calories in the cup that it
        last produced.
        Print this value to the console
        if (command == 2)
        Get the beverage machine to return the number of coffee+tea cups it produced
        Print this value to the console
        else 
        //print “invalid input”
        }*/
    }