package com.jh.springtestcode.domain.user;


import java.util.List;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {
	@Autowired
	UserRepository userRepository;

	@After
	public void cleanup() {
		userRepository.deleteAll();
	}

	@Test
	public void user_불러오기() {
		//given
		String email ="abc@test.com";
		String name ="tester";
		int age =50;

		userRepository.save(User.builder()
			.email(email).name(name).age(age).build());
		
		//when
		List<User> userList =userRepository.findAll();

		//then
		User user =userList.get(0);
		assertThat(user.getEmail()).isEqualTo(email);
		assertThat(user.getName()).isEqualTo(name);
		assertThat(user.getAge()).isEqualTo(age);
	}
}
