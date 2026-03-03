package com.pay.process.PaymentProcessingService.controllers;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	
	    
	   
	   
   	 @GetMapping(path = "/{user_id}")
     public ResponseEntity<UserDTO> getUser(@PathVariable("user_id") UUID id){
    	 Optional<UserEntity> foundUser = userService.findOne(id);
    	 return foundUser.map(userEntity ->{
    		 UserDTO userDTO = userMapper.mapTo(userEntity);
    		 return new ResponseEntity<>(userDTO, HttpStatus.OK);
    	 
    	 }).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
     }
     
   
   
   
   
      
   
     
    //PAGEABLE
//@GetMapping(path="/")
//public Page<UserDTO> listUsers(Pageable page){
//	Page<UserEntity> users = activitiesService.findAll(page);
//	return users.map(userMapper::mapTo);
//}
   
    @PostMapping(path = "/new-user")
     public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO _userDTO){
          
     			UserEntity userEntity = userMapper.mapFrom(_userDTO);
     	     	UserEntity savedUserEntity = userService.create(userEntity);
     	     	return new ResponseEntity<>(userMapper.mapTo(savedUserEntity), HttpStatus.CREATED);
     }
 
 
    @PutMapping(path="/{id}")
    public ResponseEntity<UserDTO> fullUpdateUser(@PathVariable("id") UUID id, @RequestBody UserDTO userDto){
	
	if(!userService.isExists(id)) {
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
	}
	
	userDto.setUser_id(id);
	UserEntity userEntity = userMapper.mapFrom(userDto);
	UserEntity savedUserEntity = userService.save(userEntity);
	
	return new ResponseEntity<>(userMapper.mapTo(savedUserEntity), HttpStatus.OK); 
	
}	



@PatchMapping(path ="/{id}")
public ResponseEntity<UserDTO> partialUpdate(@PathVariable("id") UUID id, @RequestBody UserDTO appDto){
	
	if(!userService.isExists(id)) {
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
	}
	
	UserEntity userEntity = userMapper.mapFrom(appDto);
	UserEntity updatedUser = userService.partialUpdate(id, userEntity);
	
	return new ResponseEntity<>(userMapper.mapTo(updatedUser), HttpStatus.OK);
	
	
	
}

     
     
    
     
	
	
	
	
	
	
	
	
	
	 @DeleteMapping(path="/{id}")
	public ResponseEntity<UserDTO> deleteUser(@PathVariable("id") UUID id) {
		
		userService.delete(id);
		
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	
	

}
