package com.cop4331.group13.contactmanager.service;

import com.cop4331.group13.contactmanager.dao.UserDao;
import com.cop4331.group13.contactmanager.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserDao dao;

    public User getUserByUserId(long userId) {
        return dao.findById(userId).orElse(null);
    }

    public User addUser(User user) {
        try {
            dao.save(user);
        } catch (DataIntegrityViolationException e) {
            return null;
        }

        return user;
    }

    public User getUserByUsername(String username) {
        return dao.findByUsername(username);
    }

    public User loginUser(String username, String password) {
        User user =  dao.findByUsername(username);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        } else {
            return null;
        }
    }

    public User updateUser(User user) {
        return dao.save(user);
    }

    public boolean deleteUser(long userId) {
        try {
            dao.deleteById(userId);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public User validateSecurityQuestion(String username, String securityAnswer) {
        User user = dao.findByUsername(username);
        if (user != null && user.getSecurityAnswer().equalsIgnoreCase(securityAnswer)) {
            return user;
        } else {
            return null;
        }
    }
}
