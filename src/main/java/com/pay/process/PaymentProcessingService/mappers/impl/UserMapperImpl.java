package com.pay.process.PaymentProcessingService.mappers.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.pay.process.PaymentProcessingService.domain.dto.UserDTO;
import com.pay.process.PaymentProcessingService.domain.entities.UserEntity;
import com.pay.process.PaymentProcessingService.mappers.Mapper;

@Component
public class UserMapperImpl implements Mapper<UserEntity, UserDTO> {

	
	private ModelMapper modelMapper;
	
	
	
	public UserMapperImpl(ModelMapper modelMapper) {
		this.modelMapper = modelMapper;
	}

	@Override
	public UserDTO mapTo(UserEntity a) {
		// TODO Auto-generated method stub
		return modelMapper.map(a,UserDTO.class);
	}

	@Override
	public UserEntity mapFrom(UserDTO b) {
		// TODO Auto-generated method stub
		return modelMapper.map(b,UserEntity.class);
	}

}
