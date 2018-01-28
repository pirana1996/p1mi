package com.example.demo.service;

import com.example.demo.model.Person;
import com.example.demo.model.Product;

public interface PersonService {

    Person getPerson(Long id);

    Iterable<Person> getAll();

    Iterable<Product> getProductsOnSale(Long personId);

    Iterable<Product> getBoughtProducts(Long personId);

    Iterable<Product> getBiddedProducts(int personId);
}
