public class Monster {
    private int age;
    private String name;
    public Monster(int age, String name){
        this.age = age;
        this.name = name;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
    public void setAge(int age){
        this.age = age;
    }
    public int getAge(){
        return age;
    }
    /*public void steal(Warrior warrior){
        warrior.lose_stick();
    }*/
}
