package com.sonminsu.sms;

import com.sonminsu.sms.model.Post;
import com.sonminsu.sms.repository.PostRepository;
import com.sonminsu.sms.service.PostService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
class SmsApplicationTests {
	@Autowired
	private PostService postService;

	@Test
	void testJpa() {
		for (int i = 1; i <= 300; i++) {
			String subject = String.format("테스트 데이터입니다:[%03d]", i);
			this.postService.create(subject);
		}
	}
}
