package com.crossing.services;

import org.springframework.http.ResponseEntity;

import com.crossing.dto.request.UserRequest;
import com.crossing.dto.response.UserResponse;

public interface IUserService {

	public ResponseEntity<UserResponse> create(UserRequest userRequest);

}
