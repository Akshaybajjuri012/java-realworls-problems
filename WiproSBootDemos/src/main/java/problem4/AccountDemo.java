package problem4;

public class AccountDemo {
    private String id;
    private String type;
    private String status;

    public AccountDemo(String id, String type, String status) {
        this.id = id;
        this.type = type;
        this.status = status;
    }

    // Getters
    public String getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public String getStatus() {
        return status;
    }
}
