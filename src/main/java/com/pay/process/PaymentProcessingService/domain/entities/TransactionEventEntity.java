package com.pay.process.PaymentProcessingService.domain.entities;

import java.time.LocalDateTime;
import java.util.UUID;

import com.pay.process.PaymentProcessingService.enums.TransactionEventType;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
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
@Table(name = "transactionEvent")
public class TransactionEventEntity {

	
	
	  @Id
	  private UUID transactionEvent_id;
	  @JoinColumn
	  private TransactionEntity transaction_id;
	  private TransactionEventType  event_type;
	  private String gateway_event_id; //?
	  private Integer amount_cents;
	  private LocalDateTime timestamp; 
	  private String metadata;
}
