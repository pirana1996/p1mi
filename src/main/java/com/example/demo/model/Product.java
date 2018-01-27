package com.example.demo.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="product")
public class Product {
    @Id
    int productId;

    @ManyToOne()
    @JoinColumn(name = "seller_id")
    Person seller;


    @ManyToOne()
    @JoinColumn(name = "buyer_id")
    Person buyer;

    @ManyToOne()
    @JoinColumn(name = "category_id")
    Category category;

    @OneToMany(mappedBy = "product")
    List<Picture> pictures;

    @OneToMany(mappedBy = "product")
    List<Bid> actualBiddings;

    String name;
    String description;
    String location;
    boolean isSold;
    boolean biddingAllowed;
    int price;


}
