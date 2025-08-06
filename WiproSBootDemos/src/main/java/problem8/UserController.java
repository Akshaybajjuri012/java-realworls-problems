package problem8;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @PostMapping
    public String createUser(@RequestBody User user) {
        return "User created: " + user.getFirstName() + " " + user.getLastName() + ", Age: " + user.getAge();
    }
}
