package mydaofiles;
import mypojos.Book;
import mypojos.Author;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;

import java.util.List;
public class BookAuthorDAO {
	 private SessionFactory factory;

	    
	    	public BookAuthorDAO() {
	    	    try {
	    	        Configuration config = new Configuration().configure("wiprohibernate.cfg.xml");
	    	        factory = config.buildSessionFactory();  // ✅ no `SessionFactory` before `factory` here
	    	    } catch (Exception e) {
	    	        e.printStackTrace();  // Optional: helps debug Hibernate config issues
	    	    }
	    	}
	    public void addBook(Book book) {
	        Session session = factory.openSession();
	        Transaction tx = session.beginTransaction();
	        session.save(book);
	        tx.commit();
	        session.close();
	    }
	    public void addAuthor(Author author) {
	        Session session = factory.openSession();
	        Transaction tx = session.beginTransaction();
	        session.save(author);
	        tx.commit();
	        session.close();
	    }

	    public List<Book> getAllBooks() {
	        Session session = factory.openSession();
	        List<Book> books = session.createQuery("FROM Book", Book.class).list();
	        session.close();
	        return books;
	    }
	    public List<Author> getAllAuthors() {
	        Session session = factory.openSession();
	        List<Author> authors = session.createQuery("FROM Author", Author.class).list();
	        session.close();
	        return authors;
	    }

	    public void deleteBook(Long id) {
	        Session session = factory.openSession();
	        Transaction tx = session.beginTransaction();
	        Book book = session.get(Book.class, id);
	        if (book != null) {
	            session.delete(book);
	        }
	        tx.commit();
	        session.close();
	    }
	    public void deleteAuthor(Long id) {
	        Session session = factory.openSession();
	        Transaction tx = session.beginTransaction();
	        Author author = session.get(Author.class, id);
	        if (author != null) {
	            session.delete(author);
	        }
	        tx.commit();
	        session.close();
	    }

	    public void closeFactory() {
	        factory.close();
	    }

}
