package problem13.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import problem13.model.User;
import problem13.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(@PathVariable Long id) {
        return userService.getUserById(id)
                .<ResponseEntity<?>>map(user -> ResponseEntity.ok().body(user))  // force cast
                .orElse(ResponseEntity.status(404).body("{\"errorMessage\":\"User with id " + id + " not found\"}"));
    }


    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateUser(@PathVariable Long id, @RequestBody User user) {
        return userService.updateUser(id, user)
                .<ResponseEntity<?>>map(updatedUser -> ResponseEntity.ok(updatedUser))
                .orElse(ResponseEntity.status(404).body("{\"errorMessage\":\"User with id " + id + " not found\"}"));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}
