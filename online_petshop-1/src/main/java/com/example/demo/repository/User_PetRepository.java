package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.User;
import com.example.demo.entity.User_Pet;



public interface User_PetRepository extends JpaRepository<User_Pet, Long>{

	

	List<User_Pet> findByuserid(int userid);

	List<User_Pet> findUser_PetByuserid(int userid);



}
