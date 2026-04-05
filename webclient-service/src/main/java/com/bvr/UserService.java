package com.bvr;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class UserService {

	
	private final WebClient webClient;

	public UserService(WebClient webClient) {
		super();
		this.webClient = webClient;
	}
	
	public Mono<String> getUserById(){
		return webClient.get().uri("/oracleblr/users").retrieve().bodyToMono(String.class);
	}
	
	public Flux<String> getUserById1(){
		return webClient.get().uri("/oracleblr/users").retrieve().bodyToFlux(String.class);
	}
	

}
