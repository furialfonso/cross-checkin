package com.crossing.dto.request;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

import org.springframework.boot.context.properties.bind.Name;

import lombok.Data;

@Data
@Valid
public class UserRequest {
	@NotBlank(message = "required field")
	private String name;
	@NotBlank(message = "required field")
	private String lastName;
	@NotBlank(message = "required field")
	private String email;
	@NotBlank(message = "required field")
	private String password;
}
