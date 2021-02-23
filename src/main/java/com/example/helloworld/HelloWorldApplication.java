package com.example.helloworld;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class HelloWorldApplication {

	@RequestMapping("/")
	public String getMethodName() {
		
		return "Hello k8s at: " + getTime() ;
	}

	public String getTime() {
		return java.time.LocalTime.now() + "";
	} 

	public static void main(String[] args) {
		SpringApplication.run(HelloWorldApplication.class, args);
	}

}

