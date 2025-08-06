package problem12;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookDAO bookDAO;

    @GetMapping
    public List<Book> getAllBooks() {
        return bookDAO.findAll();
    }
}
