package springprograms;

public class Bank {
	private int bankId;
    private String bankName;

    public Bank(int bankId, String bankName) {
        this.bankId = bankId;
        this.bankName = bankName;
    }

    @Override
    public String toString() {
        return "Bank ID: " + bankId + ", Bank Name: " + bankName;
    }

}
