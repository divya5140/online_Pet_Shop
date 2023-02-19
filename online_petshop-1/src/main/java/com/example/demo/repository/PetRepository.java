package com.example.demo.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Pet;



public interface PetRepository extends JpaRepository<Pet, Long>{

	List<Pet> findPetByPetNameIsStartingWith(String  petName);

	List<Pet> findPetByPetName(String petName);

	List<Pet> findPetByPetNameContains(String petName);

	

	

}
