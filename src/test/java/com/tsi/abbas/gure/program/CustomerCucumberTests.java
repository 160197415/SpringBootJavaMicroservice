package com.tsi.abbas.gure.program;

import com.tsi.abbas.gure.program.CustomerPackage.Customer;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class CustomerCucumberTests {


    /**
     * @Given("I have Customer Field Details")
     * public void i_have_customer_field_details() {
     *     // Write code here that turns the phrase above into concrete actions
     *     throw new io.cucumber.java.PendingException();
     * }
     * @When("Set the Customer Id")
     * public void set_the_customer_id() {
     *     // Write code here that turns the phrase above into concrete actions
     *     throw new io.cucumber.java.PendingException();
     * }
     * @When("I set the Store Id")
     * public void i_set_the_store_id() {
     *     // Write code here that turns the phrase above into concrete actions
     *     throw new io.cucumber.java.PendingException();
     * }
     * @When("I set the First Name")
     * public void i_set_the_first_name() {
     *     // Write code here that turns the phrase above into concrete actions
     *     throw new io.cucumber.java.PendingException();
     * }
     * @When("I set the last Name")
     * public void i_set_the_last_name() {
     *     // Write code here that turns the phrase above into concrete actions
     *     throw new io.cucumber.java.PendingException();
     * }
     * @When("I set the Email")
     * public void i_set_the_email() {
     *     // Write code here that turns the phrase above into concrete actions
     *     throw new io.cucumber.java.PendingException();
     * }
     *  @When("I set the Address")
     *     public void i_set_the_address() {
    *       // Write code here that turns the phrase above into concrete actions
     *     throw new io.cucumber.java.PendingException();
     *     }
     * @Then("The Customer returns the values")
     * public void the_customer_returns_the_values() {
     *     // Write code here that turns the phrase above into concrete actions
     *     throw new io.cucumber.java.PendingException();
     * }
     */

    /**Created a dummy actor to populate values and to then test the assert values on,
     * This is to confirm my inbuilt methods in real application work */

    Customer dummyCustomer = new Customer(0,0,"","","",0);

    /**
     * Instantiate variables
     */

    int customer_id,store_id,address_id;
    String first_name, last_name,email;



    @Given("I have Customer Field Details")
    public void i_have_customer_field_details() {
        // Write code here that turns the phrase above into concrete actions

    }
    @When("Set the Customer Id")
    public void set_the_customer_id() {
        customer_id = 1;
        dummyCustomer.setCustomer_id(customer_id);
    }
    @When("I set the Store Id")
    public void i_set_the_store_id() {
        store_id = 1;
        dummyCustomer.setStore_id(store_id);
    }
    @When("I set the First Name")
    public void i_set_the_first_name() {
        first_name = "Dummy";
        dummyCustomer.setFirst_name(first_name);
    }
    @When("I set the last Name")
    public void i_set_the_last_name() {
        last_name = "Customer";
        dummyCustomer.setLast_name(last_name);
    }
    @When("I set the Email")
    public void i_set_the_email() {
        email = "dummycustomer@tsi.com";
        dummyCustomer.setEmail(email);
    }

    @When("I set the Address")
    public void i_set_the_address() {
        address_id= 1;
        dummyCustomer.setAddress_id(address_id);
    }
    @Then("The Customer returns the values")
    public void the_customer_returns_the_values() {
        Customer expected = new Customer(1,1,"Dummy","Customer","dummycustomer@tsi.com",1);

        Assertions.assertEquals(expected.getCustomer_id(),dummyCustomer.getCustomer_id(), "Customer Id do not match");
        Assertions.assertEquals(expected.getStore_id(),dummyCustomer.getStore_id(), "Store Id do not match");
        Assertions.assertEquals(expected.getFirst_name(),dummyCustomer.getFirst_name(), "Customer first_name do not match");
        Assertions.assertEquals(expected.getLast_name(),dummyCustomer.getLast_name(), "Customer last_name do not match");
        Assertions.assertEquals(expected.getEmail(),dummyCustomer.getEmail(), "Customer Email do not match");
        Assertions.assertEquals(expected.getAddress_id(),dummyCustomer.getAddress_id(), "Customer Address do not match");
    }
}
