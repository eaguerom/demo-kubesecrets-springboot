package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("test")
public class TestController {
	
	@Value("${test.user}")
	private String userTest;
	
	@Value("${test.pass}")
	private String passTest;
	
	public TestController() { }
	
	@GetMapping
	public ResponseEntity test() {
		System.out.println("Prueba user: " + userTest + " password : " + passTest);
		return new ResponseEntity("Prueba user: " + userTest + " password : " + passTest, HttpStatus.OK);
	}
	
	@GetMapping("ping")
	  public ResponseEntity ping() {
	    return new ResponseEntity(new MessageDto("pong"), HttpStatus.OK);
	  }
}