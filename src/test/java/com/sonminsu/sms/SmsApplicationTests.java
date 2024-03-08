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
	}
}
