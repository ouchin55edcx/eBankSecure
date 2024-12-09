package com.ebanking.eBankSecure.controller;

import com.ebanking.eBankSecure.entity.User;
import com.ebanking.eBankSecure.entity.dto.UserDTO;
import com.ebanking.eBankSecure.entity.enums.Role;
import com.ebanking.eBankSecure.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody UserDTO userDto) {
        userService.registerNewUser(userDto);
        return ResponseEntity.status(HttpStatus.CREATED).body("User registered successfully");
    }

    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }


    @GetMapping("/{username}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<User> getUserByUsername(@PathVariable String username) {
        User user = userService.getUserByUsername(username);
        return ResponseEntity.ok(user);
    }

    @DeleteMapping("/{username}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> deleteUser(@PathVariable String username) {
        userService.deleteUser(username);
        return ResponseEntity.ok("User " + username + " has been deleted successfully");
    }

    @PutMapping("/{username}/updateRole")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<User> updateUserRole(
            @PathVariable String username,
            @RequestParam Role role
    ) {
        User updatedUser = userService.updateUserRole(username, role);
        return ResponseEntity.ok(updatedUser);
    }


    @PutMapping("/{username}/password")
    public ResponseEntity<String> changePassword(
            @PathVariable String username,
            @RequestParam String oldPassword,
            @RequestParam String newPassword
    ) {
        userService.changePassword(username, oldPassword, newPassword);
        return ResponseEntity.ok("Password changed successfully for user " + username);
    }
}