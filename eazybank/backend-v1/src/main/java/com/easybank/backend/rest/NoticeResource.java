package com.easybank.backend.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class NoticeResource {
    @GetMapping("/notices")
    public String getNotices() {
        return "Here is my notices";
    }
}
