package com.tsi.abbas.gure.program;

import com.tsi.abbas.gure.program.ActorPackage.Actor;
import com.tsi.abbas.gure.program.FilmPackage.Film;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class FilmCucumberTests {



    /**Created a dummy film to populate values and to then test the asser tvalues on,
     * This is to confirm my inbuilt methods in real application work */
    Film dummyFilm = new Film(0,"",0,"",0,0);


    /** The strings I will assign  values for film instance */
    int film_id,length,language_id,original_language_id;
    String title,description;

    /**
     * Feature: Film tests
     *   Scenario: Created a dummy Film to populate values and to then test the assert values on,
     *   This is to confirm my inbuilt methods in realtime application work.
     *
     *     Given I have Field Details
     *     When Set the Film id
     *     And I set the Film title
     *     And I set the Film length
     *     And I set the Film language Id
     *     And I set the Film original language Id
     *     And I set the Film description details
     *     Then The Film returns the values
     */

    @Given("I have Field Details")
    public void i_have_field_details() {

    }
    @When("Set the Film id")
    public void set_the_film_id() {
        film_id = 1;
        dummyFilm.setFilm_id(film_id);
    }
    @When("I set the Film title")
    public void i_set_the_film_title() {
        title = "test title";
        dummyFilm.setTitle(title);
    }
    @When("I set the Film length")
    public void i_set_the_film_length() {
        length = 35;
        dummyFilm.setLength(length);
    }
    @When("I set the Film language Id")
    public void i_set_the_film_language_id() {
        language_id = 1;
        dummyFilm.setLanguage_id(language_id);
    }
    @When("I set the Film original language Id")
    public void i_set_the_film_original_language_id() {
        original_language_id = 2;
        dummyFilm.setOriginal_language_id(original_language_id);
    }
    @When("I set the Film description details")
    public void i_set_the_film_description_details() {
        description = "A dummy test title for a film";

        dummyFilm.setDescription(description);
    }
    @Then("The Film returns the values")
    public void the_film_returns_the_values() {

        Film expected = new Film(1,"test title",35,"A dummy test title for a film",1,2);

        Assertions.assertEquals(expected.getFilm_id(),dummyFilm.getFilm_id(), "Film Id in dummy and expected don't match");
        Assertions.assertEquals(expected.getDescription(),dummyFilm.getDescription(), "Description in dummy and expected don't match");
        Assertions.assertEquals(expected.getTitle(),dummyFilm.getTitle(), "Title in dummy and expected don't match");
        Assertions.assertEquals(expected.getLength(),dummyFilm.getLength(), "Length in dummy and expected don't match");
        Assertions.assertEquals(expected.getLanguage_id(),dummyFilm.getLanguage_id(), "Language Id in dummy and expected don't match");
        Assertions.assertEquals(expected.getOriginal_language_id(),dummyFilm.getOriginal_language_id(), "Original language Id in dummy and expected don't match");
    }
}
