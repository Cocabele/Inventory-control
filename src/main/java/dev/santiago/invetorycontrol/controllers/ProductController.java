package dev.santiago.invetorycontrol.controllers;

import dev.santiago.invetorycontrol.domain.Product;
import dev.santiago.invetorycontrol.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    ProductRepository repository;

    @GetMapping
    public ResponseEntity getAll(){
        List<Product> listProduct = repository.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(listProduct);
    }
}
