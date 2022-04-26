package com.casestudy.uday;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.cloud.netflix.eureka.EnableEurekaClient;



@SpringBootApplication
@EnableEurekaClient
public class BookingOrderApplication {

	public static void main(String[] args) {SpringApplication.run(BookingOrderApplication.class, args);
	}


}
