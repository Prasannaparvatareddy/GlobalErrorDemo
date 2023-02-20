package com.example.demo;

import java.util.logging.Logger;

import org.apache.commons.logging.Log;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j
public class Router {

	private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(Router.class);
	
	@Bean
	public RouterFunction<ServerResponse> routeRequest(Handler handler) {
		
	    return RouterFunctions.route().GET("/hello",
	        request -> {
				try {
					log.info("inside :: Router");
					return handler.handleRequest(request);
				} catch (Exception e) {
					log.info(" Router Exception");
					e.printStackTrace();
				}
				return ServerResponse.badRequest().body(new Object(), Object.class);
			}).build();
	    }

}
