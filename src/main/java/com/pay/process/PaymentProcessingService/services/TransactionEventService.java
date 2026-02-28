package com.pay.process.PaymentProcessingService.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.pay.process.PaymentProcessingService.domain.entities.TransactionEventEntity;

public interface TransactionEventService {

	
	TransactionEventEntity create(TransactionEventEntity _transactionEvent);
	TransactionEventEntity save(TransactionEventEntity _transactionEventEntity);
	List<TransactionEventEntity> findAll();
	Page<TransactionEventEntity> findAll(Pageable pageable);
	Optional<TransactionEventEntity> findOne(UUID id);
	boolean isExists(UUID id);
	TransactionEventEntity partialUpdate(UUID _id, TransactionEventEntity _TransactionEvent);
	void delete(UUID _id);
}
