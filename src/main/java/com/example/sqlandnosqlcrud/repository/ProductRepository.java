package com.example.sqlandnosqlcrud.repository;


import com.example.sqlandnosqlcrud.entity.Product;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends ElasticsearchRepository<Product, String> {

    List<Product> findProductInfoByDescriptionMatches(String keyword);
}