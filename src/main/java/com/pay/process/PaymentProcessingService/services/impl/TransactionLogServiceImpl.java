package com.pay.process.PaymentProcessingService.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.pay.process.PaymentProcessingService.domain.entities.TransactionLogEntity;
import com.pay.process.PaymentProcessingService.repositories.TransactionLogRepository;
import com.pay.process.PaymentProcessingService.services.TransactionLogService;


@Service
public class TransactionLogServiceImpl implements TransactionLogService {

	
	private TransactionLogRepository _transactionLogRepository;
	
	
	
	
	public TransactionLogServiceImpl(TransactionLogRepository _transactionLogRepository) {
		this._transactionLogRepository = _transactionLogRepository;
	}

	@Override
	public TransactionLogEntity create(TransactionLogEntity _transactionLog) {
		// TODO Auto-generated method stub
		return _transactionLogRepository.save(_transactionLog);
	}

	@Override
	public TransactionLogEntity save(TransactionLogEntity _transactionLogEntity) {
		// TODO Auto-generated method stub
		return _transactionLogRepository.save(_transactionLogEntity);
	}

	@Override
	public List<TransactionLogEntity> findAll() {
		// TODO Auto-generated method stub
		return StreamSupport.stream(_transactionLogRepository.findAll()
				.spliterator(),false)
					.collect(Collectors.toList());
	}

	@Override
	public Page<TransactionLogEntity> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return _transactionLogRepository.findAll(pageable);
	}

	@Override
	public Optional<TransactionLogEntity> findOne(UUID id) {
		// TODO Auto-generated method stub
		return _transactionLogRepository.findById(id);
	}

	@Override
	public boolean isExists(UUID id) {
		// TODO Auto-generated method stub
		return _transactionLogRepository.existsById(id);
	}

	@Override
	public TransactionLogEntity partialUpdate(UUID _id, TransactionLogEntity _transactionLog) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(UUID _id) {
		// TODO Auto-generated method stub
		_transactionLogRepository.deleteById(_id);
	}

}
