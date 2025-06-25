package com.hb.cda.firstorm.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Address {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    private String street;
    private String city;
    @ManyToOne
    private Person owner;


    public Address() {
    }
    public Address(String street, String city) {
        this.street = street;
        this.city = city;
    }
    public Address(int id, String street, String city) {
        this.id = id;
        this.street = street;
        this.city = city;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getStreet() {
        return street;
    }
    public void setStreet(String street) {
        this.street = street;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }

}
