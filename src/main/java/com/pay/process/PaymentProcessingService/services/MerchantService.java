package com.pay.process.PaymentProcessingService.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.pay.process.PaymentProcessingService.domain.entities.MerchantEntity;

public interface MerchantService {
	
	
	 MerchantEntity create( MerchantEntity _merchant);
	 MerchantEntity save( MerchantEntity _merchantEntity);
	List<MerchantEntity> findAll();
	Page<MerchantEntity> findAll(Pageable pageable);
	Optional<MerchantEntity> findOne(UUID id);
	boolean isExists(UUID id);
	 MerchantEntity partialUpdate(UUID _id,  MerchantEntity _Merchant);
	void delete(UUID _id);

}
