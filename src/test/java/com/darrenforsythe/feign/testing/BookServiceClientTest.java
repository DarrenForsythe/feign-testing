package com.darrenforsythe.feign.testing;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BookServiceClientTest {

    @MockBean
    @LoadBalanced
    RestTemplate restTemplate;// <---- @LoadBalanced bean

    @Autowired
	private BookAPI bookServiceClient;


    @Test
    public void fallbackTest() {
        assertThat(bookServiceClient.getBook())
                .isEqualTo(new BookAPI.BookAPIFallback().getBook().get("book")); // <--- I thought this should work
    }
}