package com.antoniorizerio.workshopmongo;

import java.util.Date;
import java.util.TimeZone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import jakarta.annotation.PostConstruct;

@SpringBootApplication
public class WorkshopSpringMogodbApplication {

	public static void main(String[] args) {
		SpringApplication.run(WorkshopSpringMogodbApplication.class, args);
	}
	
	@PostConstruct
    public void init(){
      // Setting Spring Boot SetTimeZone
      TimeZone.setDefault(TimeZone.getTimeZone("GMT"));
      System.out.println("Date in GMT: " + new Date().toString());
    }

}
