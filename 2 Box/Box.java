public class Box {
    private double length;
    private double height;
    private double width;

    public Box(double length, double height, double width) {
        this.length = length;
        this.height = height;
        this.width = width;
    }

    public Box(double length, double height) {
        this.length = length;
        this.height = height;
        this.width = 2;
    }

    public void printVolume(){
        double Volume = length*height*width;
        System.out.println(this+" Volume is: "+ Volume);
    }  
}