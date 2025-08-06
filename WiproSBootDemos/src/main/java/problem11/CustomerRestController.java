package problem11;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/springrest")
public class CustomerRestController {

    @GetMapping("/customers")
    public List<CustomerRest> getCustomers() {
        return Arrays.asList(
            new CustomerRest(101, "John", "Doe", "djohn@gmail.com", "121-232-3435", new Date(1467240235069L)),
            new CustomerRest(201, "Russ", "Smith", "sruss@gmail.com", "343-545-2345", new Date(1467240235069L)),
            new CustomerRest(301, "Kate", "Williams", "kwilliams@gmail.com", "876-237-2987", new Date(1467240235069L))
        );
    }
}
