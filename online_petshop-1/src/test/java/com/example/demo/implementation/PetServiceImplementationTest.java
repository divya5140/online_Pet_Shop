package com.example.demo.implementation;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.demo.entity.Pet;
import com.example.demo.repository.PetRepository;
import com.example.demo.serviceImpl.PetServiceImpl;

@ExtendWith(SpringExtension.class)
public class PetServiceImplementationTest {

	
	@InjectMocks
	PetServiceImpl petservimpl;

	@Mock
	PetRepository petRepository;

	@Test
	void testCreatePet() {
	Pet pet= new Pet();
	pet.setPetName("rat");
	pet.setQuantity(38l);
	pet.setPrice(300.0);
	Mockito.when(petRepository.save(pet)).thenReturn(pet);
	assertEquals("Pet added successfully", petservimpl.save(pet).getMessage());
	}

	
	
	
}
