package com.tsi.abbas.gure.program.Controllers;

import com.tsi.abbas.gure.program.CustomerPackage.Customer;
import com.tsi.abbas.gure.program.CustomerPackage.CustomerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

public class CustomerController {

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
     * @param customerID is the ID of customers and is used as parameter for searching for customer's existence in table
     * @return true if the customer exists else return false, a simple boolean class for existence of customer's ID
     */
    @GetMapping("/Customers/IdExist")
    public @ResponseBody Boolean idExists(@RequestParam int customerID){
        if (customerRepository.existsById(customerID)){
            return true ;
        }else return false ;
    }


    /**Out of the CRUD functions this is the 'Delete' */
    @DeleteMapping("/Delete_By_ID")
    public @ResponseBody
    String deleteById(@RequestParam int filmActorID){

        customerRepository.deleteById(filmActorID);
        return "Successfully deleted";
    }


    /**Out of the CRUD functions this is the 'Update' Method */
    @PutMapping("/Replace_By_ID")
    public @ResponseBody String updateCustomerDetails(@RequestParam int customerID ,@RequestParam int storeID, @RequestParam String customerFirstName,
         @RequestParam String customerLastName,@RequestParam String customerEmail,@RequestParam String customerAddress)
    {
        //A string we will use later as a message that values were successfully updated, you'll see it below
        String valueWasUpdated = "Values were updated";


        //using crud repository method that we got from extended class, check if id of customer exists in the database
        if(customerRepository.existsById(customerID)){
            // if it does find the specific ID in the database using the ID of the customer and put it in a temp store value
            Customer customer = new Customer();

            //get customer by ID
            customer = customerRepository.findById(customerID).get();

            //Once finding customer, user updates relevant values for the film actor's variables
            customer.setStoreID(storeID);
            customer.setCustomerFirstName(customerFirstName);
            customer.setCustomerLastName(customerLastName);
            customer.setCustomerEmail(customerEmail);
            customer.setCustomerAddress(customerAddress);

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
    @PostMapping("/Create_By_ID")
    public  @ResponseBody Customer newCustomer(@RequestParam int storeID, @RequestParam String customerFirstName,
          @RequestParam String customerLastName,@RequestParam String customerEmail,@RequestParam String customerAddress)
    {
        // instance that we will use for our new customer
        Customer customer = new Customer();

        /** I didn't add id variable to be created/updated because it is auto incrementally added by the database,
         * if I do add id it would not create/update with the save method */


        //Setting Stores values
        //Then returning the value to user along with the ID they were assigned by the table
        customer.setStoreID(storeID);
        customer.setCustomerFirstName(customerFirstName);
        customer.setCustomerLastName(customerLastName);
        customer.setCustomerEmail(customerEmail);
        customer.setCustomerAddress(customerAddress);
        return customerRepository.save(customer);
    }




}
