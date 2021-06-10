package com.example.meetingOfficePlanner.meetingOfficePlanner.controller;

import com.example.meetingOfficePlanner.meetingOfficePlanner.entity.Room;
import com.example.meetingOfficePlanner.meetingOfficePlanner.entity.User;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/")

public class SetPasswordController {
    @PutMapping(value = "/setPassword")
    //userid,pwd
    String setPassword(@RequestBody User user){
        //user.setPassword();
        //user updatedRoom=userRepository.save(room);
        return "password set";
    }
}
