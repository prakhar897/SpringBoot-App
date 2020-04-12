package com.example.SpringBoot.Service;

import com.example.SpringBoot.model.CleanData;
import com.example.SpringBoot.model.Result;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class RankingService {

    public static List<Result> rank(List<CleanData> data) throws JsonProcessingException {

        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);

        final String uri = "http://localhost:5000/predict";
        RestTemplate restTemplate = new RestTemplate();

        HttpEntity<Object> requestEntity = new HttpEntity<Object>(data);
        ResponseEntity<List<Result>> responseEntity= restTemplate.exchange(uri, HttpMethod.POST, requestEntity,new ParameterizedTypeReference<List<Result>>() {});
        List<Result> result = responseEntity.getBody();
        //System.out.println(result);
        return result;
    }
}
