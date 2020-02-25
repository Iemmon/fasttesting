package quizsystem.service;

public interface MailSender {
    void sendMail(String email, String test, Integer score);
}
