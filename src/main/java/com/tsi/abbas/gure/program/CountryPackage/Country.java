package com.tsi.abbas.gure.program.CountryPackage;

import org.springframework.data.annotation.Id;

import javax.persistence.*;

@Entity
@Table(name = "country")
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int countryID;

    @Column(name = "country")
    private String country;

    /**
     * creating the attributes of the Country,
     * won't be using all since im learning
     */

    public Country(String country) {
        this.country = country;
    }

    public Country(){

    }

    public int getCountryID() {
        return countryID;
    }

    public void setCountryID(int countryID) {
        this.countryID = countryID;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }


}
