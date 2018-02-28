package com.georgebrown.comp3074.a1100984638;

import java.io.Serializable;

/**
 * Created by Owner on 9/30/2017.
 */

public class Customer implements Serializable {
    private String firstName;
    private String lastName;
    private String address;
    private String postalCode;
    private String creditNo;
    private String cuisine;
    private String restaurant;

    public Customer(){};

    //when user input all values in the form
    public Customer(String firstName, String lastName, String address, String postalCode, String creditNo, String cuisine, String restaurant){
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.postalCode = postalCode;
        this.creditNo = creditNo;
        this.cuisine = cuisine;
        this.restaurant = restaurant;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCreditNo() {
        return creditNo;
    }

    public void setCreditNo(String creditNo) {
        this.creditNo = creditNo;
    }

    public String getCuisine() {
        return cuisine;
    }

    public void setCuisine(String cuisine) {
        this.cuisine = cuisine;
    }

    public String getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(String restaurant) {
        this.restaurant = restaurant;
    }
}
