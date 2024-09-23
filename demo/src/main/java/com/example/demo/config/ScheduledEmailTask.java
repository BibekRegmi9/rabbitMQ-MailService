package com.example.demo.config;

import com.example.demo.dto.MailDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledEmailTask {
    @Autowired
    private EmailMessageProducer emailMessageProducer;


    @Scheduled(fixedRate = 120000) // 120000 ms = 2 minutes
    public void sendScheduledEmail(MailDto dto) {
        emailMessageProducer.sendEmailMessage(dto.getTo(), dto.getSubject(), dto.getBody());
    }
}
