package com.example.demo.repository;

import javax.validation.constraints.NotNull;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.User;

public interface UserRepository extends JpaRepository<User,Integer> {

	

	User findByusername(@NotNull String username);

	User findByuserid(int userid);







}
