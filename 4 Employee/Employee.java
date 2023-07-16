public class Employee {
    // This class not having encapsulation.
    String name;
    int id;
    
    public Employee(String name, int id){
        this.name =  name;
        this.id = id;
    }

    public void run(){
        System.out.println("Running");
    }

    public void printsalary(double workingHours, double hourlyRate) {
        double salary = workingHours*hourlyRate;
        System.out.println(salary);
    }
}
