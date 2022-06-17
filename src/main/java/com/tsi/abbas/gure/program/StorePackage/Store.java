package com.tsi.abbas.gure.program.StorePackage;

import javax.persistence.*;

@Entity
@Table(name = "store")
public class Store {

    /**
     * creating the attributes of the Store
     */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int storeID;

    public Store(int storeID, int storeAddressID, int staffSize) {
        this.storeID = storeID;
        this.storeAddressID = storeAddressID;
        this.staffSize = staffSize;
    }
public Store(){

}
    private int storeAddressID;

    private int staffSize;

    /**
     * Setters and getters generated
     */


    public int getStoreID() {
        return storeID;
    }

    public void setStoreID(int storeID) {
        this.storeID = storeID;
    }

    public int getStoreAddressID() {
        return storeAddressID;
    }

    public void setStoreAddressID(int storeAddressID) {
        this.storeAddressID = storeAddressID;
    }

    public int getStaffSize() {
        return staffSize;
    }

    public void setStaffSize(int staffSize) {
        this.staffSize = staffSize;
    }

}
