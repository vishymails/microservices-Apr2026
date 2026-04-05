package com.bvr.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.bvr.utils.FeignServiceUtils;


@RestController
@RequestMapping("/feigndemo")
public class FeignController {
    
    public FeignController() {
        // TODO Auto-generated constructor stub
    }

    @Autowired
    private FeignServiceUtils feignServiceUtils;

    @GetMapping("/customer-servicename")
    public String getCustomerServiceName() {
        return feignServiceUtils.getServiceName();
    }

    @GetMapping("/customer-serviceaddress")
    public String getCustomerServiceAddress() {
        return feignServiceUtils.getServiceAddress();
    }

    @GetMapping("/customer-servicedetails")
    public String getCustomerServiceDetails() {
        return feignServiceUtils.getServiceDetails();
    }


}
