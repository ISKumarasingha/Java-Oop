public class main{
    public static void main(String[] args) {

        Car car1=new Car("Kumarasingha","blue",5);
        Car car2=new Car("sanjana","white", 0);

        System.out.println(car1.getColour()); 
        System.out.println(Car.getCarNum());
        Car.staticmethod();
        car1.normalName();
        car2.cost=200;
        car2.getClass();
    }
}
