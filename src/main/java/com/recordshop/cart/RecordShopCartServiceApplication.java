package com.recordshop.cart;

import feign.RequestInterceptor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@EnableFeignClients
@SpringBootApplication
@EnableEurekaClient
public class RecordShopCartServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RecordShopCartServiceApplication.class, args);
	}

	@Bean
	@LoadBalanced
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

	@Bean
	public RequestInterceptor requestInterceptor() {
		return requestTemplate -> {
			requestTemplate.header("Authorization", "Bearer " + "eyJraWQiOiJiZjJiYzAzYi00MmI2LTQwYzktOTAzZi1jNmFlOWVlYjAzMjYiLCJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJzdWIiOiJ1c2VyQGdtYWlsLmNvbSIsImF1ZCI6InJlY29yZC1zaG9wLWNsaWVudCIsIm5iZiI6MTYxOTQzODczNywic2NvcGUiOlsiY2F0YWxvZy5yZWFkIiwiY2FydC53cml0ZSJdLCJpc3MiOiJodHRwOlwvXC8xMjcuMC4wLjE6OTAwMCIsImV4cCI6MTYxOTUyNTEzNywiaWF0IjoxNjE5NDM4NzM3LCJqdGkiOiIyMTlmODRiMy0zNDM3LTRmMjgtODM3ZC01ZjA4OGMwZDBkOGIifQ.rSK2FlLkrCUPcVjysKAk41WTVUkWi0Gf_Sy0ct4oD80l3-LFrIRbWKeVV3rBE1-ZHMS18aTES6yp3r4RdT5YJkKKbwF3iKq6M8amzXZCSFKJ4IUyAn1hqX23c69XompTJtfP89TQ-67V8z0XI-KluUni4SxPaJaEkR5IKG2Fc71IE6pTT3x1QWw8__y-cksTg5oX-91Whrc6AJdggS3XfSn0ucLrNyjRL4GHmqvs9BHqxlrqhVNS1tXGd7ahBzIMtCfrhUARpcF4erF-EXMVvlgxDvCf7MCyLBF8lMON0y3BMM1wtoqwqnL0jtjUxr90NoodqaevtH8t3_x8taa5IA");
		};
	}
}
