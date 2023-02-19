package com.example.demo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.ResponseDto;
import com.example.demo.dto.UserDto;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;


@RestController
@RequestMapping("/user")
@Validated
public class UserController {

	@Autowired
	private UserService userservice;


	@PostMapping("/login")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<ResponseDto> userLogin(@RequestBody @Valid UserDto dto) {
		User user = new User();
		user.setUsername(dto.getUsername());
		user.setPassword(dto.getPassword());
		user.setUseremail(dto.getUseremail());
		return new ResponseEntity<ResponseDto>(userservice.userLogin(user), HttpStatus.CREATED);

	}

}
