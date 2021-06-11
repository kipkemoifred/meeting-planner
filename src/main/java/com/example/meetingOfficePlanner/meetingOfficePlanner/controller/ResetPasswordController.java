package com.example.meetingOfficePlanner.meetingOfficePlanner.controller;

import com.example.meetingOfficePlanner.meetingOfficePlanner.entity.Room;
import com.example.meetingOfficePlanner.meetingOfficePlanner.entity.User;
import com.example.meetingOfficePlanner.meetingOfficePlanner.repository.UserRepository;
import com.example.meetingOfficePlanner.meetingOfficePlanner.service.SendEmailService;
import com.example.meetingOfficePlanner.meetingOfficePlanner.service.UserService;
import net.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
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
            public void enterEmailToSendLink(HttpServletRequest request){

        String email=request.getParameter("email");
        UUID token = UUID.randomUUID();
        userService.updateResetPasswordToken(token, email);
        String resetPasswordLink="http://8080/api/resetPassword?token="+token;
            userService.updateResetPasswordToken(token,email);
		sendEmailService.sendEmail(email,"link is"+resetPasswordLink,"Reset password");
    }
    @PostMapping(value = "/resetPassword")
public String resetPasswordPage(HttpServletRequest request){
        String token = request.getParameter("token");
        String password = request.getParameter("password");
        User user = userService.getByResetPasswordToken(token);
        if (user == null) {
           return ("invalid token");
        } else {
            userService.updatePassword(user, password);

            return ("successfully changed pwd");
        }


    }


    }
