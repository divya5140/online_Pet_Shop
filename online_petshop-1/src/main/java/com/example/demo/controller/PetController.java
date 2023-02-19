package com.example.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.dto.ResponseDto;
import com.example.demo.entity.Pet;
import com.example.demo.service.PetService;



@RestController
public class PetController {

	@Autowired
	public PetService service;

	@PostMapping("/addpet")
	public ResponseDto savepet(@RequestBody @Valid Pet pet){
		service.save(pet);
		return  new ResponseDto("Pet added successfully");
	}

	@GetMapping("/findPet/{petName}")
	public List<Pet> findPetByPetNameStarting(@RequestParam String  petName){
		return service.findPetByPetNameStartingWith(petName);
	}



	@GetMapping("/findPetNameContains/{petName}")
	public List<Pet> findPetNameLike(@RequestParam String petName){
		return service.findPetByPetNameContains(petName);
	}
}
