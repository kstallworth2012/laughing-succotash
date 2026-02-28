package com.pay.process.PaymentProcessingService.repositories;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.pay.process.PaymentProcessingService.domain.entities.TransactionEventEntity;
@Repository
public interface TransactionEventRepository
		extends CrudRepository<TransactionEventEntity, UUID>, PagingAndSortingRepository<TransactionEventEntity, UUID> {

}
