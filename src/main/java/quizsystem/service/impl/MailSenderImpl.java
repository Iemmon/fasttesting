package quizsystem.service.impl;

import org.apache.log4j.Logger;
import quizsystem.service.MailSender;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class MailSenderImpl implements MailSender {

    protected static final Logger LOGGER = Logger.getLogger(MailSenderImpl.class);

    public void sendMail(String email, String test, Integer score) {

        try {

            final String username = "quizmail@yahoo.com";
            final String password = "sjkwmmyqzeosryqb";
            File file = new File("src/main/resources/mail.properties");
            FileInputStream fileInput = new FileInputStream(file);
            Properties properties = new Properties();
            properties.load(fileInput);

            Session session = Session.getInstance(properties,
                    new javax.mail.Authenticator() {
                        protected PasswordAuthentication getPasswordAuthentication() {
                            return new PasswordAuthentication(username, password);
                        }
                    });

                Message message = new MimeMessage(session);
                message.setFrom(new InternetAddress(username));
                message.setRecipients(
                        Message.RecipientType.TO,
                        InternetAddress.parse(email));

                message.setSubject("TEST RESULT");
                message.setText("You have " + score + " points for " + test + " test");

                Transport.send(message);

            LOGGER.info("Email was sent");

        } catch (MessagingException | IOException e) {
            LOGGER.error("Error sending email", e);
            throw new RuntimeException("Email was not sent");
        }
    }
}
