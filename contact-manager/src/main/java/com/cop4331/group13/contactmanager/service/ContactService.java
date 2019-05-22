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

    public List<Contact> getContactsBySearchCriteria(long userId, String searchCritera) {
        ArrayList<Contact> contacts = new ArrayList<>();
        String[] args = searchCritera.split("\\P{L}+");

        for (String arg : args) {
            System.out.println("Searching for " + arg);
            List<Contact> innerContacts = dao.findBySearchCriteria(userId, arg);
            for (Contact c : innerContacts) {
                System.out.println("Found one");
            }
            contacts.addAll(innerContacts);
        }

        return contacts;
    }

    public Contact updateContact(Contact contact) { return dao.save(contact); }

    public void deleteContact(long contactId) { dao.deleteById(contactId); }
}
