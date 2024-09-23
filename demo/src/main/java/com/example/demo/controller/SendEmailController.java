package com.example.demo.controller;

import com.example.demo.config.ScheduledEmailTask;
import com.example.demo.dto.MailDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/send")
public class SendEmailController {

    @Autowired
    private ScheduledEmailTask scheduledEmailTask;

    @GetMapping
    public ResponseEntity sendEmail(@RequestBody MailDto dto) {
        scheduledEmailTask.sendScheduledEmail(dto);
        return ResponseEntity.ok("email send successfully");
    }

}
