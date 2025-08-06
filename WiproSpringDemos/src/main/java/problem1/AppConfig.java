package problem1;

public class AppConfig {
    private String url;
    private String username;
    private String password;

    public AppConfig(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public void printDetails() {
        System.out.println("URL: " + url);
        System.out.println("Username: " + username);
        System.out.println("Password: " + password);
    }
}
