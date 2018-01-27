package com.example.demo.model;

import javax.persistence.*;

@Entity
@Table(name="picture")
public class Picture {
    @Id
    int pictureId;

    @ManyToOne
    @JoinColumn(name = "product_id")
    Product product;

    String content;
}
