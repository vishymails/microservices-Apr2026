package com.bvr.services;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import com.bvr.models.TradeEvent;

@Service
public class OrderService {
	@Autowired private ApplicationEventPublisher publisher;

    public String createOrder(String ticker, Double amount) {
        String orderId = UUID.randomUUID().toString().substring(0, 8);
        System.out.println("[Order Service] Step 1: Initiating Order " + orderId);
        
        // Start Saga
        publisher.publishEvent(new TradeEvent(orderId, "PENDING", amount, ticker));
        return "Transaction Initiated: " + orderId;
    }

    @EventListener
    public void handleSagaEnd(TradeEvent event) {
        if ("SUCCESS".equals(event.getStatus())) {
            System.out.println("[Order Service] FINAL: Trade " + event.getOrderId() + " is CLOSED (Success).");
        } else if ("COMPENSATED".equals(event.getStatus())) {
            System.out.println("[Order Service] FINAL: Trade " + event.getOrderId() + " is CLOSED (Refunded/Failed).");
        }
    }
}
