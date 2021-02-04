package com.jh.springtestcode.examples;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jh.springtestcode.domain.user.User;
import com.jh.springtestcode.domain.user.UserRepository;
import com.jh.springtestcode.service.UserService;
import com.jh.springtestcode.web.UserApiController;
import com.jh.springtestcode.web.dto.UserSaveRequestDto;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;


//단위테스트
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserControllerTest {
	
	@LocalServerPort
	private int port;
	
	@Autowired
    private UserRepository userRepository;

	@Autowired
	private WebApplicationContext context;

	private MockMvc mvc;

	@Before
	public void setup() {
		mvc =MockMvcBuilders
			.webAppContextSetup(context)
			.build();
	}
	@After
	public void tearDown() {
		userRepository.deleteAll();
	}



	@Test
	public void get_유저목록얻기_테스트() throws Exception {
		//given


		//when


		//then
		
		
		
	
	}

	@Test
	public void post_테스트() throws Exception {
		//given
		String email ="abc@test.com";
		String name ="tester";
		int age =50;
		UserSaveRequestDto requestDto =UserSaveRequestDto.builder()
			.email(email)
			.name(name)
			.age(age)
			.build();
		
		String url ="http://localhost:" +port + "/api/v1/user";

		//when
		mvc.perform(post(url)
			.contentType(MediaType.APPLICATION_JSON_UTF8)
			.content(new ObjectMapper().writeValueAsString(requestDto)))
			.andExpect(status().isOk());

		//then
		List<User> all =userRepository.findAll();
		assertThat(all.get(0).getEmail()).isEqualTo(email);
		assertThat(all.get(0).getName()).isEqualTo(name);
		assertThat(all.get(0).getAge()).isEqualTo(age);
	}

	@Test
	public void put_테스트() throws Exception {
		
	}

	@Test
	public void delete_테스트() throws Exception {
		
	}
}
