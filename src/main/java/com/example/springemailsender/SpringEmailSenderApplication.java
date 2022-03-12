package com.example.springemailsender;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import javax.mail.MessagingException;

@SpringBootApplication
public class SpringEmailSenderApplication {



    @Autowired
    private EmailSenderServices senderServices;

    public static void main(String[] args) {
        SpringApplication.run(SpringEmailSenderApplication.class, args);
    }


    @EventListener(ApplicationReadyEvent.class)
    public void triggerMail() {



        senderServices.sendSimpleEmail("email_TO@gmail.com",
                "this is BODY ",
                "this is Subject");



    }


    @EventListener(ApplicationReadyEvent.class)
    public void triggerMailWithAttachment() throws MessagingException {





        senderServices.sendEmailWithAttachment("julian.l.bashev@gmail.com",
                "this is just body","this   email has attachment",
                "C:\\Users\\Zhuliyan\\Desktop\\einweggeschirr.jpg");

    }
}
