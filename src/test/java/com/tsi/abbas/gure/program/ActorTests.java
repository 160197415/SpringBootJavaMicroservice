package com.tsi.abbas.gure.program;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class ActorTests {

    /**Created a dummy actor to populate values and to then test the assertvalues on,
     * This is to confirm my inbuilt methods in real application work */
    Actor dummyActor = new Actor("","");


    /** The strings I will assign test values for firstname and last name */
    String firstName, lastName;

    @Given("I have an actors information")
    public void i_have_an_actors_information() {
        // Write code here that turns the phrase above into concrete actions


    }
    @When("I have the users first name")
    public void i_have_the_users_first_name() {
        firstName = "Abbas";
        dummyActor.setFirstName(firstName);

    }
    @When("I have the users last name")
    public void i_have_the_users_last_name() {
        // Write code here that turns the phrase above into concrete actions
        lastName = "Gure";
        dummyActor.setLastName(lastName);

    }
    @When("The users first name equals {string}")
    public void the_users_first_name_equals(String string) {
        // Write code here that turns the phrase above into concrete actions
        dummyActor.firstName.equals(string);

    }
    @When("The users last name equals {string}")
    public void the_users_last_name_equals(String string) {
        // Write code here that turns the phrase above into concrete actions

       dummyActor.lastName.equals(string);


    }
    @Then("The system return {string}")
    public void the_system_return(String string) {
        // Write code here that turns the phrase above into concrete actions
        Assertions.assertEquals(firstName,dummyActor.getFirstName(),"Incorrect First Name");
        Assertions.assertEquals(lastName,dummyActor.getLastName(),"Incorrect Last Name");


    }
}
