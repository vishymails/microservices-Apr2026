package com.bvr;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/consumer")
public class SecondController {

	public SecondController() {
		// TODO Auto-gener
		//ated constructor stub
	}
	

	@GetMapping("/message")
	public String getMessage() {
		return "Hello, API Gateway called in Second Service!";
	}
	

}
