package com.tsi.abbas.gure.program.ActorPackage;


import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;



import javax.persistence.*;

@Entity
@Table(name="actor")

public class Actor {

    /**
     *
     * @param actorId is the ID of the customer, a variable to replicate actor in actor sakila database table
     * @param firstName is firstname variable of the actor
     * @param lastName is the lastname variable for our actor class
     */


    //Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int actor_id;

    public String first_name;
    public String last_name;


    /**
     * This is the basic constructor of the actor details that we will edit, we don't add the ID
     * due to ID being auto-incremental in the database when we add a new actor.
     * @param first_name is firstname variable of the actor
     * @param last_name is the lastname variable for our actor class
     */
    public Actor(String first_name, String last_name){
        this.first_name = first_name;
        this.last_name = last_name;
    }


    /**
     * This is a beanbag constructor (google for definition)
     */
    public Actor() {

    }

    /**
     *
     * Consists of setters and getters of the actor class variables
     */

    public void setActorID(int actorId) {
        this.actor_id = actorId;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public int getActorID() {
        return actor_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

}

