package com.example.demo.model;
import java.sql.Connection;
import org.postgresql.geometric.*;
import java.sql.Driver;

public class Product {
    int productId;
    int sellerId;
    int buyerId;
    int categoryId;
    String name;
    String description;
    PGpoint p;

}
