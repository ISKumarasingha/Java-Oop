public class CarMain{
    public static void main(String[] args) {

        Car car1=new Car("Kumarasingha","blue",5);
        Car car2=new Car("sanjana","white", 0);

        System.out.println(car1.getColour()); 
        System.out.println(Car.getCarNum());
        Car.getCarNum(); // static method
        car1.staticName();
        car2.setCost(200);
        System.out.println(car2.getClass());
    }
}
