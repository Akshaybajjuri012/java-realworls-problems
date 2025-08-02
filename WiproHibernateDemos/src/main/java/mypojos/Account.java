package mypojos;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name = "accounts")
public class Account {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String holderName;

    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Transaction> transactions = new ArrayList<>();
    public Long getId() { return id; }

    public String getHolderName() { return holderName; }
    public void setHolderName(String holderName) { this.holderName = holderName; }

    public List<Transaction> getTransactions() { return transactions; }
    public void addTransaction(Transaction t) {
        t.setAccount(this);
        transactions.add(t);
    }
    public void removeTransaction(Transaction t) {
        transactions.remove(t);
        t.setAccount(null);
    }
	

}
