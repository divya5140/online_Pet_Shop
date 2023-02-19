package com.example.demo.implementation;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.demo.dto.User_PetDto;
import com.example.demo.entity.Pet;
import com.example.demo.entity.User;
import com.example.demo.entity.User_Pet;
import com.example.demo.repository.PetRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.repository.User_PetRepository;
import com.example.demo.serviceImpl.User_PetServiceImpl;



@ExtendWith(SpringExtension.class)
public class User_PetServiceImplementationTest {

	@InjectMocks
	User_PetServiceImpl user_petserviceimpl;

	@Mock
	User_PetRepository user_petrepository;

	@Mock
	PetRepository petRepository;

	@Mock
	UserRepository userRepository;


	@Test
	void testAddPet()
	{

		User_PetDto user_pet=new User_PetDto();
		User_Pet userpet=new User_Pet();
		userpet.setUser_petid(1);
		User user=new User();
		user.setUserid(1);
		Pet pet=new Pet();
		pet.setPetId(3l);
		pet.setPetName("dog");
		pet.setQuantity(10l);
		pet.setPrice(200.0);
		user_pet.setUserid(1);
		user_pet.setPetid(3l);
		user_pet.setQuantitysold(3l);

		Mockito.when(petRepository.findById(user_pet.getPetid())).thenReturn(Optional.of(pet));

		Mockito.when(userRepository.findById(user_pet.getUserid())).thenReturn(Optional.of(user));
		Mockito.when(petRepository.save(pet)).thenReturn(pet);
		Mockito.when(user_petrepository.save(userpet)).thenReturn(userpet);

		assertEquals("Purchase Successful", user_petserviceimpl.purchase(user_pet).getMessage());


	}


}
