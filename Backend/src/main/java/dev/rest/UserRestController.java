package dev.rest;

import dev.domain.User;
import dev.domain.UserDetail;
import dev.service.UserDetailService;
import dev.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
public class UserRestController {

    private final UserService userService;
    private final UserDetailService userDetailService;

    public UserRestController(UserService userService, UserDetailService userDetailService) {

        this.userService = userService;
        this.userDetailService = userDetailService;
    }

    @PostMapping("/users/create")
    public String createCustomer(@RequestBody User user) throws SQLException {
        userService.createCustomer(user);
        return "User created successfully";
    }

    @PutMapping("/users/{id}")
    public String updateCustomer(@PathVariable("id") int id, @RequestBody User user) throws SQLException {
        userService.updateCustomer(id, user);
        return "Update Successful";
    }

    @GetMapping("/users")
    public List<User> getAllCustomers() throws SQLException {
        return userService.getAllCustomers();
    }

    @GetMapping("/users/{id}")
    public User getCustomerById(@PathVariable int id) throws SQLException {
        return userService.getCustomerById(id);
    }

    @DeleteMapping("/users/{id}")
    public String deleteCustomer(@PathVariable int id) throws SQLException {
        userService.deleteCustomer(id);
        return "User deleted successfully";
    }

    @PostMapping("/signin")
    public String signIn(@RequestParam String email, @RequestParam String password) throws SQLException {
        boolean signInSuccessful = userService.signIn(email, password);

        if (signInSuccessful) {
            return "Sign in successful";
        } else {
            return "Invalid email or password";
        }
    }

    @PostMapping("/register")
    public String register(@RequestBody User user, @RequestBody UserDetail userDetail) throws SQLException {
        // Additional validation or business logic if needed
        userService.createCustomer(user);
        userDetailService.createCustomerDetail(userDetail);

        return "Registration Successful";
    }
}
