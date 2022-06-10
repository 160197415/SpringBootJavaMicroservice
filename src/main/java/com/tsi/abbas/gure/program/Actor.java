package com.tsi.abbas.gure.program;


import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;



import javax.persistence.*;

@Entity
@Table(name="actor")

public class Actor {




    //Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int actor_id;
    String firstName;
    String lastName;
    //Constructors
    public Actor(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Actor() {

    }



    //Methods

    public void setActor_id(int actor_id) {
        this.actor_id = actor_id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public int getActor_id() {
        return actor_id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

}

