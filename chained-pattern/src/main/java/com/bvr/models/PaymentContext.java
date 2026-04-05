package com.bvr.models;

import java.util.ArrayList;
import java.util.List;

public class PaymentContext {

	public PaymentContext() {
		// TODO Auto-generated constructor stub
	}
	
		private String transactionId;
		private Double amount;
		private String currency;
		private Double fee;
		private Double totalChargable;
		
		private List<String> auditlogs = new ArrayList<>();
		public String getTransactionId() {
			return transactionId;
		}
		public void setTransactionId(String transactionId) {
			this.transactionId = transactionId;
		}
		public Double getAmount() {
			return amount;
		}
		public void setAmount(Double amount) {
			this.amount = amount;
		}
		public String getCurrency() {
			return currency;
		}
		public void setCurrency(String currency) {
			this.currency = currency;
		}
		public Double getFee() {
			return fee;
		}
		public void setFee(Double fee) {
			this.fee = fee;
		}
		public Double getTotalChargable() {
			return totalChargable;
		}
		public void setTotalChargable(Double totalChargable) {
			this.totalChargable = totalChargable;
		}
		public List<String> getAuditlogs() {
			return auditlogs;
		}
		public void setAuditlogs(List<String> auditlogs) {
			this.auditlogs = auditlogs;
		}
		
		
	}

