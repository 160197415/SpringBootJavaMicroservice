package com.tsi.abbas.gure.program.Controllers;

import com.tsi.abbas.gure.program.CountryPackage.Country;
import com.tsi.abbas.gure.program.CountryPackage.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
;import org.springframework.web.bind.annotation.*;

public class CountryController {

    //Country repository instantiated
    @Autowired
    private CountryRepository countryRepository;


    /**This is for getting all the contents of the Country from the country table in the Sakila database
     * More specifically in terms of CRUD functions this is the 'Read'*/
    @GetMapping("/All_Countries")
    public @ResponseBody
    Iterable<Country> getAllCountries(){
        return countryRepository.findAll();
    }

    /**
     *
     * @param countryID is the ID of the film that is used as parameter for searching for Country's existence in table
     * @return true if the film exists else return false, a simple boolean class for existence of country's ID
     */
    @GetMapping("/Countries/IdExist")
    public @ResponseBody Boolean idExists(@RequestParam int countryID){
        if (countryRepository.existsById(countryID)){
            return true ;
        }else return false ;
    }


    /**Out of the CRUD functions this is the 'Delete' */
    @DeleteMapping("/Delete_By_ID")
    public @ResponseBody
    String deleteById(@RequestParam int countryID){

        countryRepository.deleteById(countryID);
        return "Successfully deleted";
    }


    /**Out of the CRUD functions this is the 'Update' Method */
    @PutMapping("/Replace_By_ID")
    public @ResponseBody String updateCountry(@RequestParam int countryID ,@RequestParam String countryName)
    {
        //A string we will use later as a message that values were successfully updated, you'll see it below
        String valueWasUpdated = "Values were updated";


        //using crud repository method that we got from extended class, look for id of Country exists in the database
        if(countryRepository.existsById(countryID)){
            // if it does find the specific ID in the database using the ID of the country and put it in a temp replaceCountryvalue
            Country replaceCountry = new Country();

            //Find Country ID
            replaceCountry = countryRepository.findById(countryID).get();

            //Once finding Country user inputs relevant values to country variables
            replaceCountry.setCountryName(countryName);


            //Repository save/updates the country detail changes.
            countryRepository.save(replaceCountry);

        } else {
            //If we do not find the country in the repository or if they do not exist
            valueWasUpdated = "ID not found";
        }
        //Basically by this point we updated the value if correctly found
        return valueWasUpdated;


    }

    /**Out of the CRUD functions this is the 'Create' */
    @PostMapping("/Create_By_ID")
    public  @ResponseBody Country newCountry(@RequestParam String countryName)
    {
        //Country instance that we will use for our new country
        Country country = new Country();

        /** I didn't add id variable to be created/updated because it is auto-incrementally added by the database,
         * if I do add id it would not create/update with the save method */


        //Setting the new country fields
        //Then returning the value to user along with the ID they were assigned by the table
        country.setCountryName(countryName);
        return countryRepository.save(country);
    }
}
