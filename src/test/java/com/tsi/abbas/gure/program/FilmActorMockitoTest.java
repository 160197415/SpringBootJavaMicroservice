package com.tsi.abbas.gure.program;

import com.tsi.abbas.gure.program.Controllers.countryController;
import com.tsi.abbas.gure.program.Controllers.filmActorController;
import com.tsi.abbas.gure.program.CountryPackage.Country;
import com.tsi.abbas.gure.program.CountryPackage.CountryRepository;
import com.tsi.abbas.gure.program.FilmActorPackage.FilmActor;
import com.tsi.abbas.gure.program.FilmActorPackage.FilmActorRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class FilmActorMockitoTest {




    private MyFirstMicroserviceApplication myFirstMicroserviceApp;
    @MockBean
    private FilmActorRepository filmActorRepository;

    @InjectMocks
    private com.tsi.abbas.gure.program.Controllers.filmActorController filmActorController;



    /**
     * Setting up the Mock repository I will be testing on
     * if my tests work on the mock it will work on the actual database
     */
    @BeforeEach
    void setUp() {
        filmActorRepository = mock(FilmActorRepository.class);
        myFirstMicroserviceApp = new MyFirstMicroserviceApplication();
        filmActorController= new filmActorController(filmActorRepository);

    }
    /**
     * Following test to get all the Film Actor entries from the Film Actor the table
     */

    @Test
    public void getAllFilmActorEntriesTest() {
        //Set up mock environment
        List<FilmActor> filmActorList = new ArrayList<>();

        //Insert data into mock environment
        FilmActor filmActor1 = new FilmActor(12,12);
        filmActor1.setFilm_id(0);
        filmActorList.add(filmActor1);

        //create iterable instance that will go through the list
        Iterable<com.tsi.abbas.gure.program.FilmActorPackage.FilmActor> filmActorIterator = filmActorList;


        //when we look for all values in repository then also we want to return the iterator results
        when(filmActorRepository.findAll()).thenReturn(filmActorIterator);


        //setting our expected and actual results
        Iterable<com.tsi.abbas.gure.program.FilmActorPackage.FilmActor> expected = filmActorIterator;
        Iterable<com.tsi.abbas.gure.program.FilmActorPackage.FilmActor> actual = filmActorController.getAllFilmActors();


        System.out.println(expected);
        System.out.println(actual.iterator().next().getFilm_id());

        //comparing actual to expected
        Assertions.assertEquals(expected,actual,"actual message");


    }



}
