package com.tsi.abbas.gure.program.FilmPackage;

import org.springframework.data.annotation.Id;

import javax.persistence.*;

@Entity
@Table(name = "film")
public class Film {



    /**
     * creating the attributes of the Film,
     * won't be using all since im learning
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int film_id;
    @Column(name = "title")
    private String title;

    @Column(name = "length")
    private int length;
    @Column(name = "language_id")
    private int language_id;


    public void setOriginal_language_id(int original_language_id) {
        this.original_language_id = original_language_id;
    }
    @Column(name = "original_language_id")

    private int original_language_id;
    @Column(name = "description")
    private String description;

    public int getLanguage_id() {
        return language_id;
    }

    public void setLanguage_id(int language_id) {
        this.language_id = language_id;
    }

    public int getOriginal_language_id() {
        return original_language_id;
    }



    /**
     * Generating Setters and getters
     */


    public int getFilm_id() {
        return film_id;
    }

    public void setFilm_id(int film_id) {
        this.film_id = film_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Film(int film_id, String title, int length, String description, int language_id, int original_language_id) {
        this.film_id = film_id;
        this.title = title;
        this.language_id = language_id;
        this.original_language_id = original_language_id;

        this.length = length;
        this.description = description;


    }

    public Film(){

    }

}
