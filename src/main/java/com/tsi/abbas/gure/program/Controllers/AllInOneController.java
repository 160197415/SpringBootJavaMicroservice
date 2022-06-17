package com.tsi.abbas.gure.program.Controllers;


import com.tsi.abbas.gure.program.ActorPackage.ActorRepository;
import com.tsi.abbas.gure.program.CompleteRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class AllInOneController {

    private CompleteRepository completeRepository = new CompleteRepository()  ;

    public class CompleteController {
        @Autowired
        private ActorRepository actorRepository;
        @Autowired
        private ActorController actorController;
        @Autowired
        private CustomerController customerController;
        @Autowired
        private FilmController filmController;
        @Autowired
        private FilmActorController filmActorController;
        @Autowired
        private CountryController countryController;
        @Autowired
        private StoreController storeController;


    }



    }
