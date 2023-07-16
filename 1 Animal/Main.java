public class Main {
    public static void main(String[] args) {
        Deer d1 = new Deer();
        Monkey m1 = new Monkey();
        Parrot p1 = new Parrot();
        Deer d2 = new Deer();

        // call methods
        m1.climb();
        p1.fly();
        d1.run();
        d2.eat(); // can access super class 

        // print objeccts
        System.out.println(m1);

        // upcasting
        // Can access Animal class only
        Animal d3 = new Deer(); 
        Animal p2 = new Parrot();

        System.out.println(d3.getClass()); // get class
        d1.setColor("Orange");
        d3.setName("Kama");
        p2.setColor("green");

        // downcasting
        Deer d4 = (Deer) d3;
        Parrot p3 = (Parrot) p2;

        // d3.run();   can't
        d4.run();     //can
        p3.eat();
    }
}
