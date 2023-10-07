package com.example.SpringBootWithRedis.Controller;

import com.example.SpringBootWithRedis.entity.Product;
import com.example.SpringBootWithRedis.repository.ProductRepo;
import jdk.dynalink.linker.LinkerServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/product")
public class ProductController {
    @Autowired
    private ProductRepo productRepo;
    public Product save(@RequestBody Product product){
        return productRepo.save(product);
    }

    @GetMapping
    public List<Product> getAllProduct(){
        return productRepo.findAll();
    }

    @GetMapping("/{id}")
    public Product findProductById(@PathVariable int id){
        return productRepo.findProductById(id);
    }

    @DeleteMapping("/{id}")
    public String remove(@PathVariable int id){
        return productRepo.deleteProduct(id);
    }
}
