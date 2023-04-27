package io.camunda.email;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import java.util.Properties;

public class EmailSender {

    public void send(String to, String subject, String text) {
        // create email message
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom("{{REPLACE_THIS_WITH_YOUR_EMAIL}}");
        simpleMailMessage.setTo(to);
        simpleMailMessage.setSubject(subject);
        simpleMailMessage.setText(text);

        // create email sender with config
        JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
        javaMailSender.setHost("smtp.gmail.com");
        javaMailSender.setPort(587);
        javaMailSender.setUsername("{{REPLACE_THIS_WITH_YOUR_EMAIL}}");
        javaMailSender.setPassword("{{REPLACE_THIS_WITH_YOUR_APP_PASSWORD}}");

        // add properties
        Properties properties = javaMailSender.getJavaMailProperties();
        properties.put("mail.transport.protocol", "smtp");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.debug", "true");

        // send email
        javaMailSender.send(simpleMailMessage);
    }
}
