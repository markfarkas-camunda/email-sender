package io.camunda.email;

import jakarta.annotation.PostConstruct;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EmailSenderApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmailSenderApplication.class, args);
    }

    @PostConstruct
    public void sendEmail() {
        EmailSender emailSender = new EmailSender();
        emailSender.send("recipient@email.com", "Camunda Summit 2023", "Hello Camunda Summit!");
    }
}