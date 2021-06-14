package com.example.meetingOfficePlanner.meetingOfficePlanner.controller;

import com.example.meetingOfficePlanner.meetingOfficePlanner.entity.Room;
import com.example.meetingOfficePlanner.meetingOfficePlanner.entity.User;
import com.example.meetingOfficePlanner.meetingOfficePlanner.model.PasswordSet;
import com.example.meetingOfficePlanner.meetingOfficePlanner.repository.UserRepository;
import com.example.meetingOfficePlanner.meetingOfficePlanner.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/")

public class SetPasswordController {
    @Autowired
    private UserRepository userRepository;
    @PostMapping(value = "/setPassword")

  public  String setPassword(@RequestBody PasswordSet passwordSet){
String email=passwordSet.getEmail();
String passwordset=passwordSet.getPassword();
User user= userRepository.findByEmail(email);

user.setPassword(passwordset);

        userRepository.save(user);
return ("set");
    }
}
