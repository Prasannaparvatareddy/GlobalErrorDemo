package com.example.demo;

import javax.management.RuntimeErrorException;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Service
@Slf4j
public class Handler {
	
	private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(Handler.class);
	
	public Mono<ServerResponse> handleRequest(ServerRequest request) throws Exception {
		//String n = request.pathVariable("number");
		log.info("inside Handler :: ");
		int n =100;
		if( n == 100) {
			log.info("inside Handler :: Exception loop");
			return Mono.error(new RuntimeException("Get number api failed"));
		  //throw new RuntimeErrorException(null,"Get number api failed");
		}else {
			log.info("inside Handler :: Success loop");
			return ServerResponse.ok().body(Mono.just(new Object()),Object.class);
		}
//	    return sayHello(request)
//	      .flatMap(s -> ServerResponse.ok()
//	        .contentType(MediaType.TEXT_PLAIN)
//	        .bodyValue(s))
//	      .onErrorResume(e -> Mono.just("Error " + e.getMessage())
//	        .flatMap(s -> ServerResponse.ok()
//	          .contentType(MediaType.TEXT_PLAIN)
//	          .bodyValue(s)));
	}

	private Mono<String> sayHello(ServerRequest request) {
	    try {
	        return Mono.just("Hello, " + request.queryParam("number").get());
	    } catch (Exception e) {
	        return Mono.error(e);
	    }
	}

}
