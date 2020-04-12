package com.example.SpringBoot.model;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RedisData{

    private HashOperations hashOperations;

    private RedisTemplate<String,Object> redisTemplate;

    public RedisData(RedisTemplate<String,Object> redisTemplate){
        this.redisTemplate = redisTemplate;
        this.hashOperations = this.redisTemplate.opsForHash();
    }

    public void save(Data data){
        hashOperations.put("Data", data.hotelId, data);
    }

    public Data findById(String id){
        return (Data) hashOperations.get("Data", id);
    }

    public List<Data> findAll(){
        return hashOperations.values("Data");
    }
}