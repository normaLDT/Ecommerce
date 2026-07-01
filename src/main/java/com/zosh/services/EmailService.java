package com.zosh.services;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSendException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

public class EmailService {

    private JavaMailSender javaMailSender;

    public void sendVerificationOtpEmail(String usermail,String otp, String subject, String text) throws MessagingException {

        try{
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(
                    mimeMessage, "utf-8");
            mimeMessageHelper.setSubject(subject);
            mimeMessageHelper.setText(text);
            mimeMessageHelper.setTo(usermail);
            javaMailSender.send(mimeMessage);

        }catch (MailException e){
            throw new MailSendException("fallo al enviar correo");

        }
    }
}
