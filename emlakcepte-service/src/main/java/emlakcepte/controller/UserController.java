package emlakcepte.controller;

import emlakcepte.model.User;
import emlakcepte.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getAll() {

        System.out.println("getAll - userService :: " + userService);
        return userService.getAllUser();
    }

    @PostMapping
    public ResponseEntity<User> create(@RequestBody User user) {
        userService.createUser(user);
        System.out.println("create - userService :: " + userService);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @GetMapping(value = "/{email}")
    public User getByEmail(@PathVariable String email) {
        System.out.println("getByEmail - userService :: " + userService);
        return userService.getByEmail(email);
    }


    @PutMapping("/{newPassword}")
    public void updatePassword(@RequestBody User user, @PathVariable String newPassword) {
        user.setPassword(newPassword);
        userService.createUser(user);
    }

    @GetMapping("/histories")
    public ResponseEntity<User> saveHistory(@PathVariable String history, @RequestBody User user) {
        userService.saveHistory(history, user);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }


}
