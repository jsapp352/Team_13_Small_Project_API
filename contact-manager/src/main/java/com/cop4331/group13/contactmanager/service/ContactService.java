package com.cop4331.group13.contactmanager.service;

import com.cop4331.group13.contactmanager.dao.ContactDao;
import com.cop4331.group13.contactmanager.domain.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactService {

    @Autowired
    private ContactDao dao;

    public Contact createContact(Contact contact) { return dao.save(contact); }
}
