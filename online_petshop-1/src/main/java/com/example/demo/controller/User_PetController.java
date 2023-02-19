package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.ResponseDto;
import com.example.demo.dto.User_PetDto;
import com.example.demo.entity.User_Pet;
import com.example.demo.service.User_PetService;


@RestController
@RequestMapping("/user_pet")
public class User_PetController {

	@Autowired
	private User_PetService service;

	@PostMapping("/purchase")
	public ResponseEntity<ResponseDto> purchase(@RequestBody User_PetDto userPets) {
		return ResponseEntity.status(HttpStatus.CREATED).body(service.purchase(userPets));
	}

	@GetMapping("purchaseHistory/{userId}")
	public ResponseEntity<List<User_Pet>> purchaseHistory(@PathVariable int userId) {
		return ResponseEntity.ok(service.purchaseHistory(userId));

	}
}