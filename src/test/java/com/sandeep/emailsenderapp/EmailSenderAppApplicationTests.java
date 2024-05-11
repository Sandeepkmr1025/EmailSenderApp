package com.sandeep.emailsenderapp;

import com.sandeep.emailsenderapp.services.EmailService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

@SpringBootTest
class EmailSenderAppApplicationTests {

    @Autowired
    private EmailService emailService;

    @Test
    void contextLoads() {
    }

    @Test
    void sendEmailTest() {
        System.out.println("Sending email");
        emailService.sendEmail("email@gmail.com", "test subject", "test message");
    }

    @Test
    void sendEmailWithHTMLTest() {
        System.out.println("Sending email with HTML");
        String htmlContent = "<html><body><h1 style='color:red;border:1px solid black;'>test HTML content</h1></body></html>";
        emailService.sendEmailWithHTML("email@gmail.com", "test subject", htmlContent);
    }

    @Test
    void sendEmailWithFileTest() {
        System.out.println("Sending email with attachment");
        emailService.sendEmailWithFile("email@gmail.com", "test subject", "This email contains file", new File("C:\\Users\\sande\\Documents\\Projects\\EmailSenderApp\\src\\main\\resources\\static\\beautiful-picture-starry-sky-with-lake-river-tiled-vibrant-colors-ai-generated-art_882313-3192.avif"));
    }

    @Test
    void sendEmailWithFileStreamTest() {
        System.out.println("Sending email with stream attachment");
        File file = new File("C:\\Users\\sande\\Documents\\Projects\\EmailSenderApp\\src\\main\\resources\\static\\beautiful-picture-starry-sky-with-lake-river-tiled-vibrant-colors-ai-generated-art_882313-3192.avif");
        try {
            InputStream inputStream = new FileInputStream(file);
            emailService.sendEmailWithFileInputStream("email@gmail.com", "test subject", "This email contains file", inputStream);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }


    }



}
