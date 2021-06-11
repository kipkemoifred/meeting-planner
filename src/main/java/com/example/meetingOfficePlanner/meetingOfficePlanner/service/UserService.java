package com.example.meetingOfficePlanner.meetingOfficePlanner.service;

import com.example.meetingOfficePlanner.meetingOfficePlanner.entity.User;
import com.example.meetingOfficePlanner.meetingOfficePlanner.exception.UserNameNotFoundException;
import com.example.meetingOfficePlanner.meetingOfficePlanner.exception.UserNotFoundException;
import com.example.meetingOfficePlanner.meetingOfficePlanner.repository.UserRepository;
import net.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
public class UserService {
    public static final int MAX_FAILED_ATTEMPTS = 4;
    private static final long LOCK_TIME_DURATION = 30*60* 1000;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private SendEmailService sendEmailService;
    public void increaseFailedAttempts(User user) {
        //int newFailAttempts = user.getNumFailedLogins() + 1;
        userRepository.onFailedAttempts(user.getUserName());//done
    }
    public void resetFailedAttempts(User user) {
        userRepository.onLoginSuccess(user.getUserName());
    }
    public void lock(User user) {
        user.setActive(false);
        user.setLockedUntil( new Date());

        userRepository.save(user);
    }
    public boolean unlockWhenTimeExpired(User user) {
        long lockTimeInMillis = user.getLockedUntil().getTime();
        long currentTimeInMillis = System.currentTimeMillis();

        System.out.println("in unlock expred ");
        if (lockTimeInMillis + LOCK_TIME_DURATION < currentTimeInMillis) {
            System.out.println("in unlock expred if");
            user.setActive(true);
            user.setLockedUntil(null);
            user.setNumFailedLogins(0);

            userRepository.save(user);

            return true;
        }

        return false;
    }
//    public User getByEmail(String email)throws EmailNotFoundException{
//        return userRepository.findByEmail(email).orElseThrow(()->new EmailNotFoundException(email));
//    }
    public User getByUserName(String userName)throws UserNameNotFoundException
            {
        return userRepository.findByUserName(userName).orElseThrow(()->new UserNameNotFoundException(userName));
    }
   public List<User> getUsers(){
        return userRepository.findAll();

   }
    public User getUser(int userid) throws UserNotFoundException {
        return userRepository.findById(userid).orElseThrow(()->new UserNotFoundException(userid));

    }


    public User addUser(User user){
        return userRepository.save(user);
    }
    public User updateUser(int userid,User userDetails) throws UserNotFoundException {
        User user=userRepository.findById(userid).orElseThrow(()-> new UserNotFoundException(userid));
        user.setEmail(userDetails.getEmail());
        user.setPassword(userDetails.getPassword());
        user.setPhoneNumber(userDetails.getPhoneNumber());
        user.setStakeholderPosition(userDetails.getStakeholderPosition());
        user.setUserId(userDetails.getUserId());
        user.setUserName(userDetails.getUserName());
        User updatedUser=userRepository.save(user);
        return updatedUser;
    }
    public void updateResetPasswordToken(UUID token, String email){
User user=userRepository.findByEmail(email);
if(user!=null){
    user.setResetPasswordToken(token.toString());

}else{
    System.out.println("user not found");
}
    }
    public User get(String resetPasswordToken){
        return userRepository.findByResetPasswordToken(resetPasswordToken);
    }
    public void updatePassword(User user,String newPassword){
        user.setPassword(newPassword);
        user.setResetPasswordToken(null);
        userRepository.save(user);
    }
//    public void handleLock30Mins(){
//
//    }
public User getByResetPasswordToken(String token) {
    return userRepository.findByResetPasswordToken(token);
}

}
