package com.example.Project.Management.controller;

import com.example.Project.Management.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDate;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/create")
    public ResponseEntity<String> createUser(
            @RequestParam String user_name,
            @RequestParam String email,
            @RequestParam String password,
            @RequestParam("file") MultipartFile file,
            @RequestParam String bio,
            @RequestParam(value = "date", required = false) LocalDate date) throws IOException {
        return userService.createUser(user_name, email, password, file, bio, date);
    }

}
