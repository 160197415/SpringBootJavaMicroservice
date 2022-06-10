package com.tsi.abbas.gure.program.FilmPackage;

import javax.persistence.*;

@Entity
@Table(name = "film")
public class Film {



    /**
     * creating the attributes of the Store,
     * won't be using all since im learning
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int filmID;
    private String filmTitle;
    private int languageID;
    private int storedRentedFromID;
    private int filmLength;
    private int filmRating;
    private int filmActorID;
    private String actorName;

    /**
     * Generating Setters and getters
     */


    public int getFilmID() {
        return filmID;
    }

    public void setFilmID(int filmID) {
        this.filmID = filmID;
    }

    public String getFilmTitle() {
        return filmTitle;
    }

    public void setFilmTitle(String filmTitle) {
        this.filmTitle = filmTitle;
    }

    public int getLanguageID() {
        return languageID;
    }

    public void setLanguageID(int languageID) {
        this.languageID = languageID;
    }

    public int getStoredRentedFromID() {
        return storedRentedFromID;
    }

    public void setStoredRentedFromID(int storedRentedFromID) {
        this.storedRentedFromID = storedRentedFromID;
    }

    public int getFilmLength() {
        return filmLength;
    }

    public void setFilmLength(int filmLength) {
        this.filmLength = filmLength;
    }

    public int getFilmRating() {
        return filmRating;
    }

    public void setFilmRating(int filmRating) {
        this.filmRating = filmRating;
    }

    public int getFilmActorID() {
        return filmActorID;
    }

    public void setFilmActorID(int filmActorID) {
        this.filmActorID = filmActorID;
    }

    public String getActorName() {
        return actorName;
    }

    public void setActorName(String actorName) {
        this.actorName = actorName;
    }

}
