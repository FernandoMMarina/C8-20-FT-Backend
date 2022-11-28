package com.c820ftjavareact.ecommerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.TimeZone;

@SpringBootApplication
public class ECommerceApplication {
	//@PostConstruct
	//public void init(){
		//TimeZone.setDefault(TimeZone.getTimeZone("UTC-03:00"));
	//}

	public static void main(String[] args) {
		SpringApplication.run(ECommerceApplication.class, args);
	}

}