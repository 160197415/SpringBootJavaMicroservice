package com.tsi.abbas.gure.program.Controllers;

import com.tsi.abbas.gure.program.ActorPackage.ActorRepository;
import com.tsi.abbas.gure.program.FilmActorPackage.FilmActorRepository;
import com.tsi.abbas.gure.program.FilmActorPackage.FilmActor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
public class filmActorController {


    //Film Actor repository instantiated
    @Autowired
    private FilmActorRepository filmActorRepository;

    public filmActorController(FilmActorRepository filmActorRepository){this.filmActorRepository=filmActorRepository ;}


    /**This is for getting all the film actors from the film actor table in the sakila database
     * More specifically in terms of CRUD functions this is the 'Read'*/
    @GetMapping("/All_FilmActors")
    public @ResponseBody
    Iterable<FilmActor> getAllFilmActors(){
        return filmActorRepository.findAll();
    }

    /**
     *
     * @param actor_id is the ID of the film actor that is used as parameter for searching for actor's existence in table
     * @return true if the actor exists else return false, a simple boolean class for existence of Actor's ID
     */
    @GetMapping("/FilmActor/IdExist")
    public @ResponseBody Boolean idExists(@RequestParam int actor_id){
        return filmActorRepository.existsById(actor_id);


    }

    /**Out of the CRUD functions this is the 'Delete' */
    @DeleteMapping("/Delete_By_FilmActor_ID")
    public @ResponseBody
    String deleteById(@RequestParam int actor_id){

        filmActorRepository.deleteById(actor_id);
        return "Successfully deleted";
    }

    /* Commented out the following as the film-actor database is a 3NF and thus shouldn't be edited externally
    Out of the CRUD functions this is the 'Update' Method
/*   @PutMapping("/Replace_By_FilmActor_ID")
//    public @ResponseBody String updateFilmActor(@RequestParam int actor_id ,@RequestParam int film_id)
//    {
//        //A string we will use later as a message that values were successfully updated, you'll see it below
//        String valueWasUpdated = "Values were updated";
//
//
//        //using crud repository method that we got from extended class, check if id of FilmActor exists in the database
//        if(filmActorRepository.existsById(actor_id)){
//            // if it does find the specific ID in the database using the ID of the actor and put it in a temp store value
//            FilmActor filmActor = new FilmActor();
//
//            //get Actor by ID
//            filmActor = filmActorRepository.findById(actor_id).get();
//
//            //Once finding actor user updates relevant values for the film actor's variables
//            filmActor.setFilm_id(film_id);
//
//            //Repository save/updates the store detail changes.
//            filmActorRepository.save(filmActor);
//
//        } else {
//            //If we do not find the filmactor in the repository or if they do not exist
//            valueWasUpdated = "ID not found";
//        }
//        //Basically by this point we updated the value if correctly found
//        return valueWasUpdated;
//
//
//    }
////
//
//    /**Out of the CRUD functions this is the 'Create' */
//    @PostMapping("/Create_By_FilmActor_ID")
//    public  @ResponseBody FilmActor newFilmActor(  @RequestParam int actor_id,@RequestParam int film_id)
//    {
//        //Instance that we will use for our new film actor
//        FilmActor filmActor = new FilmActor();
//
//        /** I didn't add id variable to be created/updated because it is auto incrementally added by the database,
//         * if I do add id it would not create/update with the save method */
//
//
//        //Setting Stores values
//        //Then returning the value to user along with the ID they were assigned by the table
//        filmActor.setActor_id(actor_id);
//        filmActor.setFilm_id(film_id);
//        return filmActorRepository.save(filmActor);
//    }


}
