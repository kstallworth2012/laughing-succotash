package com.pay.process.PaymentProcessingService.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.pay.process.PaymentProcessingService.domain.entities.TransactionEntity;
import com.pay.process.PaymentProcessingService.repositories.TransactionRepository;
import com.pay.process.PaymentProcessingService.services.TransactionService;


@Service
public class TransactionServiceImpl implements TransactionService {
	
	
	private TransactionRepository transactionRepository;
	
	
	
	

	public TransactionServiceImpl(TransactionRepository transactionRepository) {
		this.transactionRepository = transactionRepository;
	}

	@Override
	public TransactionEntity create(TransactionEntity _transaction) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TransactionEntity save(TransactionEntity _transactionEntity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TransactionEntity> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<TransactionEntity> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<TransactionEntity> findOne(UUID id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public boolean isExists(UUID id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public TransactionEntity partialUpdate(UUID _id, TransactionEntity _transaction) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(UUID _id) {
		// TODO Auto-generated method stub

	}

}
