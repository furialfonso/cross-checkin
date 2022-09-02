package com.crossing.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crossing.dto.request.LoginRequest;
import com.crossing.services.IAuthService;

@RestController
@RequestMapping(path = "/cross-checking/auth")
public class AuthController {

	@Autowired
	private IAuthService authService;

	@PostMapping("login")
	public ResponseEntity<String> Login(@Validated @RequestBody LoginRequest loginRequest) {
		return authService.login(loginRequest);
	}
}
