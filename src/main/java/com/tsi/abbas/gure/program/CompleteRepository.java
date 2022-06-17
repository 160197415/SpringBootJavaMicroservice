package com.tsi.abbas.gure.program;

import com.tsi.abbas.gure.program.ActorPackage.ActorRepository;
import com.tsi.abbas.gure.program.CountryPackage.CountryRepository;
import com.tsi.abbas.gure.program.CustomerPackage.CustomerRepository;
import com.tsi.abbas.gure.program.FilmActorPackage.FilmActorRepository;
import com.tsi.abbas.gure.program.FilmPackage.FilmRepository;
import com.tsi.abbas.gure.program.StorePackage.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class CompleteRepository {

    @Autowired
    private ActorRepository actorRepository;
    private CustomerRepository customerRepository;
    private FilmRepository filmRepository;
    private FilmActorRepository filmActorRepository;
    private CountryRepository countryRepository;
    private StoreRepository storeRepository;


    public CompleteRepository() {

    }
    public CompleteRepository(ActorRepository actorRepository,
                              CustomerRepository customerRepository,
                              FilmRepository filmRepository,
                              FilmActorRepository filmActorRepository,
                              CountryRepository countryRepository,
                              StoreRepository storeRepository) {
        this.actorRepository = actorRepository;
        this.customerRepository = customerRepository;
        this.filmRepository = filmRepository;
        this.filmActorRepository = filmActorRepository;
        this.countryRepository = countryRepository;
        this.storeRepository = storeRepository;
    }

    public ActorRepository getActorRepository() {
        return actorRepository;
    }

    public void setActorRepository(ActorRepository actorRepository) {
        this.actorRepository = actorRepository;
    }

    public CustomerRepository getCustomerRepository() {
        return customerRepository;
    }

    public void setCustomerRepository(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public FilmRepository getFilmRepository() {
        return filmRepository;
    }

    public void setFilmRepository(FilmRepository filmRepository) {
        this.filmRepository = filmRepository;
    }

    public FilmActorRepository getFilmActorRepository() {
        return filmActorRepository;
    }

    public void setFilmActorRepository(FilmActorRepository filmActorRepository) {
        this.filmActorRepository = filmActorRepository;
    }

    public CountryRepository getCountryRepository() {
        return countryRepository;
    }

    public void setCountryRepository(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    public StoreRepository getStoreRepository() {
        return storeRepository;
    }

    public void setStoreRepository(StoreRepository storeRepository) {
        this.storeRepository = storeRepository;
    }






}
