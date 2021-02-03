package com.jh.springtestcode.examples;

import com.jh.springtestcode.web.UserApiController;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = UserApiController.class)
public class MockMvcExampleTest {
	@Autowired
	private MockMvc mvc;

	@Test
	public void get_유저테스트() {

	}

	@Test
	public void post_유저테스트() {

	}

	@Test
	public void put_유저테스트() {

	}

	@Test
	public void delete_유저테스트() {

	}
}
