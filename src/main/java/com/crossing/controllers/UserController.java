package com.crossing.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crossing.dto.request.UserRequest;
import com.crossing.dto.response.UserResponse;
import com.crossing.services.IUserService;

@RestController
@RequestMapping(path = "/cross-checking/user")
public class UserController {

	@Autowired
	private IUserService userService;

	@GetMapping("ping")
	public String ping() {
		return "pong";
	}

	@PostMapping("create")
	public ResponseEntity<UserResponse> CreateUser(@Validated @RequestBody UserRequest userRequest) {
		return userService.create(userRequest);
	}

}
