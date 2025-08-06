package springprograms;

public class DormRoom {
    private int roomNumber;
    private String buildingName;

    public DormRoom(int roomNumber, String buildingName) {
        this.roomNumber = roomNumber;
        this.buildingName = buildingName;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public String getBuildingName() {
        return buildingName;
    }
}
