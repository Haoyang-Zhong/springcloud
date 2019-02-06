package com.example.rabbitmq2;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/test")
public class TestController {

	@GetMapping
	public String say(){
		return "Hello World";
	}
}
