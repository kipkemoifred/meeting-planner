package com.example.meetingOfficePlanner.meetingOfficePlanner.config;

import com.example.meetingOfficePlanner.meetingOfficePlanner.entity.User;
import com.example.meetingOfficePlanner.meetingOfficePlanner.model.AuthenticationRequest;
import com.example.meetingOfficePlanner.meetingOfficePlanner.model.AuthenticationResponse;
import com.example.meetingOfficePlanner.meetingOfficePlanner.repository.UserRepository;
import com.example.meetingOfficePlanner.meetingOfficePlanner.service.UserService;
import com.example.meetingOfficePlanner.meetingOfficePlanner.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class HomeResource {
    private static final int MAX_FAILED_ATTEMPTS =4 ;
    @Autowired
    private
    AuthenticationManager authenticationManager;

    @Autowired
    UserService userService;
    @Autowired
    UserRepository userRepository;

    @Autowired
    private JwtUtil jwtTokenUtil;

    @Autowired
    private MyUserDetailsService userDetailsService;

    @RequestMapping({"/hello"})
    public String firstPage() {
        return "Hello World";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)//homepage
    @Transactional
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {

        try {

            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword())
            );
            userRepository.onLoginSuccess(authenticationRequest.getUsername());
            //List<String> prevPasswords=new ArrayList();

        } catch (BadCredentialsException e) {
            //fail, increment count

            userRepository.onFailedAttempts(authenticationRequest.getUsername());

            User user=userRepository.findByUserName(authenticationRequest.getUsername()).orElseThrow();
            int failedTimes=user.getNumFailedLogins();
            System.out.println(user.getUserName()+"sfadasdfsdf");
            if (user != null) {
                if (user.isActive() && user.isAccountNonLocked()) {
             if(failedTimes==MAX_FAILED_ATTEMPTS-1){
                userService.lock(user);

            }}//if fail>4,lock,unlock after 30 mins
            else if (!user.isActive()) {
                userService.unlockWhenTimeExpired(user);}}//NOT WORKING
//30mins
            e.printStackTrace();
            throw new Exception("Incorrect username or password", e);
        }


        final UserDetails userDetails = userDetailsService
                .loadUserByUsername(authenticationRequest.getUsername());

        final String jwt = jwtTokenUtil.generateToken(userDetails);

        return ResponseEntity.ok(new AuthenticationResponse(jwt));
    }


}
