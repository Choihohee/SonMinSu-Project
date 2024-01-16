package com.sonminsu.sms.user;

import com.sonminsu.sms.DataNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserService {

	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;

	public SiteUser create(String username, String email, String password) {
		SiteUser user = new SiteUser();
		user.setUsername(username);
		user.setEmail(email);
		user.setPassword(passwordEncoder.encode(password));
		this.userRepository.save(user);
		return user;
	}

	public SiteUser getUser(String username) {
		Optional<SiteUser> siteUser = this.userRepository.findByUsername(username);
		if (siteUser.isPresent()) {
			return siteUser.get();
		} else {
			throw new DataNotFoundException("siteuser not found");
		}
	}

	@Transactional
	public void withdraw(String username, String password) throws Exception {
		SiteUser user = userRepository.findByUsername(username)
				.orElseThrow(() -> new DataNotFoundException("User not found"));

		// 비밀번호 확인
		if (!passwordEncoder.matches(password, user.getPassword())) {
			throw new Exception("비밀번호를 확인해주세요");
		}

		try {
			userRepository.deleteByUsername(username);
		} catch (EmptyResultDataAccessException e) {
			throw new Exception("회원 탈퇴를 진행하는 동안 오류가 발생했습니다.");
		}
	}

}
