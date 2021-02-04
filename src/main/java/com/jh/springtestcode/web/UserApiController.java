package com.jh.springtestcode.web;

import java.util.List;

import com.jh.springtestcode.service.UserService;
import com.jh.springtestcode.web.dto.UserListResponseDto;
import com.jh.springtestcode.web.dto.UserResponseDto;
import com.jh.springtestcode.web.dto.UserSaveRequestDto;
import com.jh.springtestcode.web.dto.UserUpdateRequestDto;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

	@PutMapping("/api/v1/user/{id}")
	public Long update(@PathVariable Long id, @RequestBody UserUpdateRequestDto requestDto) {
		return userService.update(id, requestDto);
	}

	@DeleteMapping("/api/v1/user/{id}")
	public Long delete(@PathVariable Long id) {
		userService.delete(id);
		return id;
	}

	@GetMapping("/api/v1/user/{id}")
	public UserResponseDto findById(@PathVariable Long id) {
		return userService.findById(id);
	}

	@GetMapping("/api/v1/user/list")
	public List<UserListResponseDto> findAll() {
		return userService.findAllDesc();
	}
}