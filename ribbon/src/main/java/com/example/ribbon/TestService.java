package com.example.ribbon;


import com.netflix.discovery.converters.Auto;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.ribbon.proxy.annotation.Hystrix;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class TestService {
	@Autowired
	private RestTemplate restTemplate;

	@HystrixCommand(fallbackMethod = "indexError")
	public Object index() {
		return restTemplate.getForObject("http://test-service", String.class);
	}

	public Object plus(int numA, int numB) {
		String url = String.format("http://test-service/plus?numA=%s&numB=%s", numA, numB);
		return restTemplate.getForObject(url, String.class);
	}

	public Object indexError() {
		return "{\"code\":999,\"message\":\"server broken down\"}";
	}
}
