package com.tedu.sp07;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

//@EnableCircuitBreaker//hystrix
//@EnableDiscoveryClient//向eureka注册
//@SpringBootApplication

@SpringCloudApplication//集成上面上个注解
public class Sp07RibbonApplication {
	
	@Bean
	@LoadBalanced
	public RestTemplate getRestTemplate() {
		SimpleClientHttpRequestFactory fac = new SimpleClientHttpRequestFactory();
		fac.setConnectTimeout(1000);
		fac.setReadTimeout(1000);
		return new RestTemplate(fac);
	}

	public static void main(String[] args) {
		SpringApplication.run(Sp07RibbonApplication.class, args);
	}

}
