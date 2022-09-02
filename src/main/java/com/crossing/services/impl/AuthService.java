package com.crossing.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.crossing.dto.request.LoginRequest;
import com.crossing.entities.User;
import com.crossing.repository.IUserRepository;
import com.crossing.services.IAuthService;

@Service
public class AuthService implements IAuthService {

	@Autowired
	private IUserRepository userRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public ResponseEntity<String> login(LoginRequest loginRequest) {
		User user = userRepository.findByEmail(loginRequest.getEmail());
		if (user == null) {
			return new ResponseEntity<>("incorrect data, try again", HttpStatus.NOT_FOUND);
		}
		boolean isLogin = passwordEncoder.matches(loginRequest.getPassword(), user.getPassword());
		return new ResponseEntity<>(isLogin ? "true" : "false", HttpStatus.ACCEPTED);
	}
}
