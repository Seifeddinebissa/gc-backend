package com.gc.rest.controller;

import com.gc.entity.EmailContent;
import com.gc.entity.EmailDetails;
import com.gc.service.EmailService;
import org.apache.catalina.loader.ResourceEntry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
public class EmailController {

    @Autowired
    EmailService emailService;

    @PostMapping("/envoyerMail")
    public Boolean emailSend(@RequestBody EmailContent content){
        EmailDetails details = new EmailDetails();
        details.setRecipient(content.getTo());
        details.setSubject("compte");
        details.setMsgBody("Votre pseudo: "+content.getPseudo()+" \nVotre mot de passe: "+content.getMdp());
        return emailService.sendSimpleMail(details);
    }

}
