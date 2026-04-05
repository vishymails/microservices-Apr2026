package com.bvr.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import com.bvr.models.TradeEvent;

@Service
public class StockService {
	 @Autowired private ApplicationEventPublisher publisher;

	    @EventListener
	    public void reserveStock(TradeEvent event) {
	        if ("PAID".equals(event.getStatus())) {
	            // BA Rule: Simulate failure if ticker is 'OUT'
	            if ("OUT".equalsIgnoreCase(event.getStockTicker())) {
	                System.out.println("[Stock Service] Step 3: Stock Unavailable for " + event.getStockTicker());
	                publisher.publishEvent(new TradeEvent(event.getOrderId(), "ROLLBACK_PAYMENT", event.getAmount(), event.getStockTicker()));
	            } else {
	                System.out.println("[Stock Service] Step 3: Stock Reserved.");
	                publisher.publishEvent(new TradeEvent(event.getOrderId(), "SUCCESS", event.getAmount(), event.getStockTicker()));
	            }
	        }
	    }
}
