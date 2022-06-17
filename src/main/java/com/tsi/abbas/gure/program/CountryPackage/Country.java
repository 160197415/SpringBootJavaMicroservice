package com.tsi.abbas.gure.program.CountryPackage;

import javax.persistence.*;




@Entity
@Table(name = "country")
public class Country {


    /**
     * Creating properties of the Country Class
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int countryID;
     private String countryName;

    public Country(int countryID, String countryName) {
        this.countryID = countryID;
        this.countryName = countryName;
    }

    /**
     * Constructor of country
     * @param countryName is String of country in constructor associating it with name parameters of the constructor
     */
    public Country(String countryName){
        this.countryName = countryName;
    }

    public Country(){

    }

    /**
     * Generated my setters and getters for the Country class variables
     * @return country ID or Name whichever one is called
     */
    public int getCountryID() {
        return countryID;
    }

    public void setCountryID(int countryID) {
        this.countryID = countryID;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }


}


