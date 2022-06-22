package com.tsi.abbas.gure.program;

import com.tsi.abbas.gure.program.ActorPackage.Actor;
import com.tsi.abbas.gure.program.Controllers.customerController;
import com.tsi.abbas.gure.program.CustomerPackage.Customer;
import com.tsi.abbas.gure.program.CustomerPackage.CustomerRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CustomerMockitoTest {

    private MyFirstMicroserviceApplication myFirstMicroserviceApp;
    @MockBean
    private CustomerRepository customerRepository;

    @InjectMocks
    private customerController customerController;



    /**
     * Setting up the Mock repository I will be testing on
     * if my tests work on the mock it will work on the actual database
     */
    @BeforeEach
    void setUp() {
        customerRepository = mock(CustomerRepository.class);
        myFirstMicroserviceApp = new MyFirstMicroserviceApplication();
        customerController= new customerController(customerRepository);

    }

    /**
     * Following test to get all the customer entries in the table
     */
    @Test
    public void getAllCustomerEntriesTest() {
        //Set up mock environment
        List<com.tsi.abbas.gure.program.CustomerPackage.Customer> customerList = new ArrayList<>();

        //Insert data into mock environment
        com.tsi.abbas.gure.program.CustomerPackage.Customer customer1 = new com.tsi.abbas.gure.program.CustomerPackage.Customer(0,0,"testcustomerfirstname","testcustomerlastname","testcustomeremail",1);
        customer1.setCustomer_id(0);
        customerList.add(customer1);

        //create iterable instance that will go through the list
        Iterable<com.tsi.abbas.gure.program.CustomerPackage.Customer> customerIterator = customerList;


        //when we look for all values in repository then also we want to return the iterator results
        when(customerRepository.findAll()).thenReturn(customerIterator);


        //setting our expected and actual results
        Iterable<com.tsi.abbas.gure.program.CustomerPackage.Customer> expected = customerIterator;
        Iterable<com.tsi.abbas.gure.program.CustomerPackage.Customer> actual = customerController.getAllCustomers();


        System.out.println(expected);
        System.out.println(actual.iterator().next().getFirst_name());

        //comparing actual to expected
        Assertions.assertEquals(expected,actual,"actual message");


    }


    /**
     * A test in which we add customer to the table.
     */


    @Test
    public void createNewCustomerTest(){

        //Insert data into mock environment
        Customer customer1 = new Customer(0,0,"New","Customer","asdas@email.com",1);
        when(customerRepository.save(any(Customer.class))).thenReturn(customer1);

        Customer expected = customer1;
        Customer actual = customerController.newCustomer(customer1.getStore_id(),
                customer1.getFirst_name(),customer1.getLast_name(), customer1.getEmail(),customer1.getAddress_id());
        Assertions.assertEquals(expected,actual,"The Function was unable to complete");

    }

    /**
     * A test in which I will delete customer, testing the functions end,
     * this is due to being unable to delete a code so to speak, so we will test the function works using verify,
     * If you check the delete function in controller it ends in message successfully deleted,
     * our aim was to verify that message and that we could get the method to its end point
     */

    @Test
    public void deleteCustomerTest() {
        String expected = "Successfully deleted" ;
        String actual = customerController.deleteById(0);
        verify(customerRepository).deleteById(0);
        Assertions.assertEquals(expected,actual,"Function did not run");

    }

    /**
     * Test for searching customer by their name value
     */
    @Test
    public void searchByNameCustomerTest(){

        //Create Dummy customer to test
        Customer customer1 = new Customer(0,0,"New","Customer","asdas@email.com",1) ;

        //Get controller to get the second and last  values of my dummy customer
        customerController.newCustomer(customer1.getStore_id(),
                customer1.getFirst_name(),customer1.getLast_name(), customer1.getEmail(),customer1.getAddress_id());

        //Create a customer argument captor to capture an instance a customer class, in this case my dummy customer
        ArgumentCaptor<Customer> customerArgumentCaptor = ArgumentCaptor.forClass(Customer.class);

        //I verify the repository has added the customerArgumentCaptor in this instance
        verify(customerRepository).save(customerArgumentCaptor.capture());

        //Now we test if the argument captor actor has the value inputted into the repository
        Assertions.assertEquals(1,customerArgumentCaptor.getAllValues().size(), "The argument captor is empty");


    }

    /**
     * Test for searching customer by their ID value, testing if the ID exists
     */

    @Test
    public void IdExistsTest(){

        //Insert data into mock environment
        Customer customer1 = new Customer(0,0,"New","Customer","asdas@email.com",1);

        when(customerRepository.existsById(customer1.getCustomer_id())).thenReturn(true);

        boolean expected = true;
        boolean actual = customerController.idExists(customer1.getCustomer_id());

        Assertions.assertEquals(expected,actual, "Actor ID Doesn't exist");

    }

    /**
     * Test for updating customer values
     */

    @Test
    public void updateCustomerTest(){

        //Create mock customer/overwrite customers that I wll use
        Customer customer1 = new Customer(0,0,"New","Customer","asdas@email.com",1) ;
        customer1.setCustomer_id(0);
        Customer overwriteCustomer = new Customer(1,1,"overwrite","Customer","asdas@email.com",2) ;
        overwriteCustomer.setCustomer_id(0);

        //replicate our update methods behaviour the existbyID and find by ID methods of my updatemethod are invoked
        when(customerRepository.existsById(0)).thenReturn(true);
        when(customerRepository.findById(customer1.getCustomer_id())).thenReturn(Optional.of(customer1)) ;


        //I then invoke the last step saving the values
        when(customerRepository.save(customer1)).thenReturn(customer1,customer1);


        String expected = "Values were updated" ;
        String actual = customerController.updateCustomerDetails(customer1.getCustomer_id() ,overwriteCustomer.getStore_id(), overwriteCustomer.getFirst_name() ,
                overwriteCustomer.getLast_name(), overwriteCustomer.getEmail() ,overwriteCustomer.getAddress_id()) ;
        Assertions.assertEquals(expected , actual , "The method was not successfully run");
    }




}
