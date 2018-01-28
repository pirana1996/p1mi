package com.example.demo.service.impl;

import com.example.demo.model.Bid;
import com.example.demo.model.Person;
import com.example.demo.model.Product;
import com.example.demo.persistence.BidDAO;
import com.example.demo.persistence.PersonDAO;
import com.example.demo.persistence.ProductDAO;
import com.example.demo.service.PersonService;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PersonServiceImpl implements PersonService {

    private BidDAO bidDAO;
    private ProductDAO productDAO;
    private PersonDAO personDAO;

    public PersonServiceImpl(PersonDAO personDAO, BidDAO bidDAO, ProductDAO productDAO) {
        this.personDAO = personDAO;
        this.bidDAO = bidDAO;
        this.productDAO = productDAO;
    }


    @Override
    public Person getPerson(int id) {
       return this.personDAO.findByPersonId(id).get();
    }

    @Override
    public Iterable<Person> getAll() {
        return this.personDAO.findAll();
    }

    @Override
    public Iterable<Product> getProductsOnSale(int sellerID) {
        return this.productDAO.findAllBySellerPersonId(sellerID);
    }

    @Override
    public Iterable<Product> getBoughtProducts(int buyerId) {
        return this.productDAO.findAllByBuyerPersonId(buyerId);
    }

    @Override
    public Iterable<Product> getBiddedProducts(int personId) {
        try (Stream<Bid> stream = bidDAO.findAllByBidderPersonId(personId)) {
            return stream.map(bid -> bid.product).collect(Collectors.toList());
        }
    }
}
