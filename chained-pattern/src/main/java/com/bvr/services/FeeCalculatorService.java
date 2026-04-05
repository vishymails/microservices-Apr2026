package com.bvr.services;

import org.springframework.stereotype.Service;

import com.bvr.models.PaymentContext;

@Service
public class FeeCalculatorService {

	public FeeCalculatorService() {
		// TODO Auto-generated constructor stub
	}
	
	public PaymentContext calculate(PaymentContext context) {
		// 2% fee
		double fee = context.getAmount() * 0.02;
		context.setFee(fee);
		context.setTotalChargable(context.getAmount() + fee);

		context.getAuditlogs().add("Service C - Fee calculated at 2% mark : " + fee);
		
		return context;
	}

}
