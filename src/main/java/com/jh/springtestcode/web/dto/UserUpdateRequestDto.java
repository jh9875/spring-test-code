package com.jh.springtestcode.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserUpdateRequestDto {
	private String email;
	private String name;
	private int age;

	@Builder
	public UserUpdateRequestDto(String email, String name, int age) {
		this.email =email;
		this.name =name;
		this.age =age;
	}
}
