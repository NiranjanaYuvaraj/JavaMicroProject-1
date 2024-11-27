package com.example.demo.controller;

import com.example.demo.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {

    @Autowired
    private ContactRepository repository;

    @GetMapping("/")
    public String viewContacts(Model model) {
        model.addAttribute("contacts", repository.findAll());
        return "index";
    }
}