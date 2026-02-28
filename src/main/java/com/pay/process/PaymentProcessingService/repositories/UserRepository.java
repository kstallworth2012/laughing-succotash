package com.pay.process.PaymentProcessingService.repositories;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.pay.process.PaymentProcessingService.domain.entities.UserEntity;


@Repository
public interface UserRepository extends CrudRepository<UserEntity, UUID>, PagingAndSortingRepository<UserEntity, UUID> {

}
