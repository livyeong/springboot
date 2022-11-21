package com.mysite.sbb;


import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.mysite.sbb.question.QuestionService;
import com.mysite.sbb.user.SiteUser;

@SpringBootTest
class SbbApplicationTests {

	@Autowired
	private QuestionService qService;

	
	@Test
	void testJpa() {

		for (int i = 1; i <= 250; i++) {
			String subject = String.format("테스트 데이터입니다:[%03d]", i);
			String content = "내용무";
			SiteUser user = null;
			this.qService.create(subject, content, user);
		}
	}

}