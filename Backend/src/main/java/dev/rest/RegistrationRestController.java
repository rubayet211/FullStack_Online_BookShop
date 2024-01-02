package dev.rest;

import dev.domain.RegistrationRequest;
import dev.domain.User;
import dev.domain.UserDetail;
import dev.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class RegistrationRestController {
    private final RegistrationService registrationService;

    @Autowired
    public RegistrationRestController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @PostMapping("/register")
    public String  registerUser(@RequestBody RegistrationRequest registrationRequest) {

        User user = registrationRequest.getUser();
        UserDetail userDetail = registrationRequest.getUserDetail();

        registrationService.registerUser(user, userDetail);

        return "User registered successfully";
    }
}