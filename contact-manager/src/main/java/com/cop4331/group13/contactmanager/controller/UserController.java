package com.cop4331.group13.contactmanager.controller;

import com.cop4331.group13.contactmanager.domain.User;
import com.cop4331.group13.contactmanager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class UserController {

    @Autowired
    private UserService service;

    @RequestMapping(value = "/user/login", method = RequestMethod.POST)
    public User loginUser(@RequestHeader(name = "username", required = true) String username,
                          @RequestHeader(name = "password", required = true) String password
    ) {
        return service.loginUser(username, password);
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public User addUser(@RequestBody User user) {
        return service.addUser(user);
    }

    @RequestMapping(value = "/user/{userId}", method = RequestMethod.GET)
    public User getUserByUserId(@PathVariable long userId) {
        return service.getUserByUserId(userId);
    }

    @RequestMapping(value = "/user/username/{username}", method = RequestMethod.GET)
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

    @RequestMapping(value = "/user/validateSecurityQuestion", method = RequestMethod.POST)
    public User validateSecurityQuestion(@RequestHeader(name = "username", required = true) String username,
                                         @RequestHeader(name = "securityanswer", required = true) String securityAnswer
    ) {
        return service.validateSecurityQuestion(username, securityAnswer);
    }

}
