package problem4;

public class AccountProp {
    private String number;
    private String holder;
    private double balance;
    private String type;

    public void setNumber(String number) { this.number = number; }
    public void setHolder(String holder) { this.holder = holder; }
    public void setBalance(double balance) { this.balance = balance; }
    public void setType(String type) { this.type = type; }

    public void display() {
        System.out.println("Account Number: " + number);
        System.out.println("Account Holder: " + holder);
        System.out.println("Balance: " + balance);
        System.out.println("Account Type: " + type);
    }
}
