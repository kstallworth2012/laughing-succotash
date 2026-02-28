package com.pay.process.PaymentProcessingService.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.pay.process.PaymentProcessingService.domain.entities.UserEntity;

public interface UserService {
	
	
	UserEntity create(UserEntity _user);
	UserEntity save(UserEntity _userEntity);
	List<UserEntity> findAll();
	Page<UserEntity> findAll(Pageable pageable);
	Optional<UserEntity> findOne(UUID id);
	boolean isExists(UUID id);
	UserEntity partialUpdate(UUID _id, UserEntity _user);
	void delete(UUID _id);

}
