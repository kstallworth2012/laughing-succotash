package com.pay.process.PaymentProcessingService.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.pay.process.PaymentProcessingService.domain.entities.MerchantEntity;
import com.pay.process.PaymentProcessingService.repositories.MerchantRepository;
import com.pay.process.PaymentProcessingService.services.MerchantService;


@Service
public class MerchantServiceImpl implements MerchantService {

	
	private MerchantRepository _merchantRepository;
	
	
	
	public MerchantServiceImpl(MerchantRepository _merchantRepository) {
		this._merchantRepository = _merchantRepository;
	}

	@Override
	public MerchantEntity create(MerchantEntity _merchant) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MerchantEntity save(MerchantEntity _merchantEntity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MerchantEntity> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<MerchantEntity> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<MerchantEntity> findOne(UUID id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public boolean isExists(UUID id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public MerchantEntity partialUpdate(UUID _id, MerchantEntity _Merchant) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(UUID _id) {
		// TODO Auto-generated method stub

	}

}
