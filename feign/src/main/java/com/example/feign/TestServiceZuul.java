package com.example.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "zuul")
public interface TestServiceZuul {

	@RequestMapping(value = "/test-service", method = RequestMethod.GET)
	String indexService();

	@RequestMapping(value = "/test-service/plus", method = RequestMethod.GET)
	Result plusService(@RequestParam(name = "numA") int numA, @RequestParam(name = "numB") int numB);


}
