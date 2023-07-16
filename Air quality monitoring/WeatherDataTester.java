// import java.util.Comparator;

// Node class to store weather data records
// Node class to store weather data records
class Node {
    private String dateTime;
    private double measurement;
    private Node next;

    public Node(String dateTime, double measurement) {
        this.dateTime = dateTime;
        this.measurement = measurement;
        this.next = null;
    }

    public String getDateTime() {
        return dateTime;
    }

    public double getMeasurement() {
        return measurement;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}


// LinkedList class to store a collection of weather data records
class LinkedList {
    private Node head;

    public LinkedList() {
        head = null;
    }

    public void addRecord(Node newNode) {
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            Node previous = null;
            while (current != null && current.getDateTime().compareTo(newNode.getDateTime()) < 0) {
                previous = current;
                current = current.getNext();
            }
            if (previous == null) {
                newNode.setNext(head);
                head = newNode;
            } else {
                previous.setNext(newNode);
                newNode.setNext(current);
            }
        }
    }

    public void printRecords() {
        Node current = head;
        while (current != null) {
            System.out.println("Date-Time: " + current.getDateTime() + ", Measurement: " + current.getMeasurement());
            current = current.getNext();
        }
    }
}


// WeatherDataTester class to test the weather data storage system
public class WeatherDataTester {
    public static void main(String[] args) {
        LinkedList weatherData = new LinkedList();
        
        // Creating weather data records
        Node record1 = new Node("07FEB2020-07:52", 10.2);
        Node record2 = new Node("08FEB2020-12:30", 12.5);
        Node record3 = new Node("09FEB2020-09:15", 8.7);
        Node record4 = new Node("07FEB2020-07:00", 1.2);
        
        // Adding records to the linked list
        weatherData.addRecord(record1);
        weatherData.addRecord(record2);
        weatherData.addRecord(record3);
        weatherData.addRecord(record4);
        
        // Printing records in chronological order
        weatherData.printRecords();
    }
}
