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
public UUID getId() {
	return id;
}
public void setId(UUID id) {
	this.id = id;
}
public UUID getUser_id() {
	return user_id;
}
public void setUser_id(UUID user_id) {
	this.user_id = user_id;
}
public UUID getMerchant_id() {
	return merchant_id;
}
public void setMerchant_id(UUID merchant_id) {
	this.merchant_id = merchant_id;
}
public TransactionGateway getGateway() {
	return gateway;
}
public void setGateway(TransactionGateway gateway) {
	this.gateway = gateway;
}
public TransactionMethod getMethod() {
	return method;
}
public void setMethod(TransactionMethod method) {
	this.method = method;
}
public TransactionStatus getStatus() {
	return status;
}
public void setStatus(TransactionStatus status) {
	this.status = status;
}
public Integer getAmount_cents() {
	return amount_cents;
}
public void setAmount_cents(Integer amount_cents) {
	this.amount_cents = amount_cents;
}
public Double getCurrency() {
	return currency;
}
public void setCurrency(Double currency) {
	this.currency = currency;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public String getMetadata() {
	return metadata;
}
public void setMetadata(String metadata) {
	this.metadata = metadata;
}
public LocalDateTime getCreated_at() {
	return created_at;
}
public void setCreated_at(LocalDateTime created_at) {
	this.created_at = created_at;
}
public LocalDateTime getUpdated_at() {
	return updated_at;
}
public void setUpdated_at(LocalDateTime updated_at) {
	this.updated_at = updated_at;
}
  
  
  

}