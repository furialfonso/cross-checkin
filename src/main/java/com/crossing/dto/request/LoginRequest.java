package com.crossing.dto.request;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class LoginRequest {
	@NotBlank(message = "required field")
	private String email;
	@NotBlank(message = "required field")
	private String password;
}
