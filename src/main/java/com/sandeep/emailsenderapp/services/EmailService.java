package com.sandeep.emailsenderapp.services;

import java.io.File;
import java.io.InputStream;

public interface EmailService {

    // Send email to single person
    void sendEmail(String to, String subject, String message);

    // Send email to multiple persons
    void sendEmail(String[] to, String subject, String message);

    // Send email with HTML content
    void sendEmailWithHTML(String to, String subject, String htmlContent);

    // Send email with file
    void sendEmailWithFile(String to, String subject, String message, File file);

    // Send email with file input stream
    void sendEmailWithFileInputStream(String to, String subject, String message, InputStream inputStream);
}
