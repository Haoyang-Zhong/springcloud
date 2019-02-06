package com.example.feign;


import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {


	@Autowired
	private TestServiceZuul testServiceZuul;

	@RequestMapping("/ti-zuul")
	public Object ti_zuul() {
		return testServiceZuul.indexService();
	}
}
