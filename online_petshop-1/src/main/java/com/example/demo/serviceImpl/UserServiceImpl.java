package com.example.demo.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.ResponseDto;
import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;

@Service
public class UserServiceImpl implements UserService {


	@Autowired
	private UserRepository userRepository;

	public ResponseDto userLogin(User user) {

		ResponseDto response = new ResponseDto();
		User user2 = userRepository.findByusername(user.getUsername());

		if (user2 == null) {
			userRepository.save(user);
			response.setMessage("account created and logged in successfully");
			return response;
		} else if (( (user.getPassword().equals(user2.getPassword()))
				&& (user.getUsername().equals(user2.getUsername())))) {
			response.setMessage(" Logged in Successfully");
			return response;
			}
		else {
			response.setMessage("Invalid username and password");
			return response;

		}

	}

}




