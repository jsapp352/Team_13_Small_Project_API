package com.cop4331.group13.contactmanager.dao;

import com.cop4331.group13.contactmanager.domain.User;
import org.springframework.data.repository.CrudRepository;

public interface UserDao extends CrudRepository<User, Long> {
    User findByUsername(String username);
}
