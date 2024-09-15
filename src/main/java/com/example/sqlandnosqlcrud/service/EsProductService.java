package com.example.sqlandnosqlcrud.service;

import com.example.sqlandnosqlcrud.entity.Product;
import com.example.sqlandnosqlcrud.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EsProductService {

    @Autowired
    private ProductRepository productRepository;

    public void setProductinfo (Product productInfo) {
        productRepository.save(productInfo);
    }

    public List<Product> getProductInfoByKeyword (String keyword) {
        List<Product> productList = productRepository.findProductInfoByDescriptionMatches(keyword);
        return productList;
    }

    public Product saveProductInfo(Product productInfo) {
        return productRepository.save(productInfo);
    }

    public Optional<Product> getProductInfoById(String id) {
        return productRepository.findById(id);
    }

    public Iterable<Product> getAllProductInfo() {
        return productRepository.findAll();
    }

    public void deleteProductInfoById(String id) {
        productRepository.deleteById(id);
    }
}
