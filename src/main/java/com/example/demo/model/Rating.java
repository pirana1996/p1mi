package com.example.demo.model;

import javax.persistence.*;

@Entity
@Table(name = "rating")
public class Rating {

    @Id
    int ratingId;

    int stars;

    String comment;

    @ManyToOne
    @JoinColumn(name = "buyer_id")
    Person buyer;

    @ManyToOne
    @JoinColumn(name = "seller_id")
    Person seller;

}
