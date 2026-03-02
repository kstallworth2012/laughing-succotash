package com.pay.process.PaymentProcessingService.controllers;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pay.process.PaymentProcessingService.domain.dto.UserDTO;
import com.pay.process.PaymentProcessingService.domain.entities.UserEntity;
import com.pay.process.PaymentProcessingService.mappers.Mapper;
import com.pay.process.PaymentProcessingService.services.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {
	
	
  	private UserService userService;
	private Mapper<UserEntity,UserDTO> userMapper;
	
	
	public UserController(UserService userService, Mapper<UserEntity, UserDTO> userMapper) {
		this.userService = userService;
		this.userMapper = userMapper;
	}
	
	
	
	
	
	 @GetMapping(path = "/")
	 public List<UserDTO> listUsers(){
	    	 List<UserEntity> users = userService.findAll();
	    	 return users.stream().map(userMapper::mapTo).collect(Collectors.toList());
	    			 }
	
	
	
	
	
	
	
	
	
	
	
	
	 @DeleteMapping(path="/{id}")
	public ResponseEntity<UserDTO> deleteUser(@PathVariable("id") UUID id) {
		
		userService.delete(id);
		
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	
	

}
