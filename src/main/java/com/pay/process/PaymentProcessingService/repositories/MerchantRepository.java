package com.pay.process.PaymentProcessingService.repositories;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.pay.process.PaymentProcessingService.domain.entities.MerchantEntity;

@Repository
public interface MerchantRepository
		extends CrudRepository<MerchantEntity, UUID>, PagingAndSortingRepository<MerchantEntity, UUID> {

}
