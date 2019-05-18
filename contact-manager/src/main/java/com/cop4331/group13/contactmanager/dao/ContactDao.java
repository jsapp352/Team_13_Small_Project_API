package com.cop4331.group13.contactmanager.dao;

import com.cop4331.group13.contactmanager.domain.Contact;
import org.springframework.data.repository.CrudRepository;

public interface ContactDao extends CrudRepository<Contact, Long> {

}
