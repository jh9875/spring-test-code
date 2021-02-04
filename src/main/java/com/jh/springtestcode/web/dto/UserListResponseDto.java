package com.jh.springtestcode.web.dto;

import java.time.LocalDateTime;

import com.jh.springtestcode.domain.user.User;

import lombok.Getter;

@Getter
public class UserListResponseDto {
	private Long id;
	private String email;
	private String name;
	private int age;
	private LocalDateTime modifiedDate;

	public UserListResponseDto(User entity) {
		this.id =entity.getId();
		this.email =entity.getEmail();
		this.name =entity.getName();
		this.age =entity.getAge();
		this.modifiedDate =entity.getModifiedDate();
	}
}
