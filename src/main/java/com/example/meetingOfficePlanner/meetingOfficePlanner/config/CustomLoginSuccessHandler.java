//package com.example.meetingOfficePlanner.meetingOfficePlanner.config;
//import java.io.IOException;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import com.example.meetingOfficePlanner.meetingOfficePlanner.entity.User;
//import com.example.meetingOfficePlanner.meetingOfficePlanner.service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
//import org.springframework.stereotype.Component;
//
//@Component
//public class CustomLoginSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {
//
//    @Autowired
//    private UserService userService;
//
//    @Override
//    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
//                                        Authentication authentication) throws IOException, ServletException {
//        MyUserDetails userDetails =  (MyUserDetails) authentication.getPrincipal();
//        User user = userDetails.getUser();
//        if (user.getNumFailedLogins() > 0) {
//            userService.resetFailedAttempts(user.getUserName());
//        }
//
//        super.onAuthenticationSuccess(request, response, authentication);
//    }
//
//}
