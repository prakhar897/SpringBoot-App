package com.example.SpringBoot.Service;

import com.example.SpringBoot.model.CleanData;
import com.example.SpringBoot.model.Result;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Random;

@Service
public class RankingService {

    RestTemplate restTemplate;

    public RankingService(){
        restTemplate = new RestTemplate();
    }

    public List<Result> rank(List<CleanData> cleandata) throws JsonProcessingException {

        final String uri = "http://localhost:5000/predict/" + generateCityId();
        HttpEntity<Object> requestEntity = new HttpEntity<Object>(cleandata);

        System.out.println(requestEntity);

        ResponseEntity<List<Result>> responseEntity= restTemplate.exchange(uri, HttpMethod.POST, requestEntity,new ParameterizedTypeReference<List<Result>>() {});
        List<Result> result = responseEntity.getBody();
        //System.out.println(result);
        return result;
    }

    private int generateCityId(){
        Random rand = new Random();
        int num = rand.nextInt(12);
        if(num%2 == 0)
            return 6;
        else
            return 12;
    }
}
