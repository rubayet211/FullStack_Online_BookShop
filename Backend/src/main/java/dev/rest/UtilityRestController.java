package dev.rest;

import dev.domain.User;
import dev.service.UserService;
import dev.service.UtilityService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class UtilityRestController {

    private UtilityService utilityService;

    public UtilityRestController(UtilityService utilityService) {
        this.utilityService = utilityService;
    }

    @GetMapping("/dashboard")
    public Map<String, Integer> count() {
        return utilityService.count();
    }


}