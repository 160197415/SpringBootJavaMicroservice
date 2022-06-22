package com.tsi.abbas.gure.program.StorePackage;

import org.springframework.data.annotation.Id;

import javax.persistence.*;

@Entity
@Table(name = "store")
public class Store {

    /**
     * creating the attributes of the Store
     */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int store_id;

    public Store(int store_id, int address_id, int manager_staff_id) {
        this.store_id = store_id;
        this.address_id = address_id;
        this.manager_staff_id = manager_staff_id;
    }

    private int address_id;

    private int manager_staff_id;

    public Store(){

    }
    /**
     * Setters and getters generated
     */


    public int getStore_id() {
        return store_id;
    }

    public void setStore_id(int store_id) {
        this.store_id = store_id;
    }

    public int getAddress_id() {
        return address_id;
    }

    public void setAddress_id(int address_id) {
        this.address_id = address_id;
    }

    public int getManager_staff_id() {
        return manager_staff_id;
    }

    public void setManager_staff_id(int manager_staff_id) {
        this.manager_staff_id = manager_staff_id;
    }

}
