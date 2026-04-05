package com.bvr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bvr.services.OrderService;

@RestController
@RequestMapping("/api/saga")
class SagaController {
    @Autowired 
    private OrderService orderService;

    @PostMapping("/trade")
    public String startTrade(@RequestParam String ticker, @RequestParam Double amount) {
        return orderService.createOrder(ticker, amount);
    }
}