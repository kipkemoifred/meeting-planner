package com.example.meetingOfficePlanner.meetingOfficePlanner.repository;

import com.example.meetingOfficePlanner.meetingOfficePlanner.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Integer>{
    Optional<User> findByUserName(String userName);
    @Query("SELECT c FROM User c WHERE c.resetPasswordToken=?1")
    public User findByResetPasswordToken(String token);
    @Query("SELECT c FROM User c WHERE c.email=?1")

    User findByEmail(String email);
    @Query("UPDATE User u SET u.NumFailedLogins = u.NumFailedLogins + 1 WHERE u.userName = ?1")
    @Modifying
    public void onFailedAttempts(String userName);

    @Query("UPDATE User u SET u.NumFailedLogins = 0 WHERE u.userName = ?1")
    @Modifying
    public void onLoginSuccess(String userName);



}
