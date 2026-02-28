package com.pay.process.PaymentProcessingService.mappers.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.pay.process.PaymentProcessingService.domain.dto.MerchantDTO;
import com.pay.process.PaymentProcessingService.domain.entities.MerchantEntity;
import com.pay.process.PaymentProcessingService.mappers.Mapper;

@Component
public class MerchantMapperImpl implements Mapper<MerchantEntity, MerchantDTO> {

	
	
	private ModelMapper modelMapper;
	
	
	
	public MerchantMapperImpl(ModelMapper modelMapper) {
		this.modelMapper = modelMapper;
	}

	@Override
	public MerchantDTO mapTo(MerchantEntity a) {
		// TODO Auto-generated method stub
		return modelMapper.map(a, MerchantDTO.class);
	}

	@Override
	public MerchantEntity mapFrom(MerchantDTO b) {
		// TODO Auto-generated method stub
		return modelMapper.map(b, MerchantEntity.class);
	}

}
