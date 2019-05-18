package com.cop4331.group13.contactmanager.controller;

import com.cop4331.group13.contactmanager.domain.User;
import com.cop4331.group13.contactmanager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    private UserService service;

    @RequestMapping("/user/{userId}")
    public User getUserByUserId(@PathVariable long userId) {
        return service.getUserByUserId(userId);
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public User addUser(@RequestBody User user) {
        return service.addUser(user);
    }
}
