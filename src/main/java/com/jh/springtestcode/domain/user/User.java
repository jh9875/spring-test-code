package com.jh.springtestcode.domain.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.jh.springtestcode.domain.BaseTimeEntity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
public class User extends BaseTimeEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String email;

	@Column(nullable = false)
	private String name;

	@Column
	private int age;

	@Builder
	public User(String email, String name, int age) {
		this.email =email;
		this.name =name;
		this.age =age;
	}

	public void update(String email, String name, int age) {
		this.email =email;
		this.name =name;
		this.age =age;
	}
}
