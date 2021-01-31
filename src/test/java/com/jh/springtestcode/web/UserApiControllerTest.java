package com.jh.springtestcode.web;

import com.jh.springtestcode.domain.user.User;
import com.jh.springtestcode.domain.user.UserRepository;
import com.jh.springtestcode.web.dto.UserSaveRequestDto;
import com.jh.springtestcode.web.dto.UserUpdateRequestDto;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDateTime;
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

	@Test
	public void user_수정된다() throws Exception {
		//given
		User savedUser =userRepository.save(User.builder()
			.email("abc@test.com")
			.name("tester")
			.age(50)
			.build());
		
		Long updateId =savedUser.getId();
		String expectedEmail ="changedEmail";
		String expectedName ="chagedName";
		int expectedAge =25;
		
		UserUpdateRequestDto requestDto =UserUpdateRequestDto.builder()
			.email(expectedEmail)
			.name(expectedName)
			.age(expectedAge)
			.build();

		String url ="http://localhost:" +port +"/api/v1/user/" +updateId;

		HttpEntity<UserUpdateRequestDto> requestEntity =new HttpEntity<>(requestDto);

		//when
		ResponseEntity<Long> responseEntity =restTemplate.exchange(url, HttpMethod.PUT, requestEntity, Long.class);

		//then
		assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(responseEntity.getBody()).isGreaterThan(0L);

		List<User> all =userRepository.findAll();
		assertThat(all.get(0).getEmail()).isEqualTo(expectedEmail);
		assertThat(all.get(0).getName()).isEqualTo(expectedName);
		assertThat(all.get(0).getAge()).isEqualTo(expectedAge);
	}

	@Test
	public void BaseTimeEntity_등록() {
		//given
		LocalDateTime now =LocalDateTime.of(2021, 2, 1, 0, 0, 0);
		userRepository.save(User.builder()
			.email("email")
			.name("name")
			.age(10)
			.build());
		
		//when
		List<User> userList =userRepository.findAll();

		//then
		User user =userList.get(0);
		System.out.println(">>>>>>> creatDate =" +user.getCreatedDate()
			+", modifiedDate =" +user.getModifiedDate());

		assertThat(user.getCreatedDate()).isAfter(now);
		assertThat(user.getModifiedDate()).isAfter(now);
	}

}