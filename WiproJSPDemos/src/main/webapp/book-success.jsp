<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.bookstore.model.Book" %>
<%
    Book book = (Book) request.getAttribute("book");
%>
<h2>Book Saved Successfully!</h2>
<p>Title: <%= book.getTitle() %></p>
<p>Author: <%= book.getAuthor() %></p>
<p>Price: <%= book.getPrice() %></p>