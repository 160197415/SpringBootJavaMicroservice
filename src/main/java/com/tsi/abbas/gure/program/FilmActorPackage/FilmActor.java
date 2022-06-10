package com.tsi.abbas.gure.program.FilmActorPackage;


import javax.persistence.*;

@Entity
@Table(name = "film_actor")
public class FilmActor {

    /**
     * Creating properties of the film_actor Class
     */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int filmActorID;
    private int filmID;

    /**
     * Generating setters and getters
     */


    public int getFilmActorID() {
        return filmActorID;
    }

    public void setFilmActorID(int filmActorID) {
        this.filmActorID = filmActorID;
    }

    public int getFilmID() {
        return filmID;
    }

    public void setFilmID(int filmID) {
        this.filmID = filmID;
    }
}
