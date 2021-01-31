package com.jh.springtestcode.web;

import com.jh.springtestcode.service.UserService;
import com.jh.springtestcode.web.dto.UserSaveRequestDto;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class UserApiController {
	private final UserService userService;

	@PostMapping("/api/v1/user")
	public Long save(@RequestBody UserSaveRequestDto requestDto) {
		return userService.save(requestDto);
	}
}