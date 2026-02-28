package com.pay.process.PaymentProcessingService.repositories;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.pay.process.PaymentProcessingService.domain.entities.TransactionEntity;

@Repository
public interface TransactionRepository
		extends CrudRepository<TransactionEntity, UUID>, PagingAndSortingRepository<TransactionEntity, UUID> {

}
