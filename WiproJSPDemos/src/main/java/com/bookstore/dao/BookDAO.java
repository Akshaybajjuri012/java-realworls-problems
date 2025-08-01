package com.bookstore.dao;

import java.sql.*;
import java.util.*;
import com.bookstore.model.Book;

public class BookDAO {
    private String jdbcURL = "jdbc:mysql://localhost:3306/bookdb";
    private String jdbcUsername = "root";
    private String jdbcPassword = "Akshay@9100";

    private static final String INSERT_BOOK_SQL = "INSERT INTO books (title, author, price) VALUES (?, ?, ?)";
    private static final String SELECT_ALL_BOOKS = "SELECT * FROM books";

    public Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

    public void insertBook(Book book) {
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(INSERT_BOOK_SQL)) {
            stmt.setString(1, book.getTitle());
            stmt.setString(2, book.getAuthor());
            stmt.setDouble(3, book.getPrice());
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Book> listAllBooks() {
        List<Book> books = new ArrayList<>();
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(SELECT_ALL_BOOKS);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                books.add(new Book(rs.getInt("id"),
                                   rs.getString("title"),
                                   rs.getString("author"),
                                   rs.getDouble("price")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return books;
    }
}
