package com.pay.process.PaymentProcessingService.domain.entities;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "transactionLog")
public class TransactionLogEntity {

	
	
	  private UUID transaction_log_id; //PRIMARY KEY,
	  private TransactionEntity transaction_id; // UUID REFERENCES Transaction(id),
	  //event VARCHAR NOT NULL,           -- 'initiated', 'authorized', 'captured', 'refunded'
	  private LocalDateTime timestamp; // TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	  private String metadata;// JSONB
}
