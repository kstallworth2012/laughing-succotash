package com.pay.process.PaymentProcessingService.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.pay.process.PaymentProcessingService.domain.entities.PaymentMethodEntity;

public interface PaymentMethodService {
	
	
	PaymentMethodEntity create(PaymentMethodEntity _paymentMethod);
	PaymentMethodEntity save(PaymentMethodEntity _paymentMethodEntity);
	List<PaymentMethodEntity> findAll();
	Page<PaymentMethodEntity> findAll(Pageable pageable);
	Optional<PaymentMethodEntity> findOne(UUID id);
	boolean isExists(UUID id);
	PaymentMethodEntity partialUpdate(UUID _id, PaymentMethodEntity _paymentMethod);
	void delete(UUID _id);

}
