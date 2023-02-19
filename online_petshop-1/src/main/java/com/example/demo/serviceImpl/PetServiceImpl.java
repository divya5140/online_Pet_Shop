package com.example.demo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.ResponseDto;

import com.example.demo.entity.Pet;
import com.example.demo.repository.PetRepository;
import com.example.demo.service.PetService;

@Service
public class PetServiceImpl implements PetService{

	@Autowired
	public PetRepository repository;

	public ResponseDto save(Pet pet) {
		repository.save(pet);
		return new ResponseDto("Pet added successfully");
	}


	public List<Pet> findPetByPetNameStartingWith(String  petName)  {
		
		return repository.findPetByPetNameIsStartingWith(petName);
		}	
	
	
	 @Override
	    public List<Pet> findPetByPetNameContains(String petName) {
	        return repository.findPetByPetNameContains(petName);
	    }
	 
	 
	
	 
	
		}
