package com.example.demo.persistence;

import com.example.demo.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

public interface ProductDAO extends PagingAndSortingRepository<Product, Integer> {

    @Query(value = "SELECT p FROM Product p " +
            "WHERE p.category.categoryId = :category " +
            "AND p.name LIKE CONCAT('%',:name,'%') " +
            "AND (:all_types=true OR p.biddingAllowed=:sell_type)")
    Iterable<Product> filterProducts(@Param("category") int categoryId,
                                     @Param("name") String name,
                                     @Param("sell_type") boolean sellType,
                                     @Param("all_types") boolean allSellTypes);

    Iterable<Product> findAllBySellerPersonId(int id);
    Iterable<Product> findAllByBuyerPersonId(int id);
    Product save(Product p);

}