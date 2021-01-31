package com.jh.springtestcode.web;

import com.jh.springtestcode.domain.user.User;
import com.jh.springtestcode.domain.user.UserRepository;
import com.jh.springtestcode.web.dto.UserSaveRequestDto;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserApiControllerTest {
	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	@Autowired
	private UserRepository userRepository;

	@After
	public void tearDown() throws Exception {
		userRepository.deleteAll();
	}

	@Test
	public void user_등록된다() throws Exception {
		//given
		String email ="abc@test.com";
		String name ="tester";
		int age =50;
		UserSaveRequestDto requestDto =UserSaveRequestDto.builder()
			.email(email)
			.name(name)
			.age(age)
			.build();
		
		String url ="http://localhost:" +port +"/api/v1/user";

		//when
		ResponseEntity<Long> responseEntity =restTemplate.postForEntity(url, requestDto, Long.class);

		//then
		assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(responseEntity.getBody()).isGreaterThan(0L);

		List<User> all =userRepository.findAll();
		assertThat(all.get(0).getEmail()).isEqualTo(email);
		assertThat(all.get(0).getName()).isEqualTo(name);
		assertThat(all.get(0).getAge()).isEqualTo(age);
	}
}