package com.tsi.abbas.gure.program;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@RestController
@RequestMapping("/home")
public class MyFirstMicroserviceApplication {

	@Autowired
	private ActorRepository actorRepository;





	public MyFirstMicroserviceApplication(ActorRepository actorRepository) {
		this.actorRepository = actorRepository;
	}

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

	@GetMapping("/actors/IdExist")
	public @ResponseBody Boolean idExists(@RequestParam int actorId){
		if (actorRepository.existsById(actorId)){
			return true ;
		}else return false ;
	}


	/**Out of the CRUD functions this is the 'Delete' */
	@DeleteMapping("/Delete_By_ID")
	public @ResponseBody
	String deleteById(@RequestParam int actor_id){

		actorRepository.deleteById(actor_id);
		return "Successfully deleted";
	}


	/**Out of the CRUD functions this is the 'Update' Method */
	@PutMapping("/Replace_By_ID")
	public @ResponseBody String updateActor(@RequestParam int actorId ,@RequestParam String firstName,@RequestParam String lastName)
	{

		String valueWasUpdated = "Values were updated";


		//using crud respository method that we got from extended class, check if id of actor in the database exists
		if(actorRepository.existsById(actorId) && actorRepository.findById(actorId).isPresent()){
			// if it does find the specific ID in the database using the ID of the actor and put it in temp actor value
			Actor actor = new Actor();

			actor = actorRepository.findById(actorId).get();

			actor.setFirstName(firstName);
			actor.setLastName(lastName);

			actorRepository.save(actor);

		} else {
			valueWasUpdated = "ID not found";
		}

		return valueWasUpdated;


	}

	/**Out of the CRUD functions this is the 'Create' */
	@PostMapping("/Create_By_ID")
	public  @ResponseBody Actor newActor(  @RequestParam String firstName,@RequestParam String lastName)
	{
		Actor newActor = new Actor();

		/** I didnt add id variable to be created/updated because it is autoincrementally added by the database,
		 * if I do add id it would not create/update with the save method */

		newActor.setFirstName(firstName);
		newActor.setLastName(lastName);
		return actorRepository.save(newActor);
	}


}
