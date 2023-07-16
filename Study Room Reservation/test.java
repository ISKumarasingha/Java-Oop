import java.util.ArrayList;
import java.util.List;

/*class StudyRoom {
    private int roomNumber;
    private int capacity;
    private boolean availability;

    public StudyRoom(int roomNumber, int capacity) {
        this.roomNumber = roomNumber;
        this.capacity = capacity;
        this.availability = true;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public int getCapacity() {
        return capacity;
    }

    public boolean isAvailable() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }
}*/

class StudyRoomReservationSystem {
    /*private List<StudyRoom> studyRooms;

    public StudyRoomReservationSystem() {
        this.studyRooms = new ArrayList<>();
    }

    public void addStudyRoom(StudyRoom studyRoom) {
        studyRooms.add(studyRoom);
    }*/

    public void reserveStudyRoom(int roomNumber) throws StudyRoomUnavailableException {
        StudyRoom room = getStudyRoomByNumber(roomNumber);
        if (room != null) {
            synchronized (room) {
                if (!room.isAvailable()) {
                    throw new StudyRoomUnavailableException("Study room " + roomNumber + " is already occupied.");
                }
                room.setAvailability(false);
                System.out.println("Study room " + roomNumber + " reserved successfully.");
            }
        } else {
            System.out.println("Study room " + roomNumber + " does not exist.");
        }
    }

    public void releaseStudyRoom(int roomNumber) {
        StudyRoom room = getStudyRoomByNumber(roomNumber);
        if (room != null) {
            synchronized (room) {
                if (room.isAvailable()) {
                    System.out.println("Study room " + roomNumber + " is already vacant.");
                } else {
                    room.setAvailability(true);
                    System.out.println("Study room " + roomNumber + " released successfully.");
                }
            }
        } else {
            System.out.println("Study room " + roomNumber + " does not exist.");
        }
    }

    /*public void displayStudyRoomStatus() {
        for (StudyRoom room : studyRooms) {
            String status = room.isAvailable() ? "Available" : "Occupied";
            System.out.println("Room " + room.getRoomNumber() + " - Capacity: " + room.getCapacity() + " - Status: " + status);
        }
    }*/

    /*private StudyRoom getStudyRoomByNumber(int roomNumber) {
        for (StudyRoom room : studyRooms) {
            if (room.getRoomNumber() == roomNumber) {
                return room;
            }
        }
        return null;
    }*/
}

class StudyRoomUnavailableException extends Exception {
    public StudyRoomUnavailableException(String message) {
        super(message);
    }
}

public class Main {
    public static void main(String[] args) {
        StudyRoomReservationSystem system = new StudyRoomReservationSystem();
    
        // Create study rooms
        StudyRoom room1 = new StudyRoom(101, 4);
        StudyRoom room2 = new StudyRoom(102, 6);
        StudyRoom room3 = new StudyRoom(103, 8);
        StudyRoom room4 = new StudyRoom(104, 10);
    
        // Add study rooms to the reservation system
        system.addStudyRoom(room1);
        system.addStudyRoom(room2);
        system.addStudyRoom(room3);
        system.addStudyRoom(room4);
    
        // Display initial status of all study rooms
        System.out.println("Initial Study Room Status:");
        system.displayStudyRoomStatus();
        System.out.println();
    
        try {
            // Simulate concurrent study room reservation and release operations
            Thread reservationThread1 = new Thread(() -> {
                try {
                    system.reserveStudyRoom(101);
                } catch (StudyRoomUnavailableException e) {
                    System.out.println("Exception: " + e.getMessage());
                }
            });
    
            Thread reservationThread2 = new Thread(() -> {
                try {
                    system.reserveStudyRoom(102);
                } catch (StudyRoomUnavailableException e) {
                    System.out.println("Exception: " + e.getMessage());
                }
            });
    
            Thread releaseThread1 = new Thread(() -> system.releaseStudyRoom(101));
            Thread releaseThread2 = new Thread(() -> system.releaseStudyRoom(102));
    
            reservationThread1.start();
            reservationThread2.start();
            releaseThread1.start();
            releaseThread2.start();
    
            reservationThread1.join();
            reservationThread2.join();
            releaseThread1.join();
            releaseThread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    
        System.out.println();
    
        // Display final status of all study rooms after the operations
        System.out.println("Final Study Room Status:");
        system.displayStudyRoomStatus();
    }
}