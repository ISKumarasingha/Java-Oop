public class StudyRoom {
    private int roomNumber;
    private int capacity;
    private Boolean availabilityStatus;

    public StudyRoom(int roomNumber, int capacity) {
        this.roomNumber = roomNumber;
        this.capacity = capacity;
        this.availabilityStatus = true;    
    }

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