package com.crossing.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.crossing.dto.request.UserRequest;
import com.crossing.dto.response.UserResponse;
import com.crossing.entities.User;
import com.crossing.repository.IUserRepository;
import com.crossing.services.IUserService;

@Service
public class UserService implements IUserService {

	@Autowired
	private IUserRepository userRepository;

	@Override
	public ResponseEntity<UserResponse> create(UserRequest userRequest) {
		User user = new User();
		user.setName(userRequest.getName());
		user.setLastName(userRequest.getLastName());
		user.setEmail(userRequest.getEmail());
		user.setPassword(userRequest.getPassword());

		user = userRepository.save(user);

		UserResponse userResponse = new UserResponse();
		userResponse.setName(user.getName());
		userResponse.setLastName(user.getLastName());
		userResponse.setEmail(user.getEmail());

		return new ResponseEntity<>(userResponse, HttpStatus.CREATED);
	}

}
