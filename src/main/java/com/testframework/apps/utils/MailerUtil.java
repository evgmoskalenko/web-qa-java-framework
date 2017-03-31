package com.testframework.apps.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class MailerUtil {

    private static final Logger logger = LogManager.getLogger(MailerUtil.class);

    private String email;
    private String sendMailFrom;
    private String sendMailerPort;
    private String sendMailerHost;
    private String sendMailerLogin;
    private String sendMailerPassword;

    public MailerUtil() {
    }

    public MailerUtil(String email) {
        this.email = email;
        this.sendMailFrom = "test@mailinator.com";
        this.sendMailerPort = "25";
        this.sendMailerHost = "mail.gmail.com";
        this.sendMailerLogin = "test@mailinator.com";
        this.sendMailerPassword = "master";
    }

    public void generateAndSendEmail(String subject, String emailBody) throws MessagingException {

        // setup Mail Server Properties..
        Properties mailServerProperties = System.getProperties();

        mailServerProperties.put("mail.smtp.port", this.sendMailerPort);
        mailServerProperties.put("mail.smtp.auth", "true");
        mailServerProperties.put("mail.smtp.starttls.enable", "false");
        logger.info("Mail Server Properties have been setup successfully..");

        // get Mail Session..
        Session getMailSession = Session.getDefaultInstance(mailServerProperties, null);
        MimeMessage generateMailMessage = new MimeMessage(getMailSession);

        generateMailMessage.setFrom(new InternetAddress(this.sendMailFrom));
        generateMailMessage.addRecipient(
                Message.RecipientType.TO, new InternetAddress(this.email));

        generateMailMessage.setSubject(subject);
        generateMailMessage.setContent(emailBody, "text/html; charset=UTF-8");
        logger.info("Mail Session has been created successfully..");

        // Get Session and Send mail
        Transport transport = getMailSession.getTransport("smtp");

        transport.connect(this.sendMailerHost, this.sendMailerLogin, this.sendMailerPassword);
        transport.sendMessage(generateMailMessage, generateMailMessage.getAllRecipients());
        transport.close();
        logger.info("Mail send successfully..");
    }
}

