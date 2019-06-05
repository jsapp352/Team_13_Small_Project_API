package com.cop4331.group13.contactmanager.service;

import com.cop4331.group13.contactmanager.dao.ContactDao;
import com.cop4331.group13.contactmanager.domain.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ContactService {

    @Autowired
    private ContactDao dao;

    public Contact createContact(Contact contact) { return dao.save(contact); }

    public Contact getContactByContactId(long contactId) { return dao.findById(contactId).orElse(null); }

    public List<Contact> getContactsByUserId(long userId) { return dao.findByUserId(userId); }

    public List<Contact> getContactsBySearchCriteria(long userId, String searchCriteria) {
        String[] args = searchCriteria.split("\\P{L}+");
        if (args.length == 0) {
            return new ArrayList<>();
        }

        List<Contact> contacts = dao.findBySearchCriteria(userId, args[0]);
        for (int i = 1; i < args.length; i++) {
            contacts.retainAll(dao.findBySearchCriteria(userId, args[i]));
        }

        return contacts;
    }

    public Contact updateContact(Contact contact) { return dao.save(contact); }

    public void deleteContact(long contactId) { dao.deleteById(contactId); }
}
