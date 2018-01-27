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
    String description;

    @OneToMany(mappedBy = "seller")
    List<Product> productsSale;

    @OneToMany(mappedBy = "buyer")
    List<Product> productBuy;

    @OneToMany(mappedBy = "bidder")
    List<Bid> biddings;

}
