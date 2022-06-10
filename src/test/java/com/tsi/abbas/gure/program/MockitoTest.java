package com.tsi.abbas.gure.program;


import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;


import java.util.List;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class MockitoTest {
    @MockBean
    private ActorRepository actorRepository;
    @InjectMocks
    private MyFirstMicroserviceApplication myFirstMicroserviceApp;


    @BeforeEach
    void setUp() {
        actorRepository = mock(ActorRepository.class);
        myFirstMicroserviceApp = new MyFirstMicroserviceApplication(actorRepository);
    }

    @Test
    public void getAllActorEntries() {
        myFirstMicroserviceApp.getAllActors();
        verify(actorRepository).findAll();
    }

    @Test
    public void addAllActors() {

        Actor mockActor = new Actor("Tyrone", "WIlliamson");
        myFirstMicroserviceApp.newActor(mockActor.getFirstName(), mockActor.getLastName());
        ArgumentCaptor<Actor> argumentCaptorActor = ArgumentCaptor.forClass(Actor.class);
        verify(actorRepository).save(argumentCaptorActor.capture());

        int actualID = argumentCaptorActor.getAllValues().get(0).getActor_id();
        String actualFirstName = argumentCaptorActor.getAllValues().get(0).getFirstName();
        String actualLastName = argumentCaptorActor.getAllValues().get(0).getLastName();

        Assertions.assertEquals(mockActor.actor_id, argumentCaptorActor.getValue().getActor_id(), "ID doesn't match brudda");
        Assertions.assertEquals(mockActor.firstName, argumentCaptorActor.getValue().getFirstName(), "first name doesn't match homie");
        Assertions.assertEquals(mockActor.lastName, argumentCaptorActor.getValue().getLastName(), "last name doesn't match brudda");
    }

    @Test
    public void deleteActor() {

        //Creating Mock Actor with Mock data
        Actor mockActor = new Actor("Tyrone", "WIlliamson");
        mockActor.setActor_id(0);
        myFirstMicroserviceApp.newActor(mockActor.getFirstName(), mockActor.getLastName());

        String Actual = myFirstMicroserviceApp.deleteById(0);
        String expected = "Successfully deleted";

        ArgumentCaptor<Actor> argumentCaptorActor = ArgumentCaptor.forClass(Actor.class);
        verify(actorRepository).save(argumentCaptorActor.capture());

        //Checking if actor has been added into mock repo by checking the mock repos size
        Assertions.assertEquals(1, argumentCaptorActor.getAllValues().size(), "Actor has not been added");

        myFirstMicroserviceApp.deleteById(mockActor.actor_id);
        System.out.println("Checking if actor id got value");
        System.out.println(argumentCaptorActor.getAllValues().get(0).getActor_id());

        List<Actor> list = argumentCaptorActor.getAllValues();
        System.out.println("getting allvalue of list");
        System.out.println(list);
        actorRepository.deleteAll();


        Assertions.assertEquals(expected, Actual, "The repo size is not empty, actor has not been removed");
        System.out.println("empty space so i can discern");
        System.out.println(list.get(0).getActor_id());
    }



    @Test
    public void quickTest(){

            Actor mockActor = new Actor("Tyrone", "WIlliamson");
            mockActor.setActor_id(0);
            actorRepository.save(mockActor);

        System.out.println("Wanna see what actor repository has");
        System.out.println(actorRepository.findAll());

            Assertions.assertEquals(0,actorRepository.existsById(mockActor.actor_id),"A list of all actors");

        }

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


}









