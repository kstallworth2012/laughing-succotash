package com.pay.process.PaymentProcessingService.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.pay.process.PaymentProcessingService.domain.entities.UserEntity;
import com.pay.process.PaymentProcessingService.repositories.UserRepository;
import com.pay.process.PaymentProcessingService.services.UserService;


@Service
public class UserServiceImpl implements UserService {
	
	private UserRepository _userRepository;
	
	public UserServiceImpl(UserRepository _userRepository) {
		this._userRepository = _userRepository;
	}

	@Override
	public UserEntity create(UserEntity _user) {
		// TODO Auto-generated method stub
		return _userRepository.save(_user);
	}

	@Override
	public UserEntity save(UserEntity _userEntity) {
		// TODO Auto-generated method stub
		return _userRepository.save(_userEntity);
	}

	@Override
	public List<UserEntity> findAll() {
		// TODO Auto-generated method stub
		return StreamSupport.stream(_userRepository.findAll()
								.spliterator(),false)
								.collect(Collectors.toList());
	}

	@Override
	public Page<UserEntity> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return _userRepository.findAll(pageable);
	}

	@Override
	public Optional<UserEntity> findOne(UUID id) {
		// TODO Auto-generated method stub
		return _userRepository.findById(id);
	}

	@Override
	public boolean isExists(UUID id) {
		// TODO Auto-generated method stub
		return _userRepository.existsById(id);
	}

	@Override
	public UserEntity partialUpdate(UUID _id, UserEntity _user) {
		// TODO Auto-generated method stub
		_user.setUser_id(_id);
		
		return _userRepository.findById(_id).map(existingUser -> {
			 return _userRepository.save(existingUser);
		}).orElseThrow(  ()-> new RuntimeException("User doesn't exist"));
	 }
	

	@Override
	public void delete(UUID _id) {
		// TODO Auto-generated method stub
		_userRepository.deleteById(_id);
	}

}
