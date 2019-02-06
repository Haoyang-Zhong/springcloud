package com.example.hystrixlistener;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableHystrixDashboard
@EnableDiscoveryClient
@EnableFeignClients
public class HystrixlistenerApplication {

	public static void main(String[] args) {
		SpringApplication.run(HystrixlistenerApplication.class, args);
	}

}

