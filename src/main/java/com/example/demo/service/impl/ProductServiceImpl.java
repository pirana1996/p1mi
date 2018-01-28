package com.example.demo.service.impl;

import com.example.demo.model.Product;
import com.example.demo.persistence.ProductDAO;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductDAO productDAO;

    @Autowired
    public ProductServiceImpl(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    @Override
    public Iterable<Product> getFilteredProducts(int categoryId, String name, int sellType) {
//        if (categoryId.equals("-1")) qCategory = "p.category_id >= 0";
//        else qCategory = "p.category_id = " + categoryId;
//        if (name.equals("-1")) qName = "p.name LIKE %";
//        else qName = "p.name = " + name;
        boolean qSellType = false;//default false
        boolean qFindAllSellTypes = false;
        if (sellType == -1) qFindAllSellTypes = true;
        else if (sellType == 1) qSellType = true;

        return this.productDAO.filterProducts(categoryId, name, qSellType, qFindAllSellTypes);
    }

    @Override
    public List<Product> getAllProducts() {
        return null;
    }

    @Override
    public Product addProduct() {
        return null;
    }

    @Override
    public Product updateProduct() {
        return null;
    }

    @Override
    public boolean deleteProduct() {
        return false;
    }
}
