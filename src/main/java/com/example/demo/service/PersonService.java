package com.example.demo.service;

import com.example.demo.model.Person;
import com.example.demo.model.Product;

public interface PersonService {

    Person getPerson(int id);

    Iterable<Person> getAll();

    Iterable<Product> getProductsOnSale(int personId);

    Iterable<Product> getBoughtProducts(int personId);

    Iterable<Product> getBiddedProducts(int personId);
}
