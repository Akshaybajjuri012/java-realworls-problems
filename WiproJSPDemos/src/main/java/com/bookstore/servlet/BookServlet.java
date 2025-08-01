package com.bookstore.servlet;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import com.bookstore.model.Book;
import com.bookstore.dao.BookDAO;


@WebServlet("/BookServlet")
public class BookServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public BookServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");

        if (action == null) {
            action = "list"; // default
        }

        switch (action) {
            case "new":
                // Show form to add new book
                request.getRequestDispatcher("book-form.jsp").forward(request, response);
                break;
            case "edit":
                // Show form with pre-filled data
                // You will fetch book by ID using DAO and set as request attribute
                request.getRequestDispatcher("book-form.jsp").forward(request, response);
                break;
            case "delete":
                // Call DAO to delete by ID
                response.sendRedirect("BookServlet?action=list");
                break;
            case "list":
            default:
                // Show all books
                request.getRequestDispatcher("book-list.jsp").forward(request, response);
                break;
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Read form data
    	String title = request.getParameter("title");
        String author = request.getParameter("author");
        double price = Double.parseDouble(request.getParameter("price"));

        // Create a Book object
        Book book = new Book();
        book.setTitle(title);
        book.setAuthor(author);
        book.setPrice(price);

        // (Optional) Save book to database using BookDAO
        BookDAO dao = new BookDAO();
        dao.insertBook(book); // You must create this method in BookDAO

        // Send book to JSP page for confirmation
        request.setAttribute("book", book);
        request.getRequestDispatcher("book-success.jsp").forward(request, response);

        // Create Book object (you will later use DAO to save it)
        // Book book = new Book(title, author, price);
        // bookDAO.save(book);

        
    }
}
