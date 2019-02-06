package com.example.zuul;


import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HystrixConfiguration {

	@Bean(name = "hystrixRegistrationBean")
	public ServletRegistrationBean servletRegistrationBean() {
		ServletRegistrationBean registrationBean = new ServletRegistrationBean(
				new HystrixMetricsStreamServlet(), "/hystrix.stream"
		);
		registrationBean.setName("hystrixServlet");
		registrationBean.setLoadOnStartup(1);
		return registrationBean;
	}

	@Bean(name = "hystrixForTurbineRegistrationBean")
	public ServletRegistrationBean servletTurbineRegistrationBean() {
		ServletRegistrationBean registrationBean = new ServletRegistrationBean(
				new HystrixMetricsStreamServlet(),
				"/actuator/hystrix.stream"
		);
		registrationBean.setName("hystrixForTurbineServlet");
		registrationBean.setLoadOnStartup(1);
		return registrationBean;
	}
}
