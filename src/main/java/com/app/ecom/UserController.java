package com.app.ecom;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;      // it's constructor is created automatically by @RequiredArgsConstructor...

    @GetMapping("/api/users")
    public List<User> getAllUsers() {
        return userService.fetchAllUsers();
    }

    @PostMapping("/api/users")
    public String createUser(@RequestBody User user) {
        userService.addUser(user);
        return "User created successfully";
    }
}
