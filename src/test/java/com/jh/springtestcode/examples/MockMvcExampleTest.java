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

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;



@RunWith(SpringRunner.class)
// @WebMvcTest(controllers = UserApiController.class)
@WebMvcTest()
public class MockMvcExampleTest {
	@Autowired
	private MockMvc mvc;

	@Test
	public void get_테스트() throws Exception {
		mvc.perform(get("/api/v1/user/{id}"))
			.andExpect(status().isOk())
			.andExpect(status().is5xxServerError())
			.andDo(print())
			.andReturn();
		
	
	}

	@Test
	public void post_테스트() throws Exception {
		mvc.perform(post("/api/v1/user"))
			.andExpect(status().isOk());
	}

	@Test
	public void put_테스트() throws Exception {
		mvc.perform(put("/api/v1/user/{id}"))
			.andExpect(status().isOk());
	}

	@Test
	public void delete_테스트() throws Exception {
		mvc.perform(delete("/api/v1/user/{id}"))
			.andExpect(status().isOk());
	}
}
