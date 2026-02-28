package com.pay.process.PaymentProcessingService.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.pay.process.PaymentProcessingService.domain.entities.TransactionLogEntity;

public interface TransactionLogService {
	
	TransactionLogEntity create(TransactionLogEntity _transactionLog);
	TransactionLogEntity save(TransactionLogEntity _transactionLogEntity);
	List<TransactionLogEntity> findAll();
	Page<TransactionLogEntity> findAll(Pageable pageable);
	Optional<TransactionLogEntity> findOne(UUID id);
	boolean isExists(UUID id);
	TransactionLogEntity partialUpdate(UUID _id, TransactionLogEntity _transactionLog);
	void delete(UUID _id);

}
