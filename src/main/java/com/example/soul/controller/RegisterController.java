package com.example.soul.controller;

import com.example.soul.dto.RegisterRequest;
import com.example.soul.entity.User;
import com.example.soul.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class RegisterController {

    private static final Logger log = LoggerFactory.getLogger(RegisterController.class);

    private final UserService userService;

    public RegisterController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public Map<String, Object> register(@RequestBody RegisterRequest request) {
        Map<String, Object> result = new HashMap<>();

        if (isBlank(request.getUsername()) || isBlank(request.getPassword())) {
            result.put("success", false);
            result.put("message", "Username and password are required");
            return result;
        }

        if (userService.existsByUsername(request.getUsername())) {
            result.put("success", false);
            result.put("message", "Username already exists");
            return result;
        }

        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(request.getPassword());
        user.setPhone(request.getPhone());
        user.setEmail(request.getEmail());
        user.setAddress(request.getAddress());
        user.setName(request.getUsername());

        userService.save(user);

        result.put("success", true);
        result.put("username", user.getUsername());
        result.put("message", "Register successful");
        log.info("Register success for username={}", user.getUsername());
        return result;
    }

    private boolean isBlank(String value) {
        return value == null || value.trim().isEmpty();
    }
}
