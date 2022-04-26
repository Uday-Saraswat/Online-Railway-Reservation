package com.casestudy.uday;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class IUPService {

	public static void main(String[] args) {
		SpringApplication.run(IUPService.class, args);
	}

}
















//Important points

// not able to sign up using same username
// password validation
//make sure jwt expires after 30 mins
//role based authorization using jwt
//email validation