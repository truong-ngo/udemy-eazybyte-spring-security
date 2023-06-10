package com.security.basic.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Resource {
    @GetMapping("/test")
    public String test() {
        return "Spring security easy byte";
    }
}
