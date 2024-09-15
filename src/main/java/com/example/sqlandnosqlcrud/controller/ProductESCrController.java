package com.example.sqlandnosqlcrud.controller;

import com.example.sqlandnosqlcrud.entity.Product;
import com.example.sqlandnosqlcrud.service.EsProductService;
//import com.example.sqlandnosqlcrud.service.EsProductServiceWithApi;
//import io.swagger.v3.oas.annotations.security.OAuthFlow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductESCrController {

    @Autowired
    EsProductService esProductService;
//
//    @Autowired
//    EsProductServiceWithApi esProductServiceWithApi;


    @PostMapping(value = "/nosql/product")
    public ResponseEntity<?> setProductInfo (@RequestBody Product productInfo ) throws IOException {
        esProductService.setProductinfo(productInfo);
        List<Product> productList = esProductService.getProductInfoByKeyword("");

        return new ResponseEntity<>(productList, HttpStatus.OK);
    }
//
//    @PostMapping(value = "/nosql/api/product")
//    public ResponseEntity<?> setProductInfoWithApi (@RequestBody Product productInfo ) throws IOException {
//        esProductServiceWithApi.addProduct(productInfo);
//
//        return new ResponseEntity<>(null, HttpStatus.OK);
//    }

    @GetMapping(value = "/nosql/product")
    public ResponseEntity<?> getProductInfo (@RequestParam String keyword ) throws IOException {
        List<Product> productList = esProductService.getProductInfoByKeyword(keyword);
        return new ResponseEntity<>(productList, HttpStatus.OK);
    }
//
//    @GetMapping(value = "/nosql/api/product")
//    public ResponseEntity<?> getProductInfoWithApi (@RequestParam String keyword ) throws IOException {
//        List<Product> productList = esProductServiceWithApi.getProductInfoByDescriptionWithKeyword(keyword);
//        return new ResponseEntity<>(productList, HttpStatus.OK);
//    }
}
