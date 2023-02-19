package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Pet {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long petId;
	@NotEmpty(message = "PetName should not be empty")
	private String petName;
	@NotNull(message="Quantity is required")
	private Long quantity;
	@NotNull(message = "Please enter a valid price")
	private double price;



}
