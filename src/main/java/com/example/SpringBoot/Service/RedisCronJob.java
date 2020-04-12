package com.example.SpringBoot.Service;

import com.example.SpringBoot.model.Data;
import com.example.SpringBoot.model.RedisData;
import com.example.SpringBoot.model.Repository.DataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;


@SpringBootApplication
@EnableScheduling
public class RedisCronJob {

    @Autowired
    private DataRepository dataRepository;

    @Autowired
    private RedisData redisData;

    @Scheduled(fixedRate = 10000)
    public void Job(){

        System.out.println("Cron Job Running");

        Iterable<Data> datas = dataRepository.findAll();
        for(Data x : datas)
            redisData.save(x);

        //List<Data> record = redisData.findAll();
        //System.out.println(record);

    }
}
