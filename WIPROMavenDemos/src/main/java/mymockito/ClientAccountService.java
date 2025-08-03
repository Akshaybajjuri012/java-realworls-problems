package mymockito;

public class ClientAccountService {
	 public interface ClientAccountRepository {
	        ClientAccount findById(String id);
	        void update(ClientAccount account);
	    }

	    public interface MessagingService {
	        void send(ClientAccount account, String message);
	    }

	    private ClientAccountRepository repository;
	    private MessagingService messagingService;

	    public ClientAccountService(ClientAccountRepository repository, MessagingService messagingService) {
	        this.repository = repository;
	        this.messagingService = messagingService;
	    }
	    public boolean transfer(String fromId, String toId, double amount) {
	        ClientAccount from = repository.findById(fromId);
	        ClientAccount to = repository.findById(toId);

	        if (from == null || to == null) return false;
	        if (from.getBalance() < amount) return false;

	        from.debit(amount);
	        to.credit(amount);

	        repository.update(from);
	        repository.update(to);

	        messagingService.send(from, "Transferred $" + amount + " to " + toId);
	        return true;
	    }

}
