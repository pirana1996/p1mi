package com.example.demo.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="person")
public class Person {
    @Id
    int personId;     //seller
    String firstName;
    String lastName;
    String country;
    String city;
    Timestamp birthDate;
    float totalRating;
    String phoneNumber;

    public int getPersonId() {
        return personId;
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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Timestamp getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Timestamp birthDate) {
        this.birthDate = birthDate;
    }

    public float getTotalRating() {
        return totalRating;
    }

    public void setTotalRating(float totalRating) {
        this.totalRating = totalRating;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Product> getProductsOnSale() {
        return productsOnSale;
    }

    public void setProductsOnSale(List<Product> productsOnSale) {
        this.productsOnSale = productsOnSale;
    }

    public List<Product> getBoughtProducts() {
        return boughtProducts;
    }

    public void setBoughtProducts(List<Product> boughtProducts) {
        this.boughtProducts = boughtProducts;
    }

    public List<Bid> getBiddings() {
        return biddings;
    }

    public void setBiddings(List<Bid> biddings) {
        this.biddings = biddings;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    String description;

    @Transient
    @OneToMany(mappedBy = "seller")
    List<Product> productsOnSale;

    @Transient
    @OneToMany(mappedBy = "buyer")
    List<Product> boughtProducts;

    @Transient
    @OneToMany(mappedBy = "bidder")
    List<Bid> biddings;

}
