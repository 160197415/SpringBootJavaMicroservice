package com.tsi.abbas.gure.program.Controllers;

import com.tsi.abbas.gure.program.FilmPackage.Film;
import com.tsi.abbas.gure.program.FilmPackage.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
;import org.springframework.web.bind.annotation.*;

public class FilmController {

    //Film repository instantiated
    @Autowired
    private FilmRepository filmRepository;


    /**This is for getting all the contents of the Films from the film table in the sakila database
     * More specifically in terms of CRUD functions this is the 'Read'*/
    @GetMapping("/All_Films")
    public @ResponseBody
    Iterable<Film> getAllFilms(){
        return filmRepository.findAll();
    }

    /**
     *
     * @param filmID is the ID of the film that is used as parameter for searching for Film's existence in table
     * @return true if the film exists else return false, a simple boolean class for existence of films's ID
     */
    @GetMapping("/Films/IdExist")
    public @ResponseBody Boolean idExists(@RequestParam int filmID){
        if (filmRepository.existsById(filmID)){
            return true ;
        }else return false ;
    }


    /**Out of the CRUD functions this is the 'Delete' */
    @DeleteMapping("/Delete_By_ID")
    public @ResponseBody
    String deleteById(@RequestParam int filmID){

        filmRepository.deleteById(filmID);
        return "Successfully deleted";
    }


    /**Out of the CRUD functions this is the 'Update' Method */
    @PutMapping("/Replace_By_ID")
    public @ResponseBody String updateFilm(@RequestParam int filmID ,@RequestParam String filmTitle,
        @RequestParam int storedRentedFromID, @RequestParam int filmLength, @RequestParam int filmRating, @RequestParam int filmActorID,
                                           @RequestParam String actorName)
    {
        //A string we will use later as a message that values were successfully updated, you'll see it below
        String valueWasUpdated = "Values were updated";


        //using crud repository method that we got from extended class, look for id of Film exists in the database
        if(filmRepository.existsById(filmID)){
            // if it does find the specific ID in the database using the ID of the film and put it in a temp film value
            Film film = new Film();

            //Find Film ID
            film = filmRepository.findById(filmID).get();

            //Once finding film user inputs relevant values to film variables
            film.setFilmTitle(filmTitle);
            film.setStoredRentedFromID(storedRentedFromID);
            film.setFilmRating(filmRating);
            film.setFilmLength(filmLength);
            film.setFilmActorID(filmActorID);
            film.setActorName(actorName);

            //Repository save/updates the store detail changes.
            filmRepository.save(film);

        } else {
            //If we do not find the film in the repository or if they do not exist
            valueWasUpdated = "ID not found";
        }
        //Basically by this point we updated the value if correctly found
        return valueWasUpdated;


    }

    /**Out of the CRUD functions this is the 'Create' */
    @PostMapping("/Create_By_ID")
    public  @ResponseBody Film newFilm( @RequestParam String filmTitle,
            @RequestParam int storedRentedFromID, @RequestParam int filmLength, @RequestParam int filmRating,
            @RequestParam int filmActorID, @RequestParam String actorName)
    {
        //Actor instance that we will use for our new store
        Film film = new Film();

        /** I didn't add id variable to be created/updated because it is auto-incrementally added by the database,
         * if I do add id it would not create/update with the save method */


        //Setting the new films fields
        //Then returning the value to user along with the ID they were assigned by the table
        film.setFilmTitle(filmTitle);
        film.setStoredRentedFromID(storedRentedFromID);
        film.setFilmRating(filmRating);
        film.setFilmLength(filmLength);
        film.setFilmActorID(filmActorID);
        film.setActorName(actorName);
        return filmRepository.save(film);
    }







}
