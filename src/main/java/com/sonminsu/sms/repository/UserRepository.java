package com.sonminsu.sms.repository;

import com.sonminsu.sms.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
