package com.example.demo.dto;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserDto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userid;
	
	@NotNull
	@NotEmpty(message = "Username should not be empty")
	@Size(min = 2, max = 8,message="Username should be between size 2 and 8")
	private String username;
	
	@NotNull(message="email is required")
    @Email(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}",message="Email should follow this pattern([a-z0-9._%+-]+@[a-z0-9.-]+\\\\.[a-z]{2,3)})")
	@Column(unique = true)
	private String useremail;
	@NotNull
	@Size(min = 5, max = 8)
	@NotEmpty(message = "Password should not be empty")
	private String password;



}
