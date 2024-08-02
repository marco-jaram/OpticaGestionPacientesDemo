package com.mtec.optica.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PublicController {

    @GetMapping("/secure")
    public String secureEndpoint() {
        return "This is a secure endpoint!";
    }
}
