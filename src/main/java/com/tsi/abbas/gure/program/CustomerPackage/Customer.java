package com.tsi.abbas.gure.program.CustomerPackage;


import javax.persistence.*;

@Entity
@Table(name = "customer")
public class Customer {

    /**
     * Creating properties of the Customer Class
     */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int customerID;
    private int storeID;

}
