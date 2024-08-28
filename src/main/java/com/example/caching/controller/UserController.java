package com.example.caching.controller;

import com.example.caching.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @GetMapping(path = "/{username}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getUserByUsername(@PathVariable String username) {
        return new ResponseEntity(userService.getUserByUserName(username), HttpStatus.OK);
    }

    @PutMapping(path = "/{username}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updateUserStatus(@PathVariable String username, @RequestParam("status") String status,
                                           @RequestParam("evict") boolean evict) {
        if (evict) {
            return new ResponseEntity(userService.updateUserStatusWithEvict(username, status), HttpStatus.OK);
        } else {
            return new ResponseEntity(userService.updateUserStatus(username, status), HttpStatus.OK);
        }
    }

    // "cached/{username}"
    // ""
}
