package com.cop4331.group13.contactmanager.controller;

import com.cop4331.group13.contactmanager.domain.Contact;
import com.cop4331.group13.contactmanager.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContactController {

    @Autowired
    private ContactService service;

    @RequestMapping(value = "/contact/", method = RequestMethod.POST)
    public Contact createContact(@RequestBody Contact contact) { return service.createContact(contact); }


}
