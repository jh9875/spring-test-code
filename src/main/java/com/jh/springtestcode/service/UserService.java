package com.jh.springtestcode.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.transaction.annotation.Transactional;

import com.jh.springtestcode.domain.user.User;
import com.jh.springtestcode.domain.user.UserRepository;
import com.jh.springtestcode.web.dto.UserListResponseDto;
import com.jh.springtestcode.web.dto.UserResponseDto;
import com.jh.springtestcode.web.dto.UserSaveRequestDto;
import com.jh.springtestcode.web.dto.UserUpdateRequestDto;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserService {
	private final UserRepository userRepository;

	@Transactional
	public Long save(UserSaveRequestDto requestDto) {
		return userRepository.save(requestDto.toEntity()).getId();
	}

	@Transactional
	public Long update(Long id, UserUpdateRequestDto requestDto) {
		User user =userRepository.findById(id)
			.orElseThrow(() -> new IllegalArgumentException("해당 유저가 없습니다. id =" +id));
		
		user.update(requestDto.getEmail(), requestDto.getName(), requestDto.getAge());
		return id;
	}

	@Transactional
	public void delete(Long id) {
		User user =userRepository.findById(id)
			.orElseThrow(() ->new IllegalArgumentException("해당 유저가 없습니다. id =" +id));

		userRepository.delete(user);
	}

	@Transactional(readOnly = true)
	public UserResponseDto findById(Long id) {
		User entity =userRepository.findById(id)
			.orElseThrow(() ->new IllegalArgumentException("해당 유저가 없습니다. id =" +id));

		return new UserResponseDto(entity);
	}

	@Transactional(readOnly = true)
	public List<UserListResponseDto> findAllDesc() {
		return userRepository.findAllDesc().stream()
			.map(UserListResponseDto::new)
			.collect(Collectors.toList());
	}
}
