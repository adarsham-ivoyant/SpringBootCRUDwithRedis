package com.example.SpringBootWithRedis.repository;

import com.example.SpringBootWithRedis.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ProductRepo {
        public static final String HASH_KEY="Product";
    @Autowired
    private RedisTemplate<String,Object> redisTemplate;
    @Autowired
    public ProductRepo(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
        this.hashOperations = redisTemplate.opsForHash();
    }

    private  HashOperations<String,Integer,Object> hashOperations;



        public Product save(Product product){
            hashOperations.put(HASH_KEY,product.getId(),product);
//            redisTemplate.opsForHash().put(HASH_KEY,product.getId(),product);
            return product;
        }
        public List<Object> findAll(){
            Map<Integer,Object> products = hashOperations.entries(HASH_KEY);
            return new ArrayList<>(products.values());
            //return redisTemplate.opsForHash().values(HASH_KEY);
        }

        public Object findProductById(int id){
            return hashOperations.get(HASH_KEY,id);
        }

        public String deleteProduct(int id){
//            redisTemplate.opsForHash().delete(HASH_KEY,id);
            return "Product removed";
        }
}
