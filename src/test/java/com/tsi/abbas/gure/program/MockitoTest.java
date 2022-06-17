package com.tsi.abbas.gure.program;


import com.tsi.abbas.gure.program.ActorPackage.Actor;
import com.tsi.abbas.gure.program.ActorPackage.ActorRepository;
import com.tsi.abbas.gure.program.CustomerPackage.CustomerRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;


import java.util.List;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class MockitoTest {
    @MockBean
    private ActorRepository actorRepository;

    @MockBean
    private CustomerRepository customerRepository;
    @InjectMocks
    private MyFirstMicroserviceApplication myFirstMicroserviceApp;


    /**
     * Setting up the Mock repository I will be testing on
     * if my tests work on the mock it will work on the actual database
     */
    @BeforeEach
    void setUp() {
        actorRepository = mock(ActorRepository.class);
        customerRepository = mock(CustomerRepository.class);
        myFirstMicroserviceApp = new MyFirstMicroserviceApplication(actorRepository,customerRepository);
    }

    /**
     * Following test to get all the actor entries in the table
     */
    @Test
    public void getAllActorEntries() {
        //call the microservice instance and use method to get all actors
        myFirstMicroserviceApp.getAllActors();

        //Verify method from @Mock, using it to verify our Mock repository can find all actors
        verify(actorRepository).findAll();
    }

    /**
     * A test in which we add actor to the table.
     */
    @Test
    public void addAllActors() {
        //Create mock Actor instance class with firstname and last name
        //#Remember we do not need to input ID as that is autoincremented
        //#Also keep in mind at this point the  mock repository is empty
        Actor mockActor = new Actor("Tyrone", "WIlliamson");

        //Add new actor into my microservice mock repo, but I will input the values of the mock actor
        myFirstMicroserviceApp.newActor(mockActor.getFirstName(), mockActor.getLastName());

        //Argument captor actor will capture the instance of the creation of my new mock actor in putting into the class
        //#Might do some research on argument captor and change comment later
        ArgumentCaptor<Actor> argumentCaptorActor = ArgumentCaptor.forClass(Actor.class);
        verify(actorRepository).save(argumentCaptorActor.capture());

        //Setting up my actual values for the assertwquals test class to compare to the mock actor
        int actualID = argumentCaptorActor.getAllValues().get(0).getActorID();
        String actualFirstName = argumentCaptorActor.getAllValues().get(0).getFirstName();
        String actualLastName = argumentCaptorActor.getAllValues().get(0).getLastName();

        //Test that the mock actor values are similar to the argument capture actor who captured the instance values of my new mock actor
        //Basically check if the values are the same.
        Assertions.assertEquals(mockActor.actorId, argumentCaptorActor.getValue().getActorID(), "ID doesn't match brudda");
        Assertions.assertEquals(mockActor.firstName, argumentCaptorActor.getValue().getFirstName(), "first name doesn't match homie");
        Assertions.assertEquals(mockActor.lastName, argumentCaptorActor.getValue().getLastName(), "last name doesn't match brudda");
    }

    /**
     * A test in which I will delete actor
     */
    @Test
    public void deleteActor() {

        //Creating Mock Actor with Mock data
        Actor mockActor = new Actor("Tyrone", "WIlliamson");
        mockActor.setActorID(0);
        myFirstMicroserviceApp.newActor(mockActor.getFirstName(), mockActor.getLastName());

        String Actual = myFirstMicroserviceApp.deleteById(0);
        String expected = "Successfully deleted";

        ArgumentCaptor<Actor> argumentCaptorActor = ArgumentCaptor.forClass(Actor.class);
        verify(actorRepository).save(argumentCaptorActor.capture());

        //Checking if actor has been added into mock repo by checking the mock repos size
        Assertions.assertEquals(1, argumentCaptorActor.getAllValues().size(), "Actor has not been added");

        myFirstMicroserviceApp.deleteById(mockActor.actorId);
        System.out.println("\nChecking if actor id got value");
        System.out.println(argumentCaptorActor.getAllValues().get(0).getActorID());

        List<Actor> list = argumentCaptorActor.getAllValues();
        System.out.println("\ngetting allvalue of list");
        System.out.println(list);
        actorRepository.deleteAll();


        Assertions.assertEquals(expected, Actual, "The repo size is not empty, actor has not been removed");
        System.out.println("\nempty space so i can discern");
        System.out.println(list.get(0).getActorID());
    }

    /**
     * Tests for when I want to search for an actor
     */
    @Test
    public void searchByNameActor(){

        //Create Dummy actor to test
        Actor dummyActor = new Actor("John" , "Doe") ;

        //Get myMicroserviceApp to get the first and last name values of my dummy actor
        myFirstMicroserviceApp.newActor(dummyActor.getFirstName(),dummyActor.getLastName());

        //Create an actor argument captor to capture an instance an actor class, in this case my dummy actor
        ArgumentCaptor<Actor> actorArgumentCaptor = ArgumentCaptor.forClass(Actor.class);

        //I verify the repository has added the actorargumentcaptor in this instance
        verify(actorRepository).save(actorArgumentCaptor.capture());

        //Now we test if the argument captor actor has the value inputted into the repository
        Assertions.assertEquals(1,actorArgumentCaptor.getAllValues().size(), "The argument captor is empty");


    }

//    @Test
//    public void quickTest(){
//
//            Actor mockActor = new Actor("Tyrone", "WIlliamson");
//            mockActor.setActor_id(0);
//            actorRepository.save(mockActor);
//
//        System.out.println("Wanna see what actor repository has");
//        System.out.println(actorRepository.findAll());
//
//            Assertions.assertEquals(mockActor.getActor_id(),actorRepository.findById(mockActor.getActor_id()),"A list of all actors");
//
//        }
}









