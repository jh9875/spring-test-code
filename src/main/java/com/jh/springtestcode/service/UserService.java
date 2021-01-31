package com.jh.springtestcode.service;

import javax.transaction.Transactional;

import com.jh.springtestcode.domain.user.UserRepository;
import com.jh.springtestcode.web.dto.UserSaveRequestDto;

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
}
