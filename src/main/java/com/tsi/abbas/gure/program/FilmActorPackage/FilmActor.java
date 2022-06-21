package com.tsi.abbas.gure.program.FilmActorPackage;


import org.springframework.data.annotation.Id;

import javax.persistence.*;

@Entity
@Table(name = "film_actor")
public class FilmActor {



    /**
     * Creating properties of the film_actor Class
     */


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "actor_id")
    private int actor_id;
    @Column(name = "film_id")
    private int film_id;
    public FilmActor(int actor_id, int film_id) {
        this.actor_id = actor_id;
        this.film_id = film_id;
    }
    public FilmActor(){

    }

    /**
     * Generating setters and getters
     */


    public int getActor_id() {
        return actor_id;
    }

    public void setActor_id(int actor_id) {
        this.actor_id = actor_id;
    }

    public int getFilm_id() {
        return film_id;
    }

    public void setFilm_id(int film_id) {
        this.film_id = film_id;
    }
}
