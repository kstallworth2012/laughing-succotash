package com.pay.process.PaymentProcessingService.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.pay.process.PaymentProcessingService.domain.entities.TransactionEventEntity;
import com.pay.process.PaymentProcessingService.repositories.TransactionEventRepository;
import com.pay.process.PaymentProcessingService.services.TransactionEventService;


@Service
public class TransactionEventServiceImpl implements TransactionEventService {
	
	private TransactionEventRepository _transactionEventReposit;
	
		
	public TransactionEventServiceImpl(TransactionEventRepository _transactionEventReposit) {
		this._transactionEventReposit = _transactionEventReposit;
	}

	@Override
	public TransactionEventEntity create(TransactionEventEntity _transactionEvent) {
		// TODO Auto-generated method stub
		return _transactionEventReposit.save(_transactionEvent);
	}

	@Override
	public TransactionEventEntity save(TransactionEventEntity _transactionEventEntity) {
		// TODO Auto-generated method stub
		return _transactionEventReposit.save(_transactionEventEntity);
	}

	@Override
	public List<TransactionEventEntity> findAll() {
		// TODO Auto-generated method stub
		return StreamSupport.stream(_transactionEventReposit.findAll()
				.spliterator(),false)
					.collect(Collectors.toList());
	}

	@Override
	public Page<TransactionEventEntity> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return _transactionEventReposit.findAll(pageable);
	}

	@Override
	public Optional<TransactionEventEntity> findOne(UUID id) {
		// TODO Auto-generated method stub
		return _transactionEventReposit.findById(id);
	}

	@Override
	public boolean isExists(UUID id) {
		// TODO Auto-generated method stub
		return _transactionEventReposit.existsById(id);
	}

	@Override
	public TransactionEventEntity partialUpdate(UUID _id, TransactionEventEntity _TransactionEvent) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(UUID _id) {
		// TODO Auto-generated method stub
		_transactionEventReposit.deleteById(_id);
	}

}
