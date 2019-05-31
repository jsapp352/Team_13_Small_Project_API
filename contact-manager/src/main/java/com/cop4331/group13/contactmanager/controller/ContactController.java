package com.cop4331.group13.contactmanager.controller;

import com.cop4331.group13.contactmanager.domain.Contact;
import com.cop4331.group13.contactmanager.service.ContactService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class ContactController {

    @Autowired
    private ContactService service;

    @RequestMapping(value = "/contact/", method = RequestMethod.POST)
    public Contact createContact(@RequestBody Contact contact) { return service.createContact(contact); }

    @RequestMapping(value = "/contact/{contactId}", method = RequestMethod.GET)
    public Contact getContactByContactId(@PathVariable long contactId) { return service.getContactByContactId(contactId); }

    @RequestMapping(value = "/contact/userId/{userId}", method = RequestMethod.GET)
    public List<Contact> getContactsByUserId(@PathVariable long userId) { return service.getContactsByUserId(userId); }

    @RequestMapping(value = "/contact/", method = RequestMethod.PUT)
    public Contact updateContact(@RequestBody Contact contact) { return service.updateContact(contact); }

    @RequestMapping(value = "/contact/{contactId}", method = RequestMethod.DELETE)
    public void deleteContact(@PathVariable long contactId) { service.deleteContact(contactId); }
}
