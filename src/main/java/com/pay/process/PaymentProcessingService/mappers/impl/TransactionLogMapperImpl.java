package com.pay.process.PaymentProcessingService.mappers.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.pay.process.PaymentProcessingService.domain.dto.TransactionLogDTO;
import com.pay.process.PaymentProcessingService.domain.entities.TransactionLogEntity;
import com.pay.process.PaymentProcessingService.mappers.Mapper;

@Component
public class TransactionLogMapperImpl implements Mapper<TransactionLogEntity, TransactionLogDTO> {

	private ModelMapper modelMapper;
	
	
	
	public TransactionLogMapperImpl(ModelMapper modelMapper) {
		this.modelMapper = modelMapper;
	}

	@Override
	public TransactionLogDTO mapTo(TransactionLogEntity a) {
		// TODO Auto-generated method stub
		return modelMapper.map(a,TransactionLogDTO.class);
	}

	@Override
	public TransactionLogEntity mapFrom(TransactionLogDTO b) {
		// TODO Auto-generated method stub
		return modelMapper.map(b,TransactionLogEntity.class);
	}

}
