package com.pay.process.PaymentProcessingService.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.pay.process.PaymentProcessingService.domain.entities.TransactionEntity;

public interface TransactionService {
	
	TransactionEntity create(TransactionEntity _transaction);
	TransactionEntity save(TransactionEntity _transactionEntity);
	List<TransactionEntity> findAll();
	Page<TransactionEntity> findAll(Pageable pageable);
	Optional<TransactionEntity> findOne(UUID id);
	boolean isExists(UUID id);
	TransactionEntity partialUpdate(UUID _id, TransactionEntity _transaction);
	void delete(UUID _id);

}
