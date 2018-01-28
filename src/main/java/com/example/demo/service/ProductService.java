package com.example.demo.service;

import com.example.demo.model.Product;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface ProductService {
    Iterable<Product> getFilteredProducts(int categoryId, String name, int sellType);
    Iterable<Product> getAllProducts();
    Product addProduct();
    Product updateProduct();
    boolean deleteProduct();
}
