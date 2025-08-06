package problem9;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;

@RestController
public class BookController {

    @GetMapping("/bookXYZ")
    public List<Book> getBooks() {
        List<Book> list = new ArrayList<>();

        Book b1 = new Book();
        b1.setBookId(101);
        b1.setName("Java Tutorials");
        b1.setWriter("Krishna");

        Book b2 = new Book();
        b2.setBookId(102);
        b2.setName("Spring Tutorials");
        b2.setWriter("Mahesh");

        Book b3 = new Book();
        b3.setBookId(103);
        b3.setName("Angular Tutorials");
        b3.setWriter("Shiva");

        list.add(b1);
        list.add(b2);
        list.add(b3);

        return list;
    }
}
