package jdbcdemo;
import java.sql.*;
import java.util.*;
public class BookStoreSort {
	static final String DB_URL = "jdbc:mysql://localhost:3306/company";
    static final String USER = "root";
    static final String PASS = "Akshay@9100";

    // BookStore class
    static class BookStore {
        int bookId;
        String bookName;

        public BookStore(int bookId, String bookName) {
            this.bookId = bookId;
            this.bookName = bookName;
        }

        public int getBookId() {
            return bookId;
        }

        public String getBookName() {
            return bookName;
        }

        @Override
        public String toString() {
            return "BookStore [Book ID=" + bookId + ", Book Name=" + bookName + "]";
        }
    }
    static class BookNameComparator implements Comparator<BookStore> {
        public int compare(BookStore b1, BookStore b2) {
            return b1.getBookName().compareToIgnoreCase(b2.getBookName());
        }
    }

    static class BookIdComparator implements Comparator<BookStore> {
        public int compare(BookStore b1, BookStore b2) {
            return Integer.compare(b1.getBookId(), b2.getBookId());
        }
    }
    public static void insertBooks(List<BookStore> books) {
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS)) {
            String sql = "INSERT INTO bookstore (book_id, book_name) VALUES (?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            for (BookStore book : books) {
                ps.setInt(1, book.getBookId());
                ps.setString(2, book.getBookName());
                ps.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static List<BookStore> getBooks() {
        List<BookStore> list = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS)) {
            String query = "SELECT * FROM bookstore";
            ResultSet rs = conn.createStatement().executeQuery(query);

            while (rs.next()) {
                int id = rs.getInt("book_id");
                String name = rs.getString("book_name");
                list.add(new BookStore(id, name));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    public static void main(String[] args) {
        // Sample books
        List<BookStore> books = Arrays.asList(
                new BookStore(103, "Java Programming"),
                new BookStore(101, "Data Structures"),
                new BookStore(105, "Operating Systems"),
                new BookStore(102, "Database Systems")
        );
        insertBooks(books);

        // Retrieve and sort
        List<BookStore> fromDB = getBooks();

        // Sort by book name
        fromDB.sort(new BookNameComparator());
        System.out.println("\nBooks sorted by name:");
        fromDB.forEach(System.out::println);

        // Sort by book ID
        fromDB.sort(new BookIdComparator());
        System.out.println("\nBooks sorted by ID:");
        fromDB.forEach(System.out::println);
    }

}
/*
 * 
Books sorted by name:
BookStore [Book ID=101, Book Name=Data Structures]
BookStore [Book ID=102, Book Name=Database Systems]
BookStore [Book ID=103, Book Name=Java Programming]
BookStore [Book ID=105, Book Name=Operating Systems]

Books sorted by ID:
BookStore [Book ID=101, Book Name=Data Structures]
BookStore [Book ID=102, Book Name=Database Systems]
BookStore [Book ID=103, Book Name=Java Programming]
BookStore [Book ID=105, Book Name=Operating Systems]
*/
