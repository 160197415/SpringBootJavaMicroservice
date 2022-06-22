package com.tsi.abbas.gure.program;

import com.tsi.abbas.gure.program.StorePackage.Store;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class StoreCucumberTests {


    /**
     * @When("Set the Store Id")
     * public void set_the_store_id() {
     *     // Write code here that turns the phrase above into concrete actions
     *     throw new io.cucumber.java.PendingException();
     * }
     * @When("I set the Address Id")
     * public void i_set_the_address_id() {
     *     // Write code here that turns the phrase above into concrete actions
     *     throw new io.cucumber.java.PendingException();
     * }
     * @When("I set the Manager Staff Id")
     * public void i_set_the_manager_staff_id() {
     *     // Write code here that turns the phrase above into concrete actions
     *     throw new io.cucumber.java.PendingException();
     * }
     * @Then("The Store returns the values")
     * public void the_store_returns_the_values() {
     *     // Write code here that turns the phrase above into concrete actions
     *     throw new io.cucumber.java.PendingException();
     * }
     */

    /**
     * Creating my dummy store
     */
    Store dummyStore = new Store(0,0,0);

    int store_id,address_id,manager_staff_id;

    @Given("I have Stores information")
    public void i_have_store_information() {
        // Write code here that turns the phrase above into concrete actions


    }

    @When("Set the Store Id")
    public void set_the_store_id() {
        store_id = 1;
        dummyStore.setStore_id(store_id);
    }
    @When("I set the Address Id")
    public void i_set_the_address_id() {
       address_id = 2;
       dummyStore.setAddress_id(address_id);
    }
    @When("I set the Manager Staff Id")
    public void i_set_the_manager_staff_id() {
        manager_staff_id = 2;
        dummyStore.setManager_staff_id(manager_staff_id);
    }
    @Then("The Store returns the values")
    public void the_store_returns_the_values() {
        Store expected = new Store(1,2,2);
        Assertions.assertEquals(expected.getStore_id(),dummyStore.getStore_id(), "Id do not match");
        Assertions.assertEquals(expected.getAddress_id(),dummyStore.getAddress_id(), "Address Id do not match");
        Assertions.assertEquals(expected.getManager_staff_id(),dummyStore.getManager_staff_id(), "Manager Staff Id do not match");

    }

}
