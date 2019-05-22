package com.cop4331.group13.contactmanager.controller;

import com.cop4331.group13.contactmanager.domain.User;
import com.cop4331.group13.contactmanager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    private UserService service;

    @RequestMapping("/user/login")
    public User loginUser(@RequestHeader(name = "username", required = true) String username,
                          @RequestHeader(name = "password", required = true) String password
    ) {
        return service.loginUser(username, password);
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public User addUser(@RequestBody User user) {
        return service.addUser(user);
    }

    @RequestMapping("/user/{userId}")
    public User getUserByUserId(@PathVariable long userId) {
        return service.getUserByUserId(userId);
    }

    @RequestMapping("/user/username/{username}")
    public User getUserByUsername(@PathVariable String username) {
        return service.getUserByUsername(username);
    }

    @RequestMapping(value = "/user", method = RequestMethod.PUT)
    public User updateUser(@RequestBody User user) {
        return service.updateUser(user);
    }

    @RequestMapping(value = "/user/{userId}", method = RequestMethod.DELETE)
    public boolean deleteUser(@PathVariable long userId) {
        return service.deleteUser(userId);
    }

    @RequestMapping("/user/validateSecurityQuestion")
    public User validateSecurityQuestion(@RequestHeader(name = "username", required = true) String username,
                                         @RequestHeader(name = "securityanswer", required = true) String securityAnswer
    ) {
        return service.validateSecurityQuestion(username, securityAnswer);
    }

}
