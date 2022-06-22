package com.tsi.abbas.gure.program;

import com.tsi.abbas.gure.program.CountryPackage.Country;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class CountryCucumberTests {


    /**Created a dummy Country to populate values and to then test assert values on,
     * This is to confirm my inbuilt methods in real application work */

    Country dummyCountry = new Country("");

    /** The Values I will assign test values for below */
    String country;


    @Given("I have a Country Details")
    public void i_have_a_country_details() {
        country = "AsianCountry";
    }
    @When("Set the Country name")
    public void set_the_country_name() {
        dummyCountry.setCountry(country);
    }
    @Then("The Country returns the name")
    public void the_country_returns_the_name() {
       Assertions.assertEquals(country,dummyCountry.getCountry(), "Incorrect Country Name between the two values");
    }
}
