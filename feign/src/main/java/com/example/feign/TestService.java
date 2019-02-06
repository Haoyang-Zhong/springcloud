package com.example.feign;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(value = "test-service")
public interface TestService {
	@RequestMapping(value = "/", method = RequestMethod.GET)
	String indexService();

	@RequestMapping(value = "/plus", method = RequestMethod.GET)
	Result plusService(@RequestParam(name = "numA") int numA, @RequestParam(name = "numB") int numB);

	@RequestMapping(value = "/plus", method = RequestMethod.POST, consumes = "application/json")
	Result plusabService(Plus plus);

	@RequestMapping(value = "/plus2", method = RequestMethod.POST)
	Result plus2Service(@RequestBody Plus plus);
}
