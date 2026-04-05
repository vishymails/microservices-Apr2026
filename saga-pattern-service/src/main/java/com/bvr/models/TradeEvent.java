package com.bvr.models;

public class TradeEvent {

	 private String orderId;
	 private String status; // PENDING, SUCCESS, COMPENSATED
	 private Double amount;
	 private String stockTicker;
	 
	 
	 public TradeEvent(String orderId, String status, Double amount, String stockTicker) {
		super();
		this.orderId = orderId;
		this.status = status;
		this.amount = amount;
		this.stockTicker = stockTicker;
	 }


	 public String getOrderId() {
		 return orderId;
	 }


	 public void setOrderId(String orderId) {
		 this.orderId = orderId;
	 }


	 public String getStatus() {
		 return status;
	 }


	 public void setStatus(String status) {
		 this.status = status;
	 }


	 public Double getAmount() {
		 return amount;
	 }


	 public void setAmount(Double amount) {
		 this.amount = amount;
	 }


	 public String getStockTicker() {
		 return stockTicker;
	 }


	 public void setStockTicker(String stockTicker) {
		 this.stockTicker = stockTicker;
	 }
	    
	    
	    
}
