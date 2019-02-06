package com.example.zuul;


import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.logging.Logger;

@Component
@Slf4j
public class AuthFilter extends ZuulFilter {

//	private static Logger log = Logger.getLogger(AuthFilter.class.toString());

	@Override
	public String filterType() {
		return "pre";
	}

	@Override
	public int filterOrder() {
		return 0;
	}

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public Object run() throws ZuulException {
		RequestContext ctx = RequestContext.getCurrentContext();
		HttpServletRequest request = ctx.getRequest();
		log.info(String.format("header-token:%s, param-token:%s", request.getHeader("token"), request.getParameter("token")));
		String token_header = request.getHeader("token") == null? "":request.getHeader("token");
		String token_param = request.getParameter("token") == null ? "" :
																request.getParameter("token");
		if (token_header.equals("") && token_param.equals("")) {
			try {
				ctx.setSendZuulResponse(false);
				ctx.getResponse().getWriter().write("{\"code\": 9999,\"message\": \"token is empty.\"}");
			} catch (IOException e) {
				log.error("System error");
			}
		} else if (!token_header.equals("")) {
			log.info(String.format("token is %s", token_header));
		} else if (!token_param.equals("")) {
			log.info(String.format("token is %s", token_param));
		}
		return null;
 	}
}
