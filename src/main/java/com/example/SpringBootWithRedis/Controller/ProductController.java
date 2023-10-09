package com.example.SpringBootWithRedis.Controller;

import com.example.SpringBootWithRedis.entity.Product;
import com.example.SpringBootWithRedis.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/product")
public class ProductController {
    @Autowired
    private ProductRepo productRepo;

    @PostMapping("/add")
    public Product save(@RequestBody Product product){
        return productRepo.save(product);
    }

    @GetMapping
    public List<Object> getAllProduct(){
        return productRepo.findAll();
    }

    @GetMapping("/{id}")
    public Product findProductById(@PathVariable int id){
        return (Product) productRepo.findProductById(id);
    }

    @DeleteMapping("/{id}")
    public String remove(@PathVariable int id){
        return productRepo.deleteProduct(id);
    }
}
