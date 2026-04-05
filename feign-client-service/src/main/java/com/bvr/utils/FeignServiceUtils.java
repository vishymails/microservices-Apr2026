package com.bvr.utils;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;


@FeignClient(value = "feigndemo", url="http://localhost:8081/user")
public interface FeignServiceUtils {
	
	@GetMapping("/servicename")
    public String getServiceName();

    @GetMapping("/serviceaddress")
    public String getServiceAddress();

    @GetMapping("/servicedetails")
    public String getServiceDetails();


}
