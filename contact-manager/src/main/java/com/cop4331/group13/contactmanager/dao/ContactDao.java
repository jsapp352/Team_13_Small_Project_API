package com.cop4331.group13.contactmanager.dao;

import com.cop4331.group13.contactmanager.domain.Contact;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ContactDao extends CrudRepository<Contact, Long> {

    List<Contact> findByUserId(Long userId);
}
