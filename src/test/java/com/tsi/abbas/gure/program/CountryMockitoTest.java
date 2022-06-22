package com.tsi.abbas.gure.program;

import com.tsi.abbas.gure.program.Controllers.countryController;
import com.tsi.abbas.gure.program.CountryPackage.Country;
import com.tsi.abbas.gure.program.CountryPackage.CountryRepository;
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
public class CountryMockitoTest {


    private MyFirstMicroserviceApplication myFirstMicroserviceApp;
    @MockBean
    private CountryRepository countryRepository;

    @InjectMocks
    private com.tsi.abbas.gure.program.Controllers.countryController countryController;



    /**
     * Setting up the Mock repository I will be testing on
     * if my tests work on the mock it will work on the actual database
     */
    @BeforeEach
    void setUp() {
        countryRepository = mock(CountryRepository.class);
        myFirstMicroserviceApp = new MyFirstMicroserviceApplication();
        countryController= new countryController(countryRepository);

    }

    /**
     * Following test to get all the Country entries in the table
     */
    @Test
    public void getAllCountryEntriesTest() {
        //Set up mock environment
        List<Country> countryList = new ArrayList<>();

        //Insert data into mock environment
        Country country1 = new Country("alabama");
        country1.setCountryID(0);
        countryList.add(country1);

        //create iterable instance that will go through the list
        Iterable<com.tsi.abbas.gure.program.CountryPackage.Country> countryIterator = countryList;


        //when we look for all values in repository then also we want to return the iterator results
        when(countryRepository.findAll()).thenReturn(countryIterator);


        //setting our expected and actual results
        Iterable<com.tsi.abbas.gure.program.CountryPackage.Country> expected = countryIterator;
        Iterable<com.tsi.abbas.gure.program.CountryPackage.Country> actual = countryController.getAllCountries();


        System.out.println(expected);
        System.out.println(actual.iterator().next().getCountryID());

        //comparing actual to expected
        Assertions.assertEquals(expected,actual,"actual message");


    }


    /**
     * A test in which we add a new Country to the table.
     */


    @Test
    public void createNewCountryTest(){

        //Insert data into mock environment
        Country country1 = new Country("alabama");
        when(countryRepository.save(any(Country.class))).thenReturn(country1);

        Country expected = country1;
        Country actual = countryController.newCountry(country1.getCountry());
        Assertions.assertEquals(expected,actual,"The Function was unable to complete");

    }

    /**
     * A test in which I will delete a Country, testing the functions end,
     * this is due to being unable to delete a code so to speak, so we will test the function works using verify,
     * If you check the delete function in controller it ends in message successfully deleted,
     * our aim was to verify that message and that we could get the method to its end point
     */

    @Test
    public void deleteCountryTest() {
        String expected = "Successfully deleted" ;
        String actual = countryController.deleteByCountryId(0);
        verify(countryRepository).deleteById(0);
        Assertions.assertEquals(expected,actual,"Function did not run");

    }

    /**
     * Test for searching Country by their name value
     */
    @Test
    public void searchByNameCountryTest(){

        //Create Dummy Store to test
        Country country1 = new Country("alabama");
        //Get controller to get the first and last  values of my dummy store
        countryController.newCountry(country1.getCountry());

        //Create a Store argument captor to capture an instance oof my store class, in this case my dummy store
        ArgumentCaptor<Country> countryArgumentCaptor = ArgumentCaptor.forClass(Country.class);

        //I verify the repository has added the ArgumentCaptor in this instance
        verify(countryRepository).save(countryArgumentCaptor.capture());

        //Now we test if the argument captor actor has the value inputted into the repository
        Assertions.assertEquals(1,countryArgumentCaptor.getAllValues().size(), "The argument captor is empty");


    }

    /**
     * Test for searching Countries by their ID value, testing if the ID exists
     */

    @Test
    public void IdExistsTest(){

        //Insert data into mock environment
        Country country1 = new Country("alabama");

        when(countryRepository.existsById(country1.getCountryID())).thenReturn(true);

        boolean expected = true;
        boolean actual = countryController.idExists(country1.getCountryID());

        Assertions.assertEquals(expected,actual, "Actor ID Doesn't exist");

    }

    /**
     * Test for updating Country values
     */

    @Test
    public void updateStoreTest(){

        //Create mock Country/overwrite Country that I wll use
        Country country1 = new Country("alabama");
        country1.setCountryID(0);
        Country overwriteCountry1 = new Country("somalia") ;
        overwriteCountry1.setCountryID(0);

        //replicate our update methods behaviour exists by ID and find by ID methods of my update method are invoked
        when(countryRepository.existsById(0)).thenReturn(true);

        when(countryRepository.findById(country1.getCountryID())).thenReturn(Optional.of(country1)) ;


        //I then invoke the last step saving the values
        when(countryRepository.save(country1)).thenReturn(country1,country1);


        String expected = "Values were updated" ;
        String actual = countryController.updateCountry(country1.getCountryID(), overwriteCountry1.getCountry());
        Assertions.assertEquals(expected , actual , "The method was not successfully run");
    }







}
