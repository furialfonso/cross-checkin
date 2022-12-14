package com.crossing.dto.request;

import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import lombok.Data;

@Data
public class UserRequest {
	@NotBlank(message = "required field")
	private String name;
	@NotBlank(message = "required field")
	private String lastName;
	@NotBlank(message = "required field")
	private String email;
	@NotBlank(message = "required field")
	@Length(min = 8, max = 16)
	private String password;
}
