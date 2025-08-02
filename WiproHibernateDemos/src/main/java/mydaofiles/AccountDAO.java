package mydaofiles;
import mypojos.Account;
import mypojos.Transaction;
import org.hibernate.Session;
import java.util.List;

public class AccountDAO {
	

	public void addAccount(Account account) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        org.hibernate.Transaction tx = session.beginTransaction(); // ✅ full class name
        session.save(account);
        tx.commit();
        session.close();
        System.out.println("Account added.");
    }
	public void addTransactionToAccount(Long accountId, Transaction transaction) {
	    Session session = HibernateSessionFactory.getSessionFactory().openSession();
	    org.hibernate.Transaction tx = session.beginTransaction();

	    Account account = session.get(Account.class, accountId);
	    if (account != null) {
	        transaction.setAccount(account);
	        account.getTransactions().add(transaction);
	        session.save(transaction);
	        session.update(account);
	        System.out.println("Transaction added to account.");
	    } else {
	        System.out.println("Account not found!");
	    }

	    tx.commit();
	    session.close();
	}

	    	 public List<Account> getAllAccounts() {
	    	        Session session = HibernateSessionFactory.getSessionFactory().openSession();
	    	        List<Account> accounts = session.createQuery("from Account", Account.class).list();
	    	        session.close();
	    	        return accounts;
	    	    }

	    	    public Account getAccountById(Long id) {
	    	        Session session = HibernateSessionFactory.getSessionFactory().openSession();
	    	        Account account = session.get(Account.class, id);
	    	        session.close();
	    	        return account;
	    	    }
	    	}
	        
	  
