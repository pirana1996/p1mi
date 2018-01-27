package com.example.demo.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name="comment")
public class Comment {
    @Id
    int commentId;

    @ManyToOne
    @JoinColumn(name = "person_id")
    Person person;//old:user

    @ManyToOne
    @JoinColumn(name = "product_id")
    Product product;

    @ManyToOne
    @JoinColumn(name = "repy_to")
    Comment parent;

//  It is not mandatory to define this reverse relation because of the ManyToOne annotation above.
    @OneToMany(mappedBy="parent")
    List<Comment> reply;

    String content;
    Timestamp dateTime;
}
