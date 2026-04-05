package com.bvr;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	public HomeController() {
		// TODO Auto-generated constructor stub
	}
	
	@GetMapping("/")
	public String home() {
		return "Welcome to the Home Page! - Oracle Bangalore";
	}
	
	@GetMapping("/secured")
	public String secured() {
		return "Hello secured Data from Oauth Server application";
	}
	
}
