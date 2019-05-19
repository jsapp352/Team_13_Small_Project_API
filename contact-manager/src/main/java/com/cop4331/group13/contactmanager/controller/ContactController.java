package com.cop4331.group13.contactmanager.controller;

import com.cop4331.group13.contactmanager.domain.Contact;
import com.cop4331.group13.contactmanager.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ContactController {

    @Autowired
    private ContactService service;

    @RequestMapping("/contact/{contactId}")
    public Contact getContactByContactId(@PathVariable long contactId) { return service.getContactByContactId(contactId); }

    @RequestMapping(value = "/contact/", method = RequestMethod.POST)
    public Contact createContact(@RequestBody Contact contact) { return service.createContact(contact); }


}
