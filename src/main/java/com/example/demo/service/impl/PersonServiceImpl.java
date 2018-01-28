package com.example.demo.service.impl;

import com.example.demo.model.Bid;
import com.example.demo.model.Person;
import com.example.demo.model.Product;
import com.example.demo.persistence.BidDAO;
import com.example.demo.service.PersonService;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PersonServiceImpl implements PersonService {

    private BidDAO bidDAO;

    public PersonServiceImpl(BidDAO bidDAO) {
        this.bidDAO = bidDAO;
    }


    @Override
    public Person getPerson(Long id) {
        return null;
    }

    @Override
    public Iterable<Person> getAll() {
        return null;
    }

    @Override
    public Iterable<Product> getProductsOnSale(Long personId) {
        return null;
    }

    @Override
    public Iterable<Product> getBoughtProducts(Long personId) {
        return null;
    }

    @Override
    public Iterable<Product> getBiddedProducts(int personId) {
        try (Stream<Bid> stream = bidDAO.findAllByBidderPersonId(personId)) {
            return stream.map(bid -> bid.product).collect(Collectors.toList());
        }
    }
}
