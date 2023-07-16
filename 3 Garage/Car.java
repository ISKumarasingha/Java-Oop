public class Car {
    private String name;
    private String colour;
    private int VehicalNo;
    private double cost;
    private static int carNum;

    
    public Car(String name, String colour, double cost) {
        carNum += 1;
        this.name = name;
        this.colour = colour;
        VehicalNo = carNum;
        this.cost = cost;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getColour() {
        return colour;
    }
    
    public void setColour(String colour) {
        this.colour = colour;
    }
    
    public int getVehicalNo() {
        return VehicalNo;
    }
    
    public void setVehicalNo(int vehicalNo) {
        VehicalNo = vehicalNo;
    }
    
    public double getCost() {
        return cost;
    }
    
    public void setCost(double cost) {
        this.cost = cost;
    }
    
    public static int getCarNum() {
        return carNum;
    }

    public void staticName(){
        System.out.println("My name is sanjana");
    }

    public void normalmethod(){
        System.out.println(this);
    }
}
