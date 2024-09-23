package com.example.demo.config;

import com.example.demo.dto.EmailDetails;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
public class EmailMessageProducer {

    private final RabbitTemplate rabbitTemplate;

    public EmailMessageProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendEmailMessage(String to, String subject, String body) {
        EmailDetails emailDetails = new EmailDetails(to, subject, body);
        rabbitTemplate.convertAndSend("email_exchange",
                "email_routing_key", emailDetails);
        System.out.println("Message sent to RabbitMQ: " + emailDetails);
    }
}

