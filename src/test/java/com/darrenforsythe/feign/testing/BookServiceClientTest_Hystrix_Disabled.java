package com.darrenforsythe.feign.testing;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.netflix.client.ClientException;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("ribbon")
public class BookServiceClientTest_Hystrix_Disabled {

	@MockBean
	@LoadBalanced
	RestTemplate restTemplate;// <---- @LoadBalanced bean

	@Autowired
	private BookAPI bookServiceClient;

	@Test
	public void fallbackTest() {
		assertThatThrownBy(() -> bookServiceClient.getBook()).hasRootCauseInstanceOf(ClientException.class);// <--- I thought this
																								// should work
	}
}