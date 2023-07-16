
public class Animal {
    private String name;
    private String color;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void eat() {
        System.out.println("I'm eating");
    }
}


class Monkey extends Animal {
    public void climb() {
        System.out.println("I'm climb...");
    }
}


class Parrot extends Animal{
    public void fly() {
        System.out.println("I'm fly...");
    }
}


class Deer extends Animal{
    public void run() {
        System.out.println("I'm run...");
    }
}

