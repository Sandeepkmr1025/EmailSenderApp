package com.sandeep.emailsenderapp.controllers;

import com.sandeep.emailsenderapp.dtos.CustomResponse;
import com.sandeep.emailsenderapp.dtos.EmailSenderDto;
import com.sandeep.emailsenderapp.services.EmailService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("api/v1/email")
public class EmailSenderController {

private final EmailService emailService;
public EmailSenderController(EmailService emailService) {
    this.emailService = emailService;
}

    @PostMapping("/send")
    public ResponseEntity<CustomResponse> sendEmail(@RequestBody EmailSenderDto emailSenderDto) {
        emailService.sendEmail(emailSenderDto.getTo(), emailSenderDto.getSubject(), emailSenderDto.getMessage());
        return ResponseEntity.ok(CustomResponse.builder().message("Email sent successfully!!").status(HttpStatus.OK).success(true).build());
    }

    @PostMapping("/send-with-html")
    public ResponseEntity<CustomResponse> sendEmailWithHTML(@RequestBody EmailSenderDto emailSenderDto) {
        emailService.sendEmailWithHTML(emailSenderDto.getTo(), emailSenderDto.getSubject(), emailSenderDto.getMessage());
        return ResponseEntity.ok(CustomResponse.builder().message("Email sent successfully!!").status(HttpStatus.OK).success(true).build());
    }

    @PostMapping("/send-with-file")
    public ResponseEntity<CustomResponse> sendEmailWithFile(@RequestBody EmailSenderDto request, @RequestPart MultipartFile file) {
        try {
            emailService.sendEmailWithFile(request.getTo(), request.getSubject(), request.getMessage(), file.getResource().getFile());
            return ResponseEntity.ok(CustomResponse.builder().message("Email sent successfully!!").status(HttpStatus.OK).success(true).build());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }




}
