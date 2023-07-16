//import java.util.*;

public class Coffee extends Machine {
    int coffeePrice = 20;
    int calories = 12345;

    public int getCoffeePrice() {
        return coffeePrice;
    }

    public void setCoffeePrice(int coffeePrice) {
        this.coffeePrice = coffeePrice;
    }
    
    public void setCalories(int calories) {
        this.calories = calories;
    }

    public int getCalories(){
        return calories;
    }

    public void printCalories() {
        System.out.println(super.printCalories() + calories + " calories");
    }
}
