package com.jh.springtestcode.junit4.web.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class UserResponseDto {
	private final String name;
	private final int age;
}
