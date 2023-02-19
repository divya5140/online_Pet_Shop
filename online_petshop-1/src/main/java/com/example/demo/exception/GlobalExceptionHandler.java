package com.example.demo.exception;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;



@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {


	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,HttpHeaders headers,HttpStatus status,WebRequest request)
	{
		List<String> details=new ArrayList<String>();
		for(ObjectError error:ex.getBindingResult().getAllErrors())
		{
			details.add(error.getDefaultMessage());
		}
		ErrorResponse error=new ErrorResponse(5000L, details);
		return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
	}
	

	@ExceptionHandler(value = PetNotFoundException.class)
	   public ResponseEntity<Object> exception(PetNotFoundException exception) {
	      return new ResponseEntity<>("Pet not found", HttpStatus.NOT_FOUND);
	   }
	
	@ExceptionHandler(value = UserNotFoundException.class)
	   public ResponseEntity<Object> exception(UserNotFoundException exception) {
	      return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
	   }
	
	
	@ExceptionHandler(value = UserIdNotFoundException.class)
	   public ResponseEntity<Object> exception(UserIdNotFoundException exception) {
	      return new ResponseEntity<>("User Id  not found", HttpStatus.NOT_FOUND);
	   }

	
}
