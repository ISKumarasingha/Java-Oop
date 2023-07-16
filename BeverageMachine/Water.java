//import java.util.*;

public class Water extends Machine {
    int waterPrice = 5;
    int calories = 0;

    public int getWaterPrice() {
        return waterPrice;
    }

    public void setWaterPrice(int waterPrice) {
        this.waterPrice = waterPrice;
    }
    
    public int getCalories(){
        return calories;
    }

    public void printCalories() {
        System.out.println(super.printCalories() + calories + " calories");
    }
}
