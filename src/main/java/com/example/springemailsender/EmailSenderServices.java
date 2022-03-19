package com.example.springemailsender;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@Service
public class EmailSenderServices {

    @Autowired
    private JavaMailSenderImpl mailSender;


    public void sendSimpleEmail(String toEmail, String body, String subject) {


        SimpleMailMessage mailMessage = new SimpleMailMessage();


        mailMessage.setFrom("from_email@gmail.com");
        mailMessage.setTo(toEmail);
        mailMessage.setSubject(subject);
        mailMessage.setText(body);


        mailSender.send(mailMessage);

        System.out.println("Message send to .......");

    }

        public void sendEmailWithAttachment (String toEmail, String body,
                                         String subject, String attachment) throws MessagingException {


            MimeMessage mimeMessage=mailSender.createMimeMessage();

            MimeMessageHelper mimeMessageHelper=new MimeMessageHelper(mimeMessage,true);

            mimeMessageHelper.setFrom("emial_FROM@gmail.com");
            mimeMessageHelper.setTo(toEmail);
            mimeMessageHelper.setText(body);
            mimeMessage.setSubject(subject);


            FileSystemResource fileSystem=new FileSystemResource(new File(attachment));


            mimeMessageHelper.addAttachment(fileSystem.getFilename(), fileSystem);

            mailSender.send(mimeMessage);

            System.out.println("Message send with attachment");




    }
}
