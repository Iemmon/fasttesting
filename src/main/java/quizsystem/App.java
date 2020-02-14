package quizsystem;

import quizsystem.service.MailSender;

import java.io.IOException;

public class App {
    public static void main(String[] args) throws IOException {
        MailSender mailSender = new MailSender();

        mailSender.sendMail("katerynab.ko@gmail.com", "Java", 90);
    }
}

