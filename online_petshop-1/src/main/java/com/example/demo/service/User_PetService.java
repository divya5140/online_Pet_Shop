package com.example.demo.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.example.demo.dto.ResponseDto;
import com.example.demo.dto.User_PetDto;
import com.example.demo.entity.User_Pet;

public interface User_PetService {

	
	ResponseDto purchase(User_PetDto userPetsDto);
	
	List<User_Pet> purchaseHistory(int userid);
	
}
