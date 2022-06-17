package com.tsi.abbas.gure.program;

import com.tsi.abbas.gure.program.ActorPackage.Actor;
import com.tsi.abbas.gure.program.ActorPackage.ActorRepository;
import com.tsi.abbas.gure.program.Controllers.*;
import com.tsi.abbas.gure.program.CustomerPackage.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@RestController
@RequestMapping("/home")
public class MyFirstMicroserviceApplication {


	//Actor repository instantiated
	@Autowired
	private CompleteRepository completeRepository;




	//Constructor for my microserviceApplication
	public MyFirstMicroserviceApplication(CompleteRepository completeRepository) {

		this.completeRepository = completeRepository;
	}


	//Main method to run the springapplication, with spring boot backend functions and dependencies set up etc
	//functions that we will use throughout for our microservice application.
	public static void main(String[] args) {

		SpringApplication.run(MyFirstMicroserviceApplication.class, args);
	}

}
