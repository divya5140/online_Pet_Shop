package com.example.demo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.ResponseDto;
import com.example.demo.dto.User_PetDto;
import com.example.demo.entity.Pet;
import com.example.demo.entity.User;
import com.example.demo.entity.User_Pet;
import com.example.demo.exception.PetNotFoundException;
import com.example.demo.exception.UserNotFoundException;
import com.example.demo.repository.PetRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.repository.User_PetRepository;
import com.example.demo.service.User_PetService;
@Service
public class User_PetServiceImpl implements User_PetService{



	@Autowired
	public User_PetRepository repository;

	@Autowired
	private PetRepository petRepository;
	@Autowired
	private UserRepository userRepository;

	@Override
	public ResponseDto purchase(User_PetDto userPetsDto) {

		User_Pet userpet=new User_Pet();

		Pet pets = petRepository.findById(userPetsDto.getPetid()).orElseThrow(
				() -> new PetNotFoundException());
		User user = userRepository.findById(userPetsDto.getUserid()).orElseThrow(
				() -> new UserNotFoundException());
		if (pets.getQuantity() - userPetsDto.getQuantitysold() >= 0) {
			pets.setQuantity(pets.getQuantity() - userPetsDto.getQuantitysold());
			petRepository.save(pets);
			userRepository.save(user);
			userpet.setPetid(userPetsDto.getPetid());
			userpet.setUserid(userPetsDto.getUserid());
			userpet.setQuantitysold(userPetsDto.getQuantitysold());
			repository.save(userpet);


			return new ResponseDto("Purchase Successful");
		}
		return new ResponseDto("Purchase failed");

	}



	public List<User_Pet> purchaseHistory(int userid) {
		
		{
			
			return repository.findByuserid(userid);
			
		}
			
	
}

}



