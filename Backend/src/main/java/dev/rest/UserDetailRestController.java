package dev.rest;

import dev.domain.User;
import dev.domain.UserDetail;
import dev.repository.UserDetailRepository;
import dev.service.UserDetailService;
import dev.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;


@RestController
public class UserDetailRestController {

    private final UserDetailService userDetailService;

    @Autowired
    public UserDetailRestController(UserDetailService userDetailService) {
        this.userDetailService = userDetailService;
    }

    @GetMapping("/users-detail")
    public List<UserDetail> getUsers() throws SQLException {
        return userDetailService.getAllCustomerDetails();
    }

    @GetMapping("/users-detail/{id}")
    public UserDetail getUser(@PathVariable("id") int id) throws SQLException {
        return userDetailService.getCustomerDetailById(id);
    }

    @DeleteMapping("/users-detail/{id}")
    public String deleteUser(@PathVariable("id") int id) throws SQLException {
        userDetailService.deleteCustomerDetailById(id);
        return "Successful";
    }

    @PutMapping("/users-detail/{id}")
    public String updateUserById(@PathVariable("id") int id, @RequestBody UserDetail userDetail) throws SQLException {
        userDetailService.updateCustomerDetail(id, userDetail);
        return "Successful";
    }

    @PostMapping("/users-detail")
    public String createUser(@RequestBody UserDetail userDetail) throws SQLException {
        userDetailService.createCustomerDetail(userDetail);
        return "Successful";
    }
}