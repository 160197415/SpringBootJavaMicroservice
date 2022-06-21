package com.tsi.abbas.gure.program;


import com.tsi.abbas.gure.program.ActorPackage.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@RestController
@RequestMapping("/home")
public class MyFirstMicroserviceApplication {






	//Constructor for my microserviceApplication
	public MyFirstMicroserviceApplication() {

	}


	//Main method to run the spring application, with spring boot backend functions and dependencies set up etc.
	//functions that we will use throughout for our microservice application.![](../../../../../../../../../../../../AppData/Local/Temp/download.jpg)
	public static void main(String[] args) {

		SpringApplication.run(MyFirstMicroserviceApplication.class, args);
	}




}
