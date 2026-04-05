package com.bvr.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bvr.models.PaymentContext;
import com.bvr.services.PaymentGatewayService;

@RestController
@RequestMapping("/api/v1/process")
public class ChainController {

	public ChainController() {
		// TODO Auto-generated constructor stub
	}

	@Autowired 
	private PaymentGatewayService gatewayService;
	
	@PostMapping("/payment")
	public PaymentContext process(@RequestParam Double amount, @RequestParam String currency) {
		return gatewayService.initiate(amount, currency);
	}
}
