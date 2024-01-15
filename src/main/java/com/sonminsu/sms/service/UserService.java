package com.sonminsu.sms.service;

import com.sonminsu.sms.model.User;
import com.sonminsu.sms.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


    public User create(String username, String userPassword, String email) {    //, String phoneNumber
        User user = new User();
        user.setUserName(username);
        user.setUserPassword(passwordEncoder.encode(userPassword));
        user.setEmail(email);
        //user.setPhoneNumber(phoneNumber);
        this.userRepository.save(user);
        return user;
    }
}
