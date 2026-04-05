package com.bvr;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class DemoController {

	public DemoController() {
		// TODO Auto-generated constructor stub
	}

	@GetMapping("/servicename")
	public String getServiceName() {
		return "Welcome Oracle India to the Feign Demo Service";
	}

	@GetMapping("/serviceaddress")
	public String getServiceAddress() {
		return "123 Main Street, Oracle India";
	}

	@GetMapping("/servicedetails")
	public String getServiceDetails() {
		return "This is the Feign Demo Serviceruns on 8081 port and it is used to demonstrate the Feign Client in Spring Boot";
	}

}
