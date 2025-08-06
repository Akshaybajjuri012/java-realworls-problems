package problem12;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class BookRowMapper implements RowMapper<Book> {
    public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
        Book book = new Book();
        book.setBookid(rs.getInt("bookid"));
        book.setBookname(rs.getString("bookname"));
        book.setAuthor(rs.getString("author"));
        book.setPrice(rs.getDouble("price"));
        return book;
    }
}
