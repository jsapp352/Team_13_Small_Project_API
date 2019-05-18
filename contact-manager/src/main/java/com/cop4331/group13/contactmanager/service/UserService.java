package com.cop4331.group13.contactmanager.service;

import com.cop4331.group13.contactmanager.dao.UserDao;
import com.cop4331.group13.contactmanager.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserDao dao;

    public User getUserByUserId(long userId) {
        return dao.findById(userId).orElse(null);
    }

    public User addUser(User user) {
        return dao.save(user);
    }
}
