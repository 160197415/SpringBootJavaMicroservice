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

    private String customerFirstName;
    private String customerLastName;

    public Customer(int customerID, int storeID, String customerFirstName, String customerLastName, String customerEmail, String customerAddress) {
        this.customerID = customerID;
        this.storeID = storeID;
        this.customerFirstName = customerFirstName;
        this.customerLastName = customerLastName;
        this.customerEmail = customerEmail;
        this.customerAddress = customerAddress;
    }
    public Customer(){

    }
    private String customerEmail;
    private String customerAddress;

    /**
     * Generating Setters and Getters
     */

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public int getStoreID() {
        return storeID;
    }

    public void setStoreID(int storeID) {
        this.storeID = storeID;
    }

    public String getCustomerFirstName() {
        return customerFirstName;
    }

    public void setCustomerFirstName(String customerFirstName) {
        this.customerFirstName = customerFirstName;
    }

    public String getCustomerLastName() {
        return customerLastName;
    }

    public void setCustomerLastName(String customerLastName) {
        this.customerLastName = customerLastName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

}
