package com.example.SpringBoot.api;

import com.example.SpringBoot.Handlers.RankHandler;
import com.example.SpringBoot.Service.CleaningService;
import com.example.SpringBoot.Service.RankingService;
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
    RankHandler rankHandler;

    @RequestMapping(value = "/allhotels")
    public List<Data> allhotels(){
        return rankHandler.allhotels();
    }

    @RequestMapping(method = RequestMethod.POST,value="/rank")
    public List<Result> rank(@RequestBody String hotelids[]) throws JsonProcessingException {
        return rankHandler.rank(hotelids);
    }

}
