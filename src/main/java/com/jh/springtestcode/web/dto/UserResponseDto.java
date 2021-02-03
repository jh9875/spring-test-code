package com.jh.springtestcode.web.dto;

import com.jh.springtestcode.domain.user.User;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class UserResponseDto {
	private Long id;
	private String email;
	private String name;
	private int age;

	public UserResponseDto(User entity) {
		this.id =entity.getId();
		this.email =entity.getEmail();
		this.name =entity.getName();
		this.age =entity.getAge();
	}

}