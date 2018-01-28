package com.example.demo.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="product")
public class Product {

    public Product() {}

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


    public int getProductId() {
        return productId;
    }

    public Person getSeller() {
        return seller;
    }

    public Person getBuyer() {
        return buyer;
    }

    public Category getCategory() {
        return category;
    }

    public List<Picture> getPictures() {
        return pictures;
    }

    public List<Bid> getActualBiddings() {
        return actualBiddings;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getLocation() {
        return location;
    }

    public boolean isSold() {
        return isSold;
    }

    public boolean isBiddingAllowed() {
        return biddingAllowed;
    }

    public int getPrice() {
        return price;
    }
}
