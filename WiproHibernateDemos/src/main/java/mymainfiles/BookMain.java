package mymainfiles;
import mypojos.Book;
import mypojos.Author;
import mydaofiles.BookAuthorDAO;

import java.util.*;
public class BookMain {
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BookAuthorDAO dao = new BookAuthorDAO();
        while (true) {
            System.out.println("\n1. Add Book\n2. Add Author\n3. View Books\n4. View Authors\n5. Delete Book\n6. Delete Author\n7. Exit");
            System.out.print("Choose option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
            case 1:
                Book book = new Book();
                System.out.print("Enter book title: ");
                book.setTitle(scanner.nextLine());

                System.out.print("How many authors? ");
                int count = scanner.nextInt();
                scanner.nextLine();

                Set<Author> authors = new HashSet<>();
                for (int i = 0; i < count; i++) {
                    System.out.print("Enter author name: ");
                    Author author = new Author();
                    author.setName(scanner.nextLine());
                    authors.add(author);
                }
                book.setAuthors(authors);
                dao.addBook(book);
                break;

            case 2:
                Author author = new Author();
                System.out.print("Enter author name: ");
                author.setName(scanner.nextLine());
                dao.addAuthor(author);
                break;
            case 3:
                dao.getAllBooks().forEach(System.out::println);
                break;

            case 4:
                dao.getAllAuthors().forEach(System.out::println);
                break;

            case 5:
                System.out.print("Enter book ID to delete: ");
                dao.deleteBook(scanner.nextLong());
                scanner.nextLine();
                break;
            case 6:
                System.out.print("Enter author ID to delete: ");
                dao.deleteAuthor(scanner.nextLong());
                scanner.nextLine();
                break;

            case 7:
                dao.closeFactory();
                System.out.println("Exiting...");
                return;
        }
    }
}


}
