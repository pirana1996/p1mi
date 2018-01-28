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

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public void setSeller(Person seller) {
        this.seller = seller;
    }

    public void setBuyer(Person buyer) {
        this.buyer = buyer;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setPictures(List<Picture> pictures) {
        this.pictures = pictures;
    }

    public void setActualBiddings(List<Bid> actualBiddings) {
        this.actualBiddings = actualBiddings;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setSold(boolean sold) {
        isSold = sold;
    }

    public void setBiddingAllowed(boolean biddingAllowed) {
        this.biddingAllowed = biddingAllowed;
    }

    public void setPrice(int price) {
        this.price = price;
    }

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
