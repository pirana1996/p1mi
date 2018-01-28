package com.example.demo.web;

import com.example.demo.model.Product;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@RequestMapping(value = "api/product", produces = APPLICATION_JSON_VALUE)
@CrossOrigin
public class ProductController {

    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping(value = "filter", method = GET)
    Iterable<Product> getFilteredProducts(@RequestParam int categoryId,
                                          @RequestParam String productName,
                                          @RequestParam int sellType){
        return this.productService.getFilteredProducts(categoryId, productName, sellType);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Product createProduct(@RequestBody Product product){
        productService.addProduct(product);
        return product;
    }

}
