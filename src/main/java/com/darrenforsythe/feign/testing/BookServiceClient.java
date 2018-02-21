package com.darrenforsythe.feign.testing;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class BookServiceClient  {

	@Autowired
	@LoadBalanced
	private RestTemplate restTemplate;
	
	

	public Map<String, String> getBook() {
		return restTemplate.getForObject("", Map.class);
	}
}