package com.pay.process.PaymentProcessingService.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.pay.process.PaymentProcessingService.domain.entities.PaymentMethodEntity;
import com.pay.process.PaymentProcessingService.repositories.PaymentMethodRepository;
import com.pay.process.PaymentProcessingService.services.PaymentMethodService;


@Service
public class PaymentMethodServiceImpl implements PaymentMethodService {
	
	
	private PaymentMethodRepository _paymentMethodRepository;

	
	
	
	public PaymentMethodServiceImpl(PaymentMethodRepository _paymentMethodRepository) {
		this._paymentMethodRepository = _paymentMethodRepository;
	}

	@Override
	public PaymentMethodEntity create(PaymentMethodEntity _paymentMethod) {
		// TODO Auto-generated method stub
		return _paymentMethodRepository.save(_paymentMethod);
	}

	@Override
	public PaymentMethodEntity save(PaymentMethodEntity _paymentMethodEntity) {
		// TODO Auto-generated method stub
		return _paymentMethodRepository.save(_paymentMethodEntity);
	}

	@Override
	public List<PaymentMethodEntity> findAll() {
		// TODO Auto-generated method stub
		return StreamSupport.stream(_paymentMethodRepository.findAll()
				.spliterator(),false)
					.collect(Collectors.toList());
	}

	@Override
	public Page<PaymentMethodEntity> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return _paymentMethodRepository.findAll(pageable);
	}

	@Override
	public Optional<PaymentMethodEntity> findOne(UUID id) {
		// TODO Auto-generated method stub
		return _paymentMethodRepository.findById(id);
	}

	@Override
	public boolean isExists(UUID id) {
		// TODO Auto-generated method stub
		return _paymentMethodRepository.existsById(id);
	}

	@Override
	public PaymentMethodEntity partialUpdate(UUID _id, PaymentMethodEntity _paymentMethod) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(UUID _id) {
		// TODO Auto-generated method stub
		_paymentMethodRepository.deleteById(_id);
	}

}
