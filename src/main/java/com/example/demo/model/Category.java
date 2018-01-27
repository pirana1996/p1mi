package com.example.demo.model;


import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="category")
public class Category {
    @Id
    int categoryId;

    @ManyToOne
    @JoinColumn(name = "super_category_id")
    Category parent;

//  It is not mandatory to define this reverse relation because of the ManyToOne annotation above.
    @OneToMany(mappedBy="parent")
    List<Category> reply;

    @OneToMany(mappedBy = "category")
    List<Product> products;

    String name;
}
