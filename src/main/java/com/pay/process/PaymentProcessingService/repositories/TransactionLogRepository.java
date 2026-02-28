package com.pay.process.PaymentProcessingService.repositories;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.pay.process.PaymentProcessingService.domain.entities.TransactionLogEntity;

@Repository
public interface TransactionLogRepository
		extends CrudRepository<TransactionLogEntity, UUID>, PagingAndSortingRepository<TransactionLogEntity, UUID> {

}
