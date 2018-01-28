package com.example.demo.model;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "bid")
public class Bid {
    @Id
    int bidId;

    int amount;

    Timestamp dateTime;

    @ManyToOne
    @JoinColumn(name = "bidder_id")
    Person bidder;

    @ManyToOne
    @JoinColumn(name = "product_id")
    public Product product;

}
