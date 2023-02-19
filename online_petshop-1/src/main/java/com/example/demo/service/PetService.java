package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.ResponseDto;
import com.example.demo.entity.Pet;

public interface PetService {

	ResponseDto save(Pet pet);

	List<Pet> findPetByPetNameStartingWith(String  petName);

	List<Pet>  findPetByPetNameContains(String petName);

	

	
}
