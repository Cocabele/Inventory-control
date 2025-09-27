package dev.santiago.invetorycontrol.controllers;

import dev.santiago.invetorycontrol.domain.Product;
import dev.santiago.invetorycontrol.dtos.ProductDto;
import dev.santiago.invetorycontrol.repository.ProductRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    ProductRepository repository;

    @GetMapping
    public ResponseEntity getAll(){
        List<Product> listProducts = repository.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(listProducts);
    }

    @PostMapping
    public ResponseEntity save(@RequestBody ProductDto dto){
        var product = new Product();
        BeanUtils.copyProperties(dto, product);
        return ResponseEntity.status((HttpStatus.CREATED)).body(repository.save(product));

    }
}
