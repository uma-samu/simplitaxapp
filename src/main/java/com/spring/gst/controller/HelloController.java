package com.spring.gst.controller;




import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.spring.gst.model.Quote;


@RestController
@RequestMapping("/api")
public class HelloController {
	
	public static final String REST_SERVICE_URI = "http://gturnquist-quoters.cfapps.io/api/random";
	
	@RequestMapping("/hello")
	public String sayHello()
	{
		return "Hello, World!";
	} 
	
	@RequestMapping("/value")
	public ResponseEntity<?> getValue()
	{
		RestTemplate restTemplate = new RestTemplate();
        Quote quote = restTemplate.getForObject(REST_SERVICE_URI, Quote.class);
        System.out.println(quote);
        return new ResponseEntity<Quote>(quote, HttpStatus.OK);
	}
	
}
