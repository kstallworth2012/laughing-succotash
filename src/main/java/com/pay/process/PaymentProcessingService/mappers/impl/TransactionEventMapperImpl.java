package com.pay.process.PaymentProcessingService.mappers.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.pay.process.PaymentProcessingService.domain.dto.TransactionEventDTO;
import com.pay.process.PaymentProcessingService.domain.entities.TransactionEventEntity;
import com.pay.process.PaymentProcessingService.mappers.Mapper;

@Component
public class TransactionEventMapperImpl implements Mapper<TransactionEventEntity, TransactionEventDTO> {

	
	private ModelMapper modelMapper; 
	
	
	
	public TransactionEventMapperImpl(ModelMapper modelMapper) {
		this.modelMapper = modelMapper;
	}

	@Override
	public TransactionEventDTO mapTo(TransactionEventEntity a) {
		// TODO Auto-generated method stub
		return modelMapper.map(a,TransactionEventDTO.class );
	}

	@Override
	public TransactionEventEntity mapFrom(TransactionEventDTO b) {
		// TODO Auto-generated method stub
		return modelMapper.map(b, TransactionEventEntity.class);
	}

}
