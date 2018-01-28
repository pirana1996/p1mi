package com.example.demo.persistence;

import com.example.demo.model.Bid;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;
import java.util.stream.Stream;

public interface BidDAO extends PagingAndSortingRepository<Bid, Integer> {

    Optional<Bid> findByBidId(int id);

    Stream<Bid> findAllByProductProductId(int productId);

    Stream<Bid> findAllByBidderPersonId(int personId);

}
