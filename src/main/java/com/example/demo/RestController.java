package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    @GetMapping("/api/users")
    public Object getUsers() {
        return UsersController.DB;
    }
}
