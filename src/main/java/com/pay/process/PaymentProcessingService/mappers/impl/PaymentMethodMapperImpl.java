package com.pay.process.PaymentProcessingService.mappers.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.pay.process.PaymentProcessingService.domain.dto.PaymentMethodDTO;
import com.pay.process.PaymentProcessingService.domain.entities.PaymentMethodEntity;
import com.pay.process.PaymentProcessingService.mappers.Mapper;

@Component
public class PaymentMethodMapperImpl implements Mapper<PaymentMethodEntity, PaymentMethodDTO> {

	
	private ModelMapper modelMapper; 
	
	
	
	
	public PaymentMethodMapperImpl(ModelMapper modelMapper) {
		this.modelMapper = modelMapper;
	}

	@Override
	public PaymentMethodDTO mapTo(PaymentMethodEntity a) {
		// TODO Auto-generated method stub
		return modelMapper.map(a, PaymentMethodDTO.class);
	}

	@Override
	public PaymentMethodEntity mapFrom(PaymentMethodDTO b) {
		// TODO Auto-generated method stub
		return modelMapper.map(b, PaymentMethodEntity.class);
	}

}
