public class Client {
    static int client_Id=1;
    String name;
    String nationality;
    String occipation;
    String address;
    int age;
    String gender;
    int pin;
    
    public Client(String name, String nationality, String occipation, String address, int age,
            String gender) {
        client_Id += 1;
        this.name = name;
        this.nationality = nationality;
        this.occipation = occipation;
        this.address = address;
        this.age = age;
        this.gender = gender;
        pin = client_Id;
    }
}
