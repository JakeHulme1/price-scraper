package com.jakehulme.service;

import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * Service class for sending email notifications.
 * 
 * This class handles sending email notifications to users when certain
 * conditions are met.
 */
@Service
public class NotificationService {

    /**
     * Sends an email notification to the specified user.
     *
     * @param userEmail   the recipient's email address
     * @param subject     the subject of the email
     * @param messageText the body of the email
     * @throws MessagingException if an error occurs while sending the email
     */
    public void sendEmail(String userEmail, String subject, String messageText) throws MessagingException {
        // Set up email properties
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.example.com");
        // Create a new email session
        Session session = Session.getInstance(props);
        // Create a new email message
        Message msg = new MimeMessage(session);
        msg.setFrom(new InternetAddress("noreply@example.com"));
        msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(userEmail));
        msg.setSubject(subject);
        msg.setText(messageText);
        // Send the email
        Transport.send(msg);
    }
}