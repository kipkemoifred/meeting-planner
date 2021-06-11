package com.example.meetingOfficePlanner.meetingOfficePlanner.controller;

import com.example.meetingOfficePlanner.meetingOfficePlanner.model.Email;
import com.example.meetingOfficePlanner.meetingOfficePlanner.entity.User;
import com.example.meetingOfficePlanner.meetingOfficePlanner.model.Password;
import com.example.meetingOfficePlanner.meetingOfficePlanner.repository.UserRepository;
import com.example.meetingOfficePlanner.meetingOfficePlanner.service.SendEmailService;
import com.example.meetingOfficePlanner.meetingOfficePlanner.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;


@RestController
@RequestMapping(value = "/api/")

public class ResetPasswordController {

    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private SendEmailService sendEmailService;

    @PostMapping(value = "/enterEmailToSendLink")
            public void enterEmailToSendLink(@RequestBody Email email){
        UUID token = UUID.randomUUID();

        String emailName=email.getEmail();
        userService.updateResetPasswordToken(token,emailName);
        String resetPasswordLink="http://localhost:8080/api/resetPassword";
            userService.updateResetPasswordToken(token,email.getEmail());
		sendEmailService.sendEmail(email.getEmail(), "the token is "+token+
                " and link is "+resetPasswordLink,"Reset password");
    }
    @PostMapping(value = "/resetPassword")
public String resetPasswordPage(@RequestBody Password password){
        String token=password.getToken();
        String passwordStr = password.getPasswordName();
        User user = userService.getByResetPasswordToken(token);
        if (user == null) {
           return ("invalid token");
        } else {
            userService.updatePassword(user, passwordStr);

            return ("successfully changed pwd");
        }


    }


    }
