package mymockito;

public class ClientAccount {
	 private String id;
	    private double balance;

	    public ClientAccount(String id, double balance) {
	        this.id = id;
	        this.balance = balance;
	    }

	    public String getId() {
	        return id;
	    }

	    public double getBalance() {
	        return balance;
	    }
	    public void debit(double amount) {
	        this.balance -= amount;
	    }

	    public void credit(double amount) {
	        this.balance += amount;
	    }

}
