package com.example.sqlandnosqlcrud.controller;

import com.example.sqlandnosqlcrud.entity.User;
import com.example.sqlandnosqlcrud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
public class UserRdbCrudController {

    @Autowired
    UserService userService;

    @PostMapping(value = "/rdb/user")
    public ResponseEntity<?> setUserInfo(User user) {
        userService.addUser(user);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @PutMapping(value = "/rdb/user")
    public ResponseEntity<?> modifyUserInfo(User user) {

        // check password

        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @GetMapping(value = "/rdb/user")
    public ResponseEntity<?> getUserInfo() {
        List<User> userList = new ArrayList<>();
        userList = userService.getUserInfo();

        return new ResponseEntity<>(userList, HttpStatus.OK);
    }

    @DeleteMapping(value = "/rdb/user/{id}")
    public ResponseEntity<?> deleteUserInfo(@PathVariable Long id) {
        userService.deleteUserInfo(id);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }


}
