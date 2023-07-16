import java.util.ArrayList;

class StudyRoom {
    private int roomNumber;
    private int capacity;
    private Boolean availabilityStatus;

    // constructor
    public StudyRoom(int roomNumber, int capacity) {
        this.roomNumber = roomNumber;
        this.capacity = capacity;
        this.availabilityStatus = true;    
    }

    // Getters & Setters methods
    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public Boolean isAvailable() {
        return availabilityStatus;
    }

    public void setAvailability(Boolean availabilityStatus) {
        this.availabilityStatus = availabilityStatus;
    }
}

// Exception class
class StudyRoomUnavailableException extends Exception {
    public StudyRoomUnavailableException(String message) {
        super(message);
    }
}


public class StudyRoomReservationSystem extends Thread {
    private ArrayList<StudyRoom> studyRooms;

    // constructor
    public StudyRoomReservationSystem() {
        this.studyRooms = new ArrayList<>();
    }

    // Rooms add to the studyRooms ArrayList
    public void addStudyRoom(StudyRoom studyRoom) {
        studyRooms.add(studyRoom);
    }

    // Input Room_Number is valid number or not
    private StudyRoom isStudyRoomAvailable(int roomNumber) {
        for (StudyRoom room : studyRooms) {
            if (room.getRoomNumber() == roomNumber) {
                return room;
            }
        }
        return null;
    }

    // Room reservation
    public void reserveStudyRoom(int roomNumber) throws StudyRoomUnavailableException {
        StudyRoom room = isStudyRoomAvailable(roomNumber);
        if (room != null) {
            synchronized (room) {
                if (!room.isAvailable()) {
                    throw new StudyRoomUnavailableException("Study room : " + roomNumber + " is already occupied.");
                }
                room.setAvailability(false);
                System.out.println("Study room : " + roomNumber + " reserved successfully.");
            }
        } else {
            System.out.println("Study room : " + roomNumber + " does not exist.");
        }
    }

    // Room cancellation
    public void cancelStudyRoom(int roomNumber) throws StudyRoomUnavailableException {
        StudyRoom room = isStudyRoomAvailable(roomNumber);
        if (room != null) {
            synchronized (room) {
                if (room.isAvailable()) {
                    throw new StudyRoomUnavailableException("Study room : " + roomNumber + " is not reserved.");
                }else {
                    room.setAvailability(true);
                    System.out.println("Study room : " + roomNumber + " cancellation successfully.");
                }
            }
        } else {
            System.out.println("Study room : " + roomNumber + " does not exist.");
        }
    }
    
    // Display Rooms availability.
    public void displayStudyRoomStatus() {
        System.out.println("Study Room Status:");
        for (StudyRoom room : studyRooms) {
            String status = room.isAvailable() ? "Available" : "Occupied";
            System.out.println("Room Number: " + room.getRoomNumber() + ", Capacity: " + room.getCapacity() + ", Availability: " + status);
        }
    }

    // main method
    public static void main(String[] args) throws StudyRoomUnavailableException {
        StudyRoomReservationSystem Res_system = new StudyRoomReservationSystem();
    
        // Create study rooms
        StudyRoom room1 = new StudyRoom(1, 4);
        StudyRoom room2 = new StudyRoom(2, 6);
        StudyRoom room3 = new StudyRoom(3, 8);
    
        // Add study rooms to the reservation system
        Res_system.addStudyRoom(room1);
        Res_system.addStudyRoom(room2);
        Res_system.addStudyRoom(room3);
    
        // Display initial status of all study rooms
        Res_system.displayStudyRoomStatus();

        // Thread 1
        Thread t1 = new Thread() {
            public void run() {
                try {
                    Res_system.reserveStudyRoom(1);
                } catch (StudyRoomUnavailableException e) {
                    e.printStackTrace();
                }
            }
        };
        
        // Thread 2
        Thread t2 = new Thread() {
            public void run() {
                try {
                    Res_system.cancelStudyRoom(1);
                } catch (StudyRoomUnavailableException e) {
                    e.printStackTrace();
                }
            }
        };

        // t1.start();
        // t2.start();
    }
}


