package com.pay.process.PaymentProcessingService.repositories;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.pay.process.PaymentProcessingService.domain.entities.PaymentMethodEntity;


@Repository
public interface PaymentMethodRepository
		extends CrudRepository<PaymentMethodEntity, UUID>, PagingAndSortingRepository<PaymentMethodEntity, UUID> {

}
