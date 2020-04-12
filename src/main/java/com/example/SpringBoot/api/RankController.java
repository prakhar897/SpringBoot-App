package com.example.SpringBoot.api;

import com.example.SpringBoot.Service.CleaningService;
import com.example.SpringBoot.Service.RankingService;
import com.example.SpringBoot.Service.RedisCronJob;
import com.example.SpringBoot.model.CleanData;
import com.example.SpringBoot.model.Data;
import com.example.SpringBoot.model.Repository.DataRepository;
import com.example.SpringBoot.model.Result;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class RankController {

    @Autowired
    DataRepository dataRepository;

    @Autowired
    CleaningService cleaningService;

    @Autowired
    RankingService rankingService;

    @RequestMapping(value = "/allhotels")
    public List<Data> allhotels(){
        List<Data> dataList = new ArrayList<>();
        Iterable<Data> datas = dataRepository.findAll();

        for(Data x : datas)
            dataList.add(x);

        return dataList;
    }

    @RequestMapping("/hotel/{id}")
    public Optional<Data> findhotel(@PathVariable String id){
        Optional<Data> hotel = dataRepository.findById(id);
        return hotel;
    }

    @RequestMapping(method = RequestMethod.POST,value="/rank")
    public List<Result> rank(@RequestBody String hotelids[]) throws JsonProcessingException {

        List<Data> hoteldata =  cleaningService.retrieval(hotelids);
        List<CleanData> cleandata = cleaningService.cleaning(hoteldata);
        List<Result> result = rankingService.rank(cleandata);

        return result;
    }

}
