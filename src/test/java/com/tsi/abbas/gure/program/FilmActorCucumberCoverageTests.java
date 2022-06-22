package com.tsi.abbas.gure.program;

import com.tsi.abbas.gure.program.FilmActorPackage.FilmActor;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class FilmActorCucumberCoverageTests {

    /**
     * Instantiate dummy film actor
     */
    FilmActor dummyFilmActor = new FilmActor(0,0);

    /**
     * variables of film actor instantiated
     */

    int film_id, actor_id;


    /**
     *
     @Given("I have Film Actor Field Details")
     public void i_have_film_actor_field_details() {
     // Write code here that turns the phrase above into concrete actions
     throw new io.cucumber.java.PendingException();
     }
     @When("Set the Actor Id")
     public void set_the_actor_id() {
     // Write code here that turns the phrase above into concrete actions
     throw new io.cucumber.java.PendingException();
     }
     @When("I set the Film Id")
     public void i_set_the_film_id() {
     // Write code here that turns the phrase above into concrete actions
     throw new io.cucumber.java.PendingException();
     }
     @Then("The Film Actor returns the values")
     public void the_film_actor_returns_the_values() {
     // Write code here that turns the phrase above into concrete actions
     throw new io.cucumber.java.PendingException();
     }
     */



    @Given("I have Film Actor Field Details")
    public void i_have_film_actor_field_details() {
        // Write code here that turns the phrase above into concrete actions

    }
    @When("Set the Actor Id")
    public void set_the_actor_id() {
        actor_id = 1;
        dummyFilmActor.setActor_id(actor_id);
    }
    @When("I set the Film Id")
    public void i_set_the_film_id() {
        film_id = 2;
        dummyFilmActor.setFilm_id(film_id);
    }
    @Then("The Film Actor returns the values")
    public void the_film_actor_returns_the_values() {
        FilmActor expected = new FilmActor(1,2);

        Assertions.assertEquals(expected.getActor_id(),dummyFilmActor.getActor_id(), "Actor Id do not match");
        Assertions.assertEquals(expected.getFilm_id(),dummyFilmActor.getFilm_id(), "Film Id do not match");
    }
}
