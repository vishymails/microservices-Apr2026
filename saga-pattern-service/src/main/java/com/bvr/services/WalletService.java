package com.bvr.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import com.bvr.models.TradeEvent;

@Service
public class WalletService {
	 @Autowired private ApplicationEventPublisher publisher;

	    @EventListener
	    public void processPayment(TradeEvent event) {
	        if ("PENDING".equals(event.getStatus())) {
	            System.out.println("[Wallet Service] Step 2: Reserving $" + event.getAmount());
	            // In a real app, check DB balance here
	            publisher.publishEvent(new TradeEvent(event.getOrderId(), "PAID", event.getAmount(), event.getStockTicker()));
	        } 
	        else if ("ROLLBACK_PAYMENT".equals(event.getStatus())) {
	            System.out.println("[Wallet Service] COMPENSATING: Refunding $" + event.getAmount());
	            publisher.publishEvent(new TradeEvent(event.getOrderId(), "COMPENSATED", event.getAmount(), event.getStockTicker()));
	        }
	    }}

