package com.jh.springtestcode.web.dto;

import com.jh.springtestcode.domain.user.User;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserSaveRequestDto {
	private String email;
	private String name;
	private int age;

	@Builder
	public UserSaveRequestDto(String name, String email, int age) {
		this.name =name;
		this.email =email;
		this.age =age;
	}

	public User toEntity() {
		return User.builder()
			.email(email)
			.name(name)
			.age(age)
			.build();
	}
}