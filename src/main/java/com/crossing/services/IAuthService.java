package com.crossing.services;

import org.springframework.http.ResponseEntity;

import com.crossing.dto.request.LoginRequest;

public interface IAuthService {

	public ResponseEntity<String> login(LoginRequest loginRequest);
}
