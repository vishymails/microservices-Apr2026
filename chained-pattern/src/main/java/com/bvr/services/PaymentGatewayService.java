package com.bvr.services;

import com.bvr.models.PaymentContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class PaymentGatewayService {

	public PaymentGatewayService() {
		// TODO Auto-generated constructor stub
	}
	
	
	@Autowired
	private CurrencyConverterService currencyConverterService;

	public PaymentContext initiate(Double amount, String currency){
		PaymentContext context = new PaymentContext();
		context.setTransactionId("TXN-" + System.currentTimeMillis());
		context.setAmount(amount);
		context.setCurrency(currency);
		context.getAuditlogs().add("Service A - Payment initiated with amount : " + amount + " " + currency);
		return currencyConverterService.convertCurrency(context);
	}
}
