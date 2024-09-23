package com.example.demo.config;

import com.example.demo.constant.RabbitMQConstant;
import com.example.demo.dto.EmailDetails;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmailMessageConsumer {
    @Autowired
    private EmailService emailService;

    @RabbitListener(queues = RabbitMQConstant.QUEUE_NAME)
    public void receiveMessage(EmailDetails emailDetails) {
        System.out.println("Received message from RabbitMQ: " + emailDetails);
        emailService.sendEmail(emailDetails.getTo(), emailDetails.getSubject(), emailDetails.getBody());
    }
}
