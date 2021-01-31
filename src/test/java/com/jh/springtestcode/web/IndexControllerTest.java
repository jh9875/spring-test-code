package com.jh.springtestcode.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@WebMvcTest(controllers = IndexController.class)
public class IndexControllerTest {
	@Autowired
	private MockMvc mvc;

	@Test
	public void index_테스트() throws Exception {
		

		mvc.perform(get("/"))
			.andExpect(status().isOk());
	}
}
