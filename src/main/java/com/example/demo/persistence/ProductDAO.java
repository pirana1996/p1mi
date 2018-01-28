package com.example.demo.persistence;

import com.example.demo.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

public interface ProductDAO extends PagingAndSortingRepository<Product, Integer> {

    //@Query(value = "SELECT * FROM Product p " +
//            "WHERE :category " +
//            "AND :name " +
//            "AND :sellType ORDER BY ?#{#pageable}",
//            countQuery = "SELECT count(*) FROM Product p " +
//                    "WHERE :category " +
//                    "AND :name " +
//                    "AND :sellType",
//            nativeQuery = true)

//    @Query("SELECT p.name FROM Product p")
//    Iterable<Product> filterProducts();
//    @Param("category") String category,
//    @Param("name") String name,
//    @Param("sellType") String sellType


//        @Query(value = "SELECT p FROM Product p " +
//            "WHERE p.category = :category " +//price temporary
//                "AND p.name LIKE CONCAT('%',:name,'%') " +
//                "AND (p.biddingAllowed = :bid_al1 OR p.biddingAllowed = :bid_al2)")
//        Iterable<Product> filterProducts(@Param("category") int categoryId,
//                                         @Param("name") String name,
//                                         @Param("bid_al1") boolean biddingAllowed1, // (false if product has fixed price)
//                                         @Param("bid_al2") boolean biddingAllowed2);// (true if if product on bidding)
        /*Successfully executed example: http://localhost:8080/api/product/filter?categoryId=1&productName=Golf&sellType1=-1&sellType2=-1*/

    @Query(value = "SELECT p FROM Product p " +
            "WHERE p.category.categoryId = :category " +
            "AND p.name LIKE CONCAT('%',:name,'%') " +
            "AND (:all_types=true OR p.biddingAllowed=:sell_type)")
    Iterable<Product> filterProducts(@Param("category") int categoryId,
                                     @Param("name") String name,
//                                         @Param("bid_al1") boolean biddingAllowed1, // (false if product has fixed price)
//                                         @Param("bid_al2") boolean biddingAllowed2, // (true if if product on bidding)
                                     @Param("sell_type") boolean sellType,
                                     @Param("all_types") boolean allSellTypes);

    Iterable<Product> findAllBySellerPersonId(int id);
    Iterable<Product> findAllByBuyerPersonId(int id);

}