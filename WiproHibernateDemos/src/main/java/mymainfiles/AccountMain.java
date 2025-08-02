package mymainfiles;
import mydaofiles.AccountDAO;
import mypojos.Account;
import mypojos.Transaction;

import java.util.List;
import java.util.Scanner;
public class AccountMain {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AccountDAO dao = new AccountDAO();

        while (true) {
            System.out.println("\nHIBERNATE: One-to-Many (Account ↔ Transactions)");
            System.out.println("1. Add Account");
            System.out.println("2. Add Transaction to Account");
            System.out.println("3. View All Accounts with Transactions");
            System.out.println("4. Get Account by ID");
            System.out.println("0. Exit");
            System.out.print("Choose option: ");
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
            case 1:
                System.out.print("Enter account holder name: ");
                String name = sc.nextLine();
                Account acc = new Account();
                acc.setHolderName(name);
                dao.addAccount(acc);
                break;
            case 2:
                System.out.print("Enter Account ID: ");
                Long accId = sc.nextLong();
                sc.nextLine();
                System.out.print("Enter transaction description: ");
                String desc = sc.nextLine();
                System.out.print("Enter amount: ");
                double amount = sc.nextDouble();
                Transaction txn = new Transaction();
                txn.setDescription(desc);
                txn.setAmount(amount);
                dao.addTransactionToAccount(accId, txn);
                break;
            case 3:
                List<Account> accounts = dao.getAllAccounts();
                for (Account a : accounts) {
                    System.out.println("Account ID: " + a.getId() + ", Name: " + a.getHolderName());
                    List<Transaction> txns = a.getTransactions();
                    for (Transaction t : txns) {
                        System.out.println("    Transaction ID: " + t.getId() + ", Desc: " + t.getDescription() + ", Amount: " + t.getAmount());
                    }
                }
                break;
            case 4:
                System.out.print("Enter Account ID: ");
                Long id = sc.nextLong();
                Account found = dao.getAccountById(id);
                if (found != null) {
                    System.out.println("Account ID: " + found.getId() + ", Name: " + found.getHolderName());
                    List<Transaction> txns = found.getTransactions();
                    for (Transaction t : txns) {
                        System.out.println("    Transaction ID: " + t.getId() + ", Desc: " + t.getDescription() + ", Amount: " + t.getAmount());
                    }
                } else {
                    System.out.println("Account not found!");
                }
                break;
            case 0:
                sc.close();
                System.exit(0);
                break;

            default:
                System.out.println("Invalid option!");
        }
    }
}
	

}
