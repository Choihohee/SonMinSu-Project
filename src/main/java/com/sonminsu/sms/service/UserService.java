package com.sonminsu.sms.service;
import com.sonminsu.sms.model.User;
import com.sonminsu.sms.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public User create(String userName, String userId, String userPassword, String email) {
        User user = new User();
        user.setUserName(userName);
        user.setUserId(userId);
        user.setUserPassword(passwordEncoder.encode(userPassword));
        user.setEmail(email);
        this.userRepository.save(user);
        return user;
    }
}
