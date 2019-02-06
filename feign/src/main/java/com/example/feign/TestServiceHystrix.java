package com.example.feign;

import org.bouncycastle.util.test.Test;
import org.springframework.cloud.openfeign.FeignClient;

public class TestServiceHystrix implements TestService {
	@Override
	public String indexService() {
		return "{\"code\": 999,\"message\": \"service break down\"}";
	}

	@Override
	public Result plusService(int numA, int numB) {
		Result result = new Result();
		result.setCode(999);
		result.setMessage("服务断路");
		return new Result();
	}

	@Override
	public Result plusabService(Plus plus) {
		Result result = new Result();
		result.setCode(999);
		result.setMessage("服务断路");
		return new Result();
	}

	@Override
	public Result plus2Service(Plus plus) {
		Result result = new Result();
		result.setCode(999);
		result.setMessage("服务断路");
		return new Result();
	}
}
