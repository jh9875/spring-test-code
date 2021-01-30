package com.jh.springtestcode.junit4.web.dto;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class UserResoponseDtoTest {
	
	@Test
	public void UserResponseDto_assertion_테스트() {
		//given
		String name ="test";
		int age =10;

		//when
		UserResponseDto dto =new UserResponseDto(name, age);

		//then
		
	}
}
