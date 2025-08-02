package mymainfiles;
import mydaofiles.ItemDAO;
import mypojos.Item;

import java.util.List;
import java.util.Scanner;
public class MainApp {
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ItemDAO itemDAO = new ItemDAO();

        while (true) {
            System.out.println("\nHIBERNATE:");
            System.out.println(" 1. Add ------------------------------ Hibernate Item CRUD ------------------------------");
            System.out.println(" 2. View All");
            System.out.println(" 3. Update");
            System.out.println(" 4. Delete");
            System.out.println(" 5. Get by ID");
            System.out.println(" 0. Exit");
            System.out.print(" Choose option: ");
            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
                continue;
            }
            switch (choice) {
            case 1:
                System.out.print("Enter name: ");
                String name = scanner.nextLine();
                System.out.print("Enter price: ");
                double price = Double.parseDouble(scanner.nextLine());
                itemDAO.addItem(name, price);
                System.out.println("Item added");
                break;
            case 2:
                List<Item> items = itemDAO.getAllItems();
                if (items.isEmpty()) {
                    System.out.println("No items found.");
                } else {
                    for (Item i : items) {
                        System.out.println("ID: " + i.getId() + ", Name: " + i.getName() + ", Price: " + i.getPrice());
                    }
                }
                break;
            case 3:
                System.out.print("Enter ID to update: ");
                long updateId = Long.parseLong(scanner.nextLine());
                System.out.print("Enter new name: ");
                String newName = scanner.nextLine();
                System.out.print("Enter new price: ");
                double newPrice = Double.parseDouble(scanner.nextLine());
                itemDAO.updateItem(updateId, newName, newPrice);
                System.out.println("Item updated");
                break;
            case 4:
                System.out.print("Enter ID to delete: ");
                long deleteId = Long.parseLong(scanner.nextLine());
                itemDAO.deleteItem(deleteId);
                System.out.println("Item deleted");
                break;

            case 5:
                System.out.print("Enter ID to search: ");
                long searchId = Long.parseLong(scanner.nextLine());
                Item item = itemDAO.getItemById(searchId);
                if (item != null) {
                    System.out.println("ID: " + item.getId() + ", Name: " + item.getName() + ", Price: " + item.getPrice());
                } else {
                    System.out.println("Item not found");
                }
                break;
            case 0:
                System.out.println("Exiting...");
                scanner.close();
                System.exit(0);
                break;

            default:
                System.out.println("Invalid option. Try again.");
        }
    }
}

}
