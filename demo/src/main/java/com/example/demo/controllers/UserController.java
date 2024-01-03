package com.example.demo.controllers;

import com.example.demo.Models.UserModel;
import com.example.demo.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<UserModel>> getAllUsers() {
        List<UserModel> usersList = userService.findAllUsers();
        return ResponseEntity.ok(usersList);

    }

    @GetMapping("/{id}")
    public ResponseEntity<UserModel> getUserById(@PathVariable Long id) {
        if (id == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid id");
        }
        UserModel user = userService.findUserById(id);
        return ResponseEntity.ok(user);

    }

    @PostMapping("/create/")
    public ResponseEntity<UserModel> createUser(@RequestBody UserModel newUser) {
        if (newUser.getEmail() == null || newUser.getName() == null || newUser.getPassword() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "invalid fields");
        }
        userService.createUserService(newUser);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}/")
    public ResponseEntity<UserModel> editUserById(@RequestBody UserModel userEdit, @PathVariable Long id) {
        if (id == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "invalid id");
        }
        if (userEdit.getPassword() == null || userEdit.getEmail() == null || userEdit.getName() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Not valid fields");

        }
        userService.editAllUserService(userEdit, id);
        return ResponseEntity.ok(userEdit);
    }

    @DeleteMapping("/{id}/")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        if (id == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "invalid id");
        }
        userService.deleteUserById(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("user Deleted");
    }
}
