package com.casestudy.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class Home {

    @RequestMapping("/welcome")
    public String welcome() {
        String text = "this is private page";
        text += " .This page is not allowed to unauthenticated users";
        return text;
    }

}
