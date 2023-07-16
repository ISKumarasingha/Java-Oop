//import java.util.*;

public class Tea extends Machine {
    int TeaPrice = 10;
    int calories = 1234;

    public int getTeaPrice() {
        return TeaPrice;
    }

    public void setTeaPrice(int teaPrice) {
        TeaPrice = teaPrice;
    }   

    public int getCalories(){
        return calories;
    }

    public void printCalories() {
        System.out.println(super.printCalories() + calories + " calories");
    }
    
}
