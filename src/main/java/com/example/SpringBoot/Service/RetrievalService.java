package com.example.SpringBoot.Service;

import com.example.SpringBoot.model.Data;
import com.example.SpringBoot.model.RedisData;
import com.example.SpringBoot.model.Repository.DataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RetrievalService {

    @Autowired
    DataRepository dataRepository;

    @Autowired
    RedisData redisData;

    public List<Data> retrieval(String hotelids[]){
        List<Data> hoteldata = new ArrayList<>();
        for(String id : hotelids){
            Optional<Data> retOpt;
            retOpt = Optional.ofNullable(redisData.findById(id));
            if(retOpt == null) {
                System.out.println("Not found in Redis, Searching in ES");
                retOpt = dataRepository.findById(id);
            }
            Data ret = retOpt.orElse(null);
            if(ret != null)
                hoteldata.add(ret);
            else
                System.out.println("HotelId: " + id + " not found in data");
        }
        return hoteldata;
    }

}
