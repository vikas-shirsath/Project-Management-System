package com.example.Project.Management.service;

import com.example.Project.Management.model.Users;
import com.example.Project.Management.repo.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDate;

@Service
public class UserService {

    @Autowired
    UserDao userDao;


    public ResponseEntity<String> createUser(String userName, String email, String password, MultipartFile file, String bio, LocalDate date) throws IOException {
        try {
            Users user = new Users();
            user.setUser_name(userName);
            user.setEmail(email);
            user.setPassword(password);
            user.setBio(bio);
            user.setUploadedDate(date != null ? date : LocalDate.now());
            if (file != null && !file.isEmpty()) {
                user.setProfileImage(file.getBytes());
            }

            userDao.save(user);

            return new ResponseEntity<>("User is created successfully.", HttpStatus.CREATED);

        } catch(Exception e) {
            return new ResponseEntity<>("Failed to create user: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
