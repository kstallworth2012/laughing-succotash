package com.pay.process.PaymentProcessingService.domain.entities;

import java.time.LocalDateTime;
import java.util.UUID;

import com.pay.process.PaymentProcessingService.enums.TransactionGateway;
import com.pay.process.PaymentProcessingService.enums.TransactionMethod;
import com.pay.process.PaymentProcessingService.enums.TransactionStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
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
@Table(name = "transaction") 
public class TransactionEntity{
  
  @Id
  private UUID  id; // UUID PRIMARY KEY,
  private UUID user_id; //UUID NOT NULL,
  private UUID merchant_id; // UUID NOT NULL,
  @Enumerated(EnumType.STRING)
  private TransactionGateway gateway; // VARCHAR NOT NULL,         -- e.g., 'stripe', 'paypal'
  @Enumerated(EnumType.STRING)
  private TransactionMethod method; // VARCHAR NOT NULL,          -- e.g., 'card', 'ideal'
  @Enumerated(EnumType.STRING)
  private TransactionStatus status; // VARCHAR NOT NULL,          -- 'pending', 'authorized', 'captured', 'refunded'
  private Integer amount_cents; // INTEGER NOT NULL,
  private Double currency; // VARCHAR NOT NULL,
  private String description; // TEXT,
  private String metadata; // JSONB,
  private LocalDateTime created_at; // TIMESTAMP NOT NULL,
  private LocalDateTime updated_at; // TIMESTAMP

}