package springprograms;

public class Freshman {
    private String name;
    private DormRoom room;

    public Freshman() {
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRoom(DormRoom room) {
        this.room = room;
    }

    public void display() {
        System.out.println("Freshman Name: " + name);
        System.out.println("Dorm Room: " + room.getRoomNumber() + ", " + room.getBuildingName());
    }
}
