package com.example.SpringBoot.Handlers;

import com.example.SpringBoot.Service.CleaningService;
import com.example.SpringBoot.Service.RankingService;
import com.example.SpringBoot.Service.RetrievalService;
import com.example.SpringBoot.model.CleanData;
import com.example.SpringBoot.model.Data;
import com.example.SpringBoot.model.Repository.DataRepository;
import com.example.SpringBoot.model.Result;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Service
public class RankHandler {

    @Autowired
    DataRepository dataRepository;

    @Autowired
    CleaningService cleaningService;

    @Autowired
    RankingService rankingService;

    @Autowired
    RetrievalService retrievalService;

    public List<Data> allhotels(){
        List<Data> dataList = new ArrayList<>();
        Iterable<Data> datas = dataRepository.findAll();

        for(Data x : datas)
            dataList.add(x);

        return dataList;
    }

    public List<Result> rank(String hotelids[]) throws JsonProcessingException {

        List<Data> hoteldata =  retrievalService.retrieval(hotelids);
        List<CleanData> cleandata = cleaningService.cleaning(hoteldata);
        List<Result> result = rankingService.rank(cleandata);
        return result;
    }
}
