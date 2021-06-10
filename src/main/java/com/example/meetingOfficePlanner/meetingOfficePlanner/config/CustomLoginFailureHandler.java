package com.example.meetingOfficePlanner.meetingOfficePlanner.config;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.meetingOfficePlanner.meetingOfficePlanner.entity.User;
import com.example.meetingOfficePlanner.meetingOfficePlanner.exception.UserNameNotFoundException;
import com.example.meetingOfficePlanner.meetingOfficePlanner.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

@Component
public class CustomLoginFailureHandler extends SimpleUrlAuthenticationFailureHandler {

    @Autowired
    private UserService userService;

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
                                        AuthenticationException exception) throws IOException, ServletException {
        String UserName = request.getParameter("userName");
        User user = null;

        try {
            user = userService.getByUserName(UserName);
        } catch (UserNameNotFoundException e) {
            e.printStackTrace();
        }


        if (user != null) {
            if (user.isActive() && user.isAccountNonLocked()) {
                if (user.getNumFailedLogins() < UserService.MAX_FAILED_ATTEMPTS - 1) {
                    userService.increaseFailedAttempts(user);//done
                } else {
                    userService.lock(user);
                    exception = new LockedException("Your account has been locked due to 4 failed attempts."
                            + " It will be unlocked after 30 minutes.");
                }
            } else if (!user.isActive()) {
                if (userService.unlockWhenTimeExpired(user)) {
                    exception = new LockedException("Your account has been unlocked. Please try to login again.");
                }
            }

        }

        super.setDefaultFailureUrl("/login?error");
        super.onAuthenticationFailure(request, response, exception);
    }}

