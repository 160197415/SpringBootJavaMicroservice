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

    private int storedRentedFromID;
    private int filmLength;
    private int filmRating;
    private int filmActorID;
    private String actorName;

    public Film(int filmID, String filmTitle, int storedRentedFromID, int filmLength, int filmRating, int filmActorID, String actorName) {
        this.filmID = filmID;
        this.filmTitle = filmTitle;
        this.storedRentedFromID = storedRentedFromID;
        this.filmLength = filmLength;
        this.filmRating = filmRating;
        this.filmActorID = filmActorID;
        this.actorName = actorName;
    }

    public Film(){

    }

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
