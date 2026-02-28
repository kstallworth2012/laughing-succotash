package com.pay.process.PaymentProcessingService.mappers.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.pay.process.PaymentProcessingService.domain.dto.TransactionDTO;
import com.pay.process.PaymentProcessingService.domain.entities.TransactionEntity;
import com.pay.process.PaymentProcessingService.mappers.Mapper;


@Component
public class TransactionMapperImpl implements Mapper<TransactionEntity, TransactionDTO> {

	private ModelMapper modelMapper; 
	
	@Override
	public TransactionDTO mapTo(TransactionEntity a) {
		// TODO Auto-generated method stub
		return modelMapper.map(a, TransactionDTO.class);
	}

	@Override
	public TransactionEntity mapFrom(TransactionDTO b) {
		// TODO Auto-generated method stub
		return modelMapper.map(b, TransactionEntity.class);
	}

}
