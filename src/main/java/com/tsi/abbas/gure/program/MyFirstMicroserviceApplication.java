package com.tsi.abbas.gure.program;

import com.tsi.abbas.gure.program.ActorPackage.Actor;
import com.tsi.abbas.gure.program.ActorPackage.ActorRepository;
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
	private ActorRepository actorRepository;




	//Constructor for my microserviceApplication
	public MyFirstMicroserviceApplication(ActorRepository actorRepository) {
		this.actorRepository = actorRepository;
	}


	//Main method to run the springapplication, with spring boot backend functions and dependencies set up etc
	//functions that we will use throughout for our microservice application.
	public static void main(String[] args) {
		SpringApplication.run(MyFirstMicroserviceApplication.class, args);
	}



	/**This is for getting all the contents of the actors from the actor table in the sakila database
	 * More specifically in terms of CRUD functions this is the 'Read'*/
	@GetMapping("/All_Actors")
	public @ResponseBody
	Iterable<Actor> getAllActors(){
		return actorRepository.findAll();
	}

	/**
	 *
	 * @param actorId is the ID of the actor that is used as parameter for searching for actor existence in table
	 * @return true if the actor exists else return false, a simple boolean class for existence of actor ID
	 */
	@GetMapping("/actors/IdExist")
	public @ResponseBody Boolean idExists(@RequestParam int actorId){
		if (actorRepository.existsById(actorId)){
			return true ;
		}else return false ;
	}


	/**Out of the CRUD functions this is the 'Delete' */
	@DeleteMapping("/Delete_By_ID")
	public @ResponseBody
	String deleteById(@RequestParam int actorId){

		actorRepository.deleteById(actorId);
		return "Successfully deleted";
	}


	/**Out of the CRUD functions this is the 'Update' Method */
	@PutMapping("/Replace_By_ID")
	public @ResponseBody String updateActor(@RequestParam int actorId ,@RequestParam String firstName,@RequestParam String lastName)
	{
		//A string we will use later as a message that values were successfully updated, you'll see it below
		String valueWasUpdated = "Values were updated";


		//using crud respository method that we got from extended class, check if id of actor in the database exists
		if(actorRepository.existsById(actorId) && actorRepository.findById(actorId).isPresent()){
			// if it does find the specific ID in the database using the ID of the actor and put it in temp actor value
			Actor actor = new Actor();

			//Find actor ID
			actor = actorRepository.findById(actorId).get();

			//Once finding set it's values to firstName and and lastName variables a user inputs
			actor.setFirstName(firstName);
			actor.setLastName(lastName);

			//Repository save/updates the actors changes.
			actorRepository.save(actor);

		} else {
			//If we do not find actor in the repository or if they arent present
			valueWasUpdated = "ID not found";
		}
		//Basically by this point we updated the value if correctly found
		return valueWasUpdated;


	}

	/**Out of the CRUD functions this is the 'Create' */
	@PostMapping("/Create_By_ID")
	public  @ResponseBody Actor newActor(  @RequestParam String firstName,@RequestParam String lastName)
	{
		//Actor instance that we will use for our new Actor
		Actor newActor = new Actor();

		/** I didnt add id variable to be created/updated because it is autoincrementally added by the database,
		 * if I do add id it would not create/update with the save method */


		//Setting newactors first and last names
		//Then returning the value to user along with the ID they were assigned by the table
		newActor.setFirstName(firstName);
		newActor.setLastName(lastName);
		return actorRepository.save(newActor);
	}


}
