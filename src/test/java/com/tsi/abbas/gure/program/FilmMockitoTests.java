package com.tsi.abbas.gure.program;

import com.tsi.abbas.gure.program.Controllers.filmController;
import com.tsi.abbas.gure.program.FilmPackage.Film;
import com.tsi.abbas.gure.program.FilmPackage.FilmRepository;
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
public class FilmMockitoTests {



    private MyFirstMicroserviceApplication myFirstMicroserviceApp;
    @MockBean
    private FilmRepository filmRepository;

    @InjectMocks
    private com.tsi.abbas.gure.program.Controllers.filmController filmController;



    /**
     * Setting up the Mock repository I will be testing on
     * if my tests work on the mock it will work on the actual database
     */
    @BeforeEach
    void setUp() {
        filmRepository = mock(FilmRepository.class);
        myFirstMicroserviceApp = new MyFirstMicroserviceApplication();
        filmController= new filmController(filmRepository);

    }


    /**
     * Following test to get all the Film entries in the table
     */
    @Test
    public void getAllStoreEntriesTest() {
        //Set up mock environment
        List<Film> filmList = new ArrayList<>();

        //Insert data into mock environment
        Film film1 = new Film(1,"test title",35,"A test title for a film",1,2);
        film1.setFilm_id(0);
        filmList.add(film1);

        //create iterable instance that will go through the list
        Iterable<com.tsi.abbas.gure.program.FilmPackage.Film> filmIterator = filmList;


        //when we look for all values in repository then also we want to return the iterator results
        when(filmRepository.findAll()).thenReturn(filmIterator);


        //setting our expected and actual results
        Iterable<com.tsi.abbas.gure.program.FilmPackage.Film> expected = filmIterator;
        Iterable<com.tsi.abbas.gure.program.FilmPackage.Film> actual = filmController.getAllFilms();


        System.out.println(expected);
        System.out.println(actual.iterator().next().getFilm_id());

        //comparing actual to expected
        Assertions.assertEquals(expected,actual,"actual message");


    }


    /**
     * A test in which we add a new Film to the table.
     */


    @Test
    public void createNewFilmTest(){

        //Insert data into mock environment
        Film film1 = new Film(1,"test title",35,"A test title for a film",1,2);
        when(filmRepository.save(any(Film.class))).thenReturn(film1);

        Film expected = film1;
        Film actual = filmController.newFilm(film1.getTitle(),film1.getLength(),
                film1.getDescription(),film1.getLanguage_id(),film1.getOriginal_language_id());
        Assertions.assertEquals(expected,actual,"The Function was unable to complete");

    }

    /**
     * A test in which I will delete a Film, testing the functions end,
     * this is due to being unable to delete a code so to speak, so we will test the function works using verify,
     * If you check the delete function in controller it ends in message successfully deleted,
     * our aim was to verify that message and that we could get the method to its end point
     */

    @Test
    public void deleteStoreTest() {
        String expected = "Successfully deleted" ;
        String actual = filmController.deleteById(0);
        verify(filmRepository).deleteById(0);
        Assertions.assertEquals(expected,actual,"Function did not run");

    }

    /**
     * Test for searching Films by their name value
     */
    @Test
    public void searchByNameFilmTest(){

        //Create Dummy Film to test
        Film film1 = new Film(1,"test title",35,"A test title for a film",1,2);
        //Get controller to get the values of my dummy Film
        filmController.newFilm(film1.getDescription(),film1.getLength(),film1.getTitle(),
                film1.getLanguage_id(),film1.getOriginal_language_id());

        //Create a Store argument captor to capture an instance oof my Film class, in this case my dummy Film
        ArgumentCaptor<Film> filmArgumentCaptor = ArgumentCaptor.forClass(Film.class);

        //I verify the repository has added the ArgumentCaptor in this instance
        verify(filmRepository).save(filmArgumentCaptor.capture());

        //Now we test if the argument captor actor has the value inputted into the repository
        Assertions.assertEquals(1,filmArgumentCaptor.getAllValues().size(), "The argument captor is empty");


    }

    /**
     * Test for searching Film by their ID value, testing if the ID exists
     */

    @Test
    public void IdExistsTest(){

        //Insert data into mock environment
        Film film1 = new Film(1,"test title",35,"A test title for a film",1,2);

        when(filmRepository.existsById(film1.getFilm_id())).thenReturn(true);

        boolean expected = true;
        boolean actual = filmController.idExists(film1.getFilm_id());

        Assertions.assertEquals(expected,actual, "Actor ID Doesn't exist");

    }

    /**
     * Test for updating Film values
     */

    @Test
    public void updateFilmTest(){

        //Create mock Film/overwrite Films that I wll use
        Film film1 = new Film(1,"test title",35,"A test title for a film",1,2);
        film1.setFilm_id(0);
        Film overwriteFilm1 = new Film(1,"test title2",335,"A test title for a film overwritten",2,2);
        overwriteFilm1.setFilm_id(0);

        //replicate our update methods behaviour exists by ID and find by ID methods of my update method are invoked
        when(filmRepository.existsById(0)).thenReturn(true);

        when(filmRepository.findById(film1.getFilm_id())).thenReturn(Optional.of(film1)) ;


        //I then invoke the last step saving the values
        when(filmRepository.save(film1)).thenReturn(film1,film1);


        String expected = "Values were updated" ;
        String actual = filmController.updateFilm(film1.getFilm_id(), overwriteFilm1.getTitle(), overwriteFilm1.getLength(),
                overwriteFilm1.getDescription(),overwriteFilm1.getLanguage_id(),overwriteFilm1.getOriginal_language_id());
        Assertions.assertEquals(expected , actual , "The method was not successfully run");
    }






}
