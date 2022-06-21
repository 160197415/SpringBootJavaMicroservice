package com.tsi.abbas.gure.program.Controllers;

import com.tsi.abbas.gure.program.CustomerPackage.Customer;
import com.tsi.abbas.gure.program.CustomerPackage.CustomerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class customerController {

    //Customer repository instantiated
    @Autowired
    private CustomerRepository customerRepository;


    /**This is for getting all the customers from the customer table in the sakila database
     * More specifically in terms of CRUD functions this is the 'Read'*/
    @GetMapping("/All_Customers")
    public @ResponseBody
    Iterable<Customer> getAllCustomers(){
        return customerRepository.findAll();
    }


    /**
     *
     * @param customer_id is the ID of customers and is used as parameter for searching for customer's existence in table
     * @return true if the customer exists else return false, a simple boolean class for existence of customer's ID
     */
    @GetMapping("/Customer/IdExist")
    public @ResponseBody Boolean idExists(@RequestParam int customer_id){

        return customerRepository.existsById(customer_id);


    }


    /**Out of the CRUD functions this is the 'Delete' */
    @DeleteMapping("/Delete_By_Customer_ID")
    public @ResponseBody
    String deleteById(@RequestParam int customer_id){

        customerRepository.deleteById(customer_id);
        return "Successfully deleted";
    }


    /**Out of the CRUD functions this is the 'Update' Method */
    @PutMapping("/Replace_By_Customer_ID")
    public @ResponseBody String updateCustomerDetails(@RequestParam int customer_id ,@RequestParam int store_id, @RequestParam String first_name,
         @RequestParam String last_name,@RequestParam String email, @RequestParam int address_id)
    {
        //A string we will use later as a message that values were successfully updated, you'll see it below
        String valueWasUpdated = "Values were updated";


        //using crud repository method that we got from extended class, check if id of customer exists in the database
        if(customerRepository.existsById(customer_id)){
            // if it does find the specific ID in the database using the ID of the customer and put it in a temp store value
            Customer customer = new Customer();

            //get customer by ID
            customer = customerRepository.findById(customer_id).get();

            //Once finding customer, user updates relevant values for the film actor's variables
            customer.setStore_id(store_id);
            customer.setFirst_name(first_name);
            customer.setLast_name(last_name);
            customer.setAddress_id(address_id);
            customer.setEmail(email);


            //Repository save/updates the store detail changes.
            customerRepository.save(customer);

        } else {
            //If we do not find the customer in the repository or if they do not exist
            valueWasUpdated = "ID not found";
        }
        //Basically by this point we updated the value if correctly found
        return valueWasUpdated;


    }

    /**Out of the CRUD functions this is the 'Create' */
    @PostMapping("/Create_By_Customer_ID")
    public  @ResponseBody Customer newCustomer(@RequestParam int store_id, @RequestParam String first_name,
                                               @RequestParam String last_name,@RequestParam String email, @RequestParam int address_id)
    {
        // instance that we will use for our new customer
        Customer customer = new Customer();

        /** I didn't add id variable to be created/updated because it is auto incrementally added by the database,
         * if I do add id it would not create/update with the save method */


        //Setting Stores values
        //Then returning the value to user along with the ID they were assigned by the table
        customer.setStore_id(store_id);
        customer.setFirst_name(first_name);
        customer.setLast_name(last_name);
        customer.setEmail(email);
        customer.setAddress_id(address_id);
        return customerRepository.save(customer);
    }




}
