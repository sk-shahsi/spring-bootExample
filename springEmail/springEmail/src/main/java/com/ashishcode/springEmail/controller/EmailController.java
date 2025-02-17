package com.ashishcode.springEmail.controller;

import com.ashishcode.springEmail.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailController {
    @Autowired
    private EmailService emailService;

    @GetMapping("/send")
    public  String sendEmail(@RequestParam String to,@RequestParam String subject,@RequestParam String text){

        emailService.sendmail(to,subject,text);

        return "Email send successfully";
    }
}
