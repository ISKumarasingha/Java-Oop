import java.util.ArrayList;

public class StudyRoomReservationSystem extends Thread {
    private ArrayList<StudyRoom> studyRooms;

    public StudyRoomReservationSystem() {
        this.studyRooms = new ArrayList<>();
    }

    public void addStudyRoom(StudyRoom studyRoom) {
        studyRooms.add(studyRoom);
    }

    public void run(){

    }
    private StudyRoom isStudyRoomAvailable(int roomNumber) {
        for (StudyRoom room : studyRooms) {
            if (room.getRoomNumber() == roomNumber) {
                return room;
            }
        }
        return null;
    }

    
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
    

    public void displayAvailableRooms(){
        System.out.println("***Available study rooms***");
        for (StudyRoom room : studyRooms) {
            boolean status = room.isAvailable();
            if (status)
                System.out.println("Room " + room.getRoomNumber() + " is Available" );
        }
    }

    public void displayStudyRoomStatus() {
        System.out.println("***Initial Study Room Status***");
        for (StudyRoom room : studyRooms) {
            String status = room.isAvailable() ? "Available" : "Occupied";
            System.out.println("Room Number: " + room.getRoomNumber() + ", Capacity: " + room.getCapacity() + ", Availability: " + status);
        }
    }


    public static void main(String[] args) throws StudyRoomUnavailableException {
        StudyRoomReservationSystem system = new StudyRoomReservationSystem();
    
        // Create study rooms
        StudyRoom room1 = new StudyRoom(1, 4);
        StudyRoom room2 = new StudyRoom(2, 6);
        StudyRoom room3 = new StudyRoom(3, 8);
        StudyRoom room4 = new StudyRoom(4, 10);
    
        // Add study rooms to the reservation system
        system.addStudyRoom(room1);
        system.addStudyRoom(room2);
        system.addStudyRoom(room3);
        system.addStudyRoom(room4);
    
        // Display initial status of all study rooms
        system.displayStudyRoomStatus();
        system.displayAvailableRooms();
        system.reserveStudyRoom(101);
        //system.reserveStudyRoom(10); Error
        system.displayStudyRoomStatus();
        system.cancelStudyRoom(101);
        //system.cancelStudyRoom(102); Error
        system.displayStudyRoomStatus();
        System.out.println();

        Thread t1 = new Thread() {
            public void run() {
                try {
                    system.reserveStudyRoom(1);
                } catch (StudyRoomUnavailableException e) {
                    e.printStackTrace();
                }
            }
        };
        
        Thread t2 = new Thread() {
            public void run() {
                try {
                    system.cancelStudyRoom(1);
                } catch (StudyRoomUnavailableException e) {
                    e.printStackTrace();
                }
            }
        };

        t1.start();
        t2.start();
    }
}
