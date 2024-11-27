package com.example.demo.controller;

import com.example.demo.model.Contact;
import com.example.demo.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contacts")
public class ContactController {

    @Autowired
    private ContactRepository repository;

    @GetMapping
    public List<Contact> getAllContacts() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Contact getContactById(@PathVariable String id) {
        return repository.findById(id).orElse(null);
    }

    @PostMapping
    public Contact addContact(@RequestBody Contact contact) {
        return repository.save(contact);
    }

    @PutMapping("/{id}")
    public Contact updateContact(@PathVariable String id, @RequestBody Contact updatedContact) {
        Contact contact = repository.findById(id).orElse(null);
        if (contact != null) {
            contact.setName(updatedContact.getName());
            contact.setEmail(updatedContact.getEmail());
            contact.setPhone(updatedContact.getPhone());
            return repository.save(contact);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public String deleteContact(@PathVariable String id) {
        repository.deleteById(id);
        return "Contact deleted: " + id;
    }
}