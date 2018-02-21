package com.darrenforsythe.feign.testing;

import java.util.HashMap;
import java.util.Map;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "book", fallback = BookAPI.BookAPIFallback.class)
public interface BookAPI {

	@RequestMapping("/")
	Map<String, String> getBook();

	@Component
	static class BookAPIFallback implements BookAPI {

		@Override
		@RequestMapping("/")
		public Map<String, String> getBook() {
			Map<String, String> fallbackmap = new HashMap<>();
			fallbackmap.put("book", "fallback book");
			return fallbackmap;
		}
	}


}