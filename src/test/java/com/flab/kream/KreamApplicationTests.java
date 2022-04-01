package com.flab.kream;

import com.flab.model.Member;
import com.flab.service.MemberService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@WebMvcTest
@SpringBootTest
class KreamApplicationTests {

	@Autowired(required=false)
	MemberService memberService;

	@Autowired
	private MockMvc mvc;

	@Test
	void contextLoads() {
	}

	@Test
	@DisplayName("멤버조회")
	void test(){
		Member member = memberService.getMember("testid");
		System.out.println("member = " + member.toString());

	}
}
