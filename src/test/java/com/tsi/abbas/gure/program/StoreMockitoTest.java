package com.tsi.abbas.gure.program;

import com.tsi.abbas.gure.program.Controllers.storeController;
import com.tsi.abbas.gure.program.StorePackage.Store;
import com.tsi.abbas.gure.program.StorePackage.StoreRepository;
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
public class StoreMockitoTest {


    private MyFirstMicroserviceApplication myFirstMicroserviceApp;
    @MockBean
    private StoreRepository storeRepository;

    @InjectMocks
    private com.tsi.abbas.gure.program.Controllers.storeController storeController;



    /**
     * Setting up the Mock repository I will be testing on
     * if my tests work on the mock it will work on the actual database
     */
    @BeforeEach
    void setUp() {
        storeRepository = mock(StoreRepository.class);
        myFirstMicroserviceApp = new MyFirstMicroserviceApplication();
        storeController= new storeController(storeRepository);

    }

    /**
     * Following test to get all the Store entries in the table
     */
    @Test
    public void getAllStoreEntriesTest() {
        //Set up mock environment
        List<Store> storeList = new ArrayList<>();

        //Insert data into mock environment
        Store store1 = new Store(1,1,1);
        store1.setStore_id(0);
        storeList.add(store1);

        //create iterable instance that will go through the list
        Iterable<com.tsi.abbas.gure.program.StorePackage.Store> storeIterator = storeList;


        //when we look for all values in repository then also we want to return the iterator results
        when(storeRepository.findAll()).thenReturn(storeIterator);


        //setting our expected and actual results
        Iterable<com.tsi.abbas.gure.program.StorePackage.Store> expected = storeIterator;
        Iterable<com.tsi.abbas.gure.program.StorePackage.Store> actual = storeController.getAllStores();


        System.out.println(expected);
        System.out.println(actual.iterator().next().getAddress_id());

        //comparing actual to expected
        Assertions.assertEquals(expected,actual,"actual message");


    }


    /**
     * A test in which we add a new Store to the table.
     */


    @Test
    public void createNewStoreTest(){

        //Insert data into mock environment
        Store store1 = new Store(1,1,1);
        when(storeRepository.save(any(Store.class))).thenReturn(store1);

        Store expected = store1;
        Store actual = storeController.newStore(store1.getStore_id(),
                store1.getAddress_id(),store1.getManager_staff_id());
        Assertions.assertEquals(expected,actual,"The Function was unable to complete");

    }

    /**
     * A test in which I will delete a Store, testing the functions end,
     * this is due to being unable to delete a code so to speak, so we will test the function works using verify,
     * If you check the delete function in controller it ends in message successfully deleted,
     * our aim was to verify that message and that we could get the method to its end point
     */

    @Test
    public void deleteStoreTest() {
        String expected = "Successfully deleted" ;
        String actual = storeController.deleteById(0);
        verify(storeRepository).deleteById(0);
        Assertions.assertEquals(expected,actual,"Function did not run");

    }

    /**
     * Test for searching Store by their name value
     */
    @Test
    public void searchByNameStoreTest(){

        //Create Dummy Store to test
        Store store1 = new Store(1,1,1);
        //Get controller to get the first and last  values of my dummy store
        storeController.newStore(store1.getStore_id(),store1.getAddress_id(),store1.getManager_staff_id());

        //Create a Store argument captor to capture an instance oof my store class, in this case my dummy store
        ArgumentCaptor<Store> storeArgumentCaptor = ArgumentCaptor.forClass(Store.class);

        //I verify the repository has added the ArgumentCaptor in this instance
        verify(storeRepository).save(storeArgumentCaptor.capture());

        //Now we test if the argument captor actor has the value inputted into the repository
        Assertions.assertEquals(1,storeArgumentCaptor.getAllValues().size(), "The argument captor is empty");


    }

    /**
     * Test for searching Store by their ID value, testing if the ID exists
     */

    @Test
    public void IdExistsTest(){

        //Insert data into mock environment
        Store store1 = new Store(1,1,1);

        when(storeRepository.existsById(store1.getStore_id())).thenReturn(true);

        boolean expected = true;
        boolean actual = storeController.idExists(store1.getStore_id());

        Assertions.assertEquals(expected,actual, "Actor ID Doesn't exist");

    }

    /**
     * Test for updating Store values
     */

    @Test
    public void updateStoreTest(){

        //Create mock customer/overwrite customers that I wll use
        Store store1 = new Store(1,1,1);
        store1.setStore_id(0);
        Store overwriteStore1 = new Store(1,1,1) ;
        overwriteStore1.setStore_id(0);

        //replicate our update methods behaviour exists by ID and find by ID methods of my update method are invoked
        when(storeRepository.existsById(0)).thenReturn(true);

        when(storeRepository.findById(store1.getStore_id())).thenReturn(Optional.of(store1)) ;


        //I then invoke the last step saving the values
        when(storeRepository.save(store1)).thenReturn(store1,store1);


        String expected = "Values were updated" ;
        String actual = storeController.updateStore(store1.getStore_id(), overwriteStore1.getAddress_id(), overwriteStore1.getManager_staff_id());
        Assertions.assertEquals(expected , actual , "The method was not successfully run");
    }





}




