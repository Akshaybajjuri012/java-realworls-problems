<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*, com.bookstore.model.Book" %>
<%
    com.bookstore.dao.BookDAO dao = new com.bookstore.dao.BookDAO();
    List<Book> books = dao.listAllBooks();
%>
<h2>Book List</h2>
<table border="1">
    <tr><th>ID</th><th>Title</th><th>Author</th><th>Price</th></tr>
    <%
        for (Book b : books) {
    %>
        <tr>
            <td><%= b.getId() %></td>
            <td><%= b.getTitle() %></td>
            <td><%= b.getAuthor() %></td>
            <td><%= b.getPrice() %></td>
        </tr>
    <%
        }
    %>
</table>
