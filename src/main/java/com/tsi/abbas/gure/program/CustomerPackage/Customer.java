package com.tsi.abbas.gure.program.CustomerPackage;


import org.springframework.data.annotation.Id;

import javax.persistence.*;

@Entity
@Table(name = "customer")
public class Customer {



    /**
     * Creating properties of the Customer Class
     */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int customer_id;

    @Column(name = "store_id")
    private int store_id;


    private String first_name;


    private String last_name;

    private String email;

    public int getAddress_id() {
        return address_id;
    }

    public void setAddress_id(int address_id) {
        this.address_id = address_id;
    }

    private int address_id;


    public Customer(int customer_id, int store_id, String first_name, String last_name, String email, int address_id) {
        this.customer_id = customer_id;
        this.store_id = store_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.address_id = address_id;
    }




    public Customer(){

    }

    /**
     * Generating Setters and Getters
     */

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public int getStore_id() {
        return store_id;
    }

    public void setStore_id(int store_id) {
        this.store_id = store_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}
