package com.tsi.abbas.gure.program;


import com.tsi.abbas.gure.program.ActorPackage.Actor;
import com.tsi.abbas.gure.program.ActorPackage.ActorRepository;
import com.tsi.abbas.gure.program.Controllers.ActorController;
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

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ActorMockitoTest {

    private MyFirstMicroserviceApplication myFirstMicroserviceApp;
    @MockBean
    private ActorRepository actorRepository;

    @InjectMocks
    private ActorController actorController;




    /**
     * Setting up the Mock repository I will be testing on
     * if my tests work on the mock it will work on the actual database
     */
    @BeforeEach
    void setUp() {
        actorRepository = mock(ActorRepository.class);
        myFirstMicroserviceApp = new MyFirstMicroserviceApplication();
        actorController= new ActorController(actorRepository);

    }

    /**
     * Following test to get all the actor entries in the table
     */
    @Test
    public void getAllActorEntriesTest() {
        //Set up mock environment
        List<Actor> actorList = new ArrayList<>();

        //Insert data into mock environment
        Actor actor1 = new Actor("asdasd","asdsada");
        actor1.setActorID(0);
        actorList.add(actor1);

        //create iterable instance that will go through the list
        Iterable<Actor> actorIterator = actorList;


        //when we look for all values in repository then also we want to return the iterator results
        when(actorRepository.findAll()).thenReturn(actorIterator);


        //setting our expected and actual results
        Iterable<Actor> expected = actorIterator;
        Iterable<Actor> actual = actorController.getAllActors();


        System.out.println(expected);
        System.out.println(actual.iterator().next().getFirst_name());

        //comparing actual to expected
        Assertions.assertEquals(expected,actual,"actual message");


    }


    /**
     * A test in which we add actor to the table.
     */


    @Test
    public void createNewActorTest(){

        //Insert data into mock environment
        Actor actor1 = new Actor("New","Actor");
        when(actorRepository.save(any(Actor.class))).thenReturn(actor1);

        Actor expected = actor1;
        Actor actual = actorController.newActor(actor1.getFirst_name(),actor1.getLast_name());
        Assertions.assertEquals(expected,actual,"The Function was unable to complete");

    }

    /**
     * A test in which I will delete actor, testing the functions end,
     * this is due to being unable to delete a code so to sepak so we will test the function works using verify,
     * If you check the delete function in controller it ends in message successfully deleted,
     * our aim was to verify that message and that we could get the method to its end point
     */

    @Test
    public void deleteActor() {
        String expected = "Successfully deleted" ;
        String actual = actorController.deleteById(0);
        verify(actorRepository).deleteById(0);
        Assertions.assertEquals(expected,actual,"Function did not run");

    }

//    /**
//     * Tests for when I want to search for an actor
//     */

    /**
     * Test for searching actor by their name value
     */
    @Test
    public void searchByNameActor(){

        //Create Dummy actor to test
        Actor actor1 = new Actor("John" , "Doe") ;

        //Get controller to get the first and last name values of my dummy actor
        actorController.newActor(actor1.getFirst_name(),actor1.getLast_name());

        //Create an actor argument captor to capture an instance an actor class, in this case my dummy actor
        ArgumentCaptor<Actor> actorArgumentCaptor = ArgumentCaptor.forClass(Actor.class);

        //I verify the repository has added the actorargumentcaptor in this instance
        verify(actorRepository).save(actorArgumentCaptor.capture());

        //Now we test if the argument captor actor has the value inputted into the repository
        Assertions.assertEquals(1,actorArgumentCaptor.getAllValues().size(), "The argument captor is empty");


    }

    /**
     * Test for searching actor by their ID value, testing if the ID exists
     */

    @Test
    public void IdExistsTest(){

        //Insert data into mock environment
        Actor actor1 = new Actor("New","Actor");

        when(actorRepository.existsById(actor1.actor_id)).thenReturn(true);

        boolean expected = true;
        boolean actual = actorController.idExists(actor1.getActorID());

        Assertions.assertEquals(expected,actual, "Actor ID Doesn't exist");

    }

    /**
     * Test for updating actor values
     */

    @Test
    public void updateActorTest(){

        //Create mock actor/overwrite actors that I wll use
        Actor actor1 = new Actor("Test" , "Actor1" ) ;
        actor1.setActorID(0);
        Actor overwriteActor1 = new Actor("Test" , "Actor2" ) ;
        overwriteActor1.setActorID(0);

        //replicate our update methods behaviour the existbyID and find by ID methods of my updatemethod are invoked
        when(actorRepository.existsById(0)).thenReturn(true);
        when(actorRepository.findById(actor1.getActorID())).thenReturn(Optional.of(actor1)) ;


        //I then invoke the last step saving the values
        when(actorRepository.save(actor1)).thenReturn(actor1,actor1);


        String expected = "Values were updated" ;
        String actual = actorController.updateActor(actor1.getActorID() , overwriteActor1.getFirst_name() , overwriteActor1.getLast_name()) ;
        Assertions.assertEquals(expected , actual , "The method was not successfully run");
    }
}








