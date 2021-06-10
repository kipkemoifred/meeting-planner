package com.example.meetingOfficePlanner.meetingOfficePlanner.controller;

import com.example.meetingOfficePlanner.meetingOfficePlanner.service.UserService;
import net.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.UUID;



//@PostMapping("/postReset")
public class ResetPasswordController {

    @Autowired
    private UserService userService;
    // creating UUID
    //working on feature x blah blah
    String email;
    String token = RandomString.make(45);
    //am doin stuff

    String password;
    String resetPasswordLink="http://8080/api/resetPassword?token="+token;

    public void forgotPdForm(){
        userService.updateResetPasswordToken(token,email);
    }

    //private String email;//get email
    //@GetMapping("/postReset")
    }
