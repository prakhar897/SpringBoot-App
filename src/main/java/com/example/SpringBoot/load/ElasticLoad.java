package com.example.SpringBoot.load;

import com.example.SpringBoot.model.Data;
import com.example.SpringBoot.model.Repository.DataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class ElasticLoad {

    @Autowired
    ElasticsearchOperations operations;

    @Autowired
    DataRepository dataRepository;

    @PostConstruct
    @Transactional
    public void loadAll(){
        operations.putMapping(Data.class);
        System.out.println("Loading Data");
        dataRepository.saveAll(getData());
        System.out.printf("Loading Completed");

    }

    private List<Data> getData() {
        List<Data> datas = new ArrayList<>();
        datas.add(new Data("01516c15-7fcd-49bc-9b68-dbd218de8050","41275","26426834.0","15","0.25","0.0","4.1","4502.0","None","1272.0","False","hotel_details_page","23213.0","4966.0","1455.0","0.0","0.0","0.0"));
        datas.add(new Data("01516c15-7fcd-49bc-9b68-dbd218de8050","41275","26426834.0","15","0.25","0.0","4.1","4502.0","None","1272.0","False","hotel_details_page","23213.0","4966.0","1455.0","0.0","0.0","0.0"));
        datas.add(new Data("01516c15-7fcd-49bc-9b68-dbd218de8050","41275","26426834.0","15","0.25","0.0","4.1","4502.0","None","1272.0","False","hotel_impression","23213.0","4966.0","1455.0","0.0","0.0","0.0"));
        datas.add(new Data("01516c15-7fcd-49bc-9b68-dbd218de8050","9358","26426834.0","20","0.0","0.0","4.2","1049.0","None","2330.0","False","hotel_impression","9569.0","858.0","104.0","1.0","0.0","0.0"));
        datas.add(new Data("01516c15-7fcd-49bc-9b68-dbd218de8050","36622","26426834.0","5","0.0","0.0","4.2","1359.0","None","2183.0","False","hotel_impression","10770.0","880.0","225.0","2.0","0.0","0.0"));
        datas.add(new Data("01516c15-7fcd-49bc-9b68-dbd218de8050","55386","26426834.0","2","0.0","0.0","4.4","96.0","None","1422.0","False","hotel_details_page","22803.0","3494.0","780.0","0.0","0.0","0.0"));
        datas.add(new Data("01516c15-7fcd-49bc-9b68-dbd218de8050","55386","26426834.0","2","0.0","0.0","4.4","96.0","None","1422.0","False","hotel_impression","22803.0","3494.0","780.0","0.0","0.0","0.0"));
        datas.add(new Data("01516c15-7fcd-49bc-9b68-dbd218de8050","55386","26426834.0","2","0.0","0.0","4.4","96.0","None","1422.0","False","hotel_details_page","22803.0","3494.0","780.0","0.0","0.0","0.0"));
        datas.add(new Data("01516c15-7fcd-49bc-9b68-dbd218de8050","57900","26426834.0","4","0.0","0.0","4.5","1368.0","None","1188.0","False","hotel_impression","13853.0","2052.0","429.0","1.0","0.0","0.0"));
        datas.add(new Data("01516c15-7fcd-49bc-9b68-dbd218de8050","48624","26426834.0","1","0.5892857143","0.0","4.2","3170.0","None","1225.0","False","hotel_impression","29604.0","5504.0","947.0","0.0","0.0","0.0"));
        datas.add(new Data("01516c15-7fcd-49bc-9b68-dbd218de8050","54245","26426834.0","19","0.0","0.0","4.4","1349.0","None","1059.0","False","hotel_impression","33384.0","3810.0","1037.0","8.0","0.0","0.0"));
        datas.add(new Data("01516c15-7fcd-49bc-9b68-dbd218de8050","15049","26426834.0","10","0.0","0.0","4.2","1775.0","None","1634.0","False","hotel_details_page","44251.0","3179.0","597.0","4.0","0.0","0.0"));
        datas.add(new Data("01516c15-7fcd-49bc-9b68-dbd218de8050","15049","26426834.0","10","0.0","0.0","4.2","1775.0","None","1634.0","False","hotel_details_page","44251.0","3179.0","597.0","4.0","0.0","0.0"));
        datas.add(new Data("01516c15-7fcd-49bc-9b68-dbd218de8050","15049","26426834.0","10","0.0","0.0","4.2","1775.0","None","1634.0","False","hotel_impression","44251.0","3179.0","597.0","4.0","0.0","0.0"));
        datas.add(new Data("01516c15-7fcd-49bc-9b68-dbd218de8050","18014","26426834.0","8","0.0","0.0","4.2","2089.0","None","1748.0","False","hotel_impression","24832.0","3112.0","704.0","2.0","0.0","0.0"));
        datas.add(new Data("01516c15-7fcd-49bc-9b68-dbd218de8050","15048","26426834.0","12","0.5892857143","0.0","3.7","3738.0","None","913.0","False","hotel_impression","21075.0","5672.0","1601.0","0.0","0.0","0.0"));
        datas.add(new Data("01516c15-7fcd-49bc-9b68-dbd218de8050","58308","26426834.0","9","0.0","0.0","4.4","808.0","None","1293.0","False","hotel_impression","24243.0","4926.0","1494.0","1.0","0.0","0.0"));
        datas.add(new Data("01516c15-7fcd-49bc-9b68-dbd218de8050","16014","26426834.0","13","0.5428571429","0.0","4.6","3199.0","None","1885.0","False","hotel_impression","31183.0","4787.0","1155.0","1.0","0.0","0.0"));
        datas.add(new Data("01516c15-7fcd-49bc-9b68-dbd218de8050","53566","26426834.0","3","0.0","0.0","4.5","2522.0","None","1509.0","False","hotel_impression","18115.0","3049.0","766.0","0.0","0.0","0.0"));
        datas.add(new Data("01516c15-7fcd-49bc-9b68-dbd218de8050","41003","26426834.0","14","0.4285714286","0.0","3.6","2156.0","None","912.0","False","hotel_impression","19257.0","2640.0","758.0","0.0","0.0","0.0"));
        datas.add(new Data("01516c15-7fcd-49bc-9b68-dbd218de8050","45717","26426834.0","6","0.4285714286","0.0","4.1","3069.0","None","1305.0","False","hotel_impression","28079.0","4200.0","1366.0","3.0","0.0","0.0"));
        datas.add(new Data("01516c15-7fcd-49bc-9b68-dbd218de8050","59105","26426834.0","7","0.0","0.0","3.9","2809.0","None","1097.0","False","hotel_impression","29364.0","4887.0","1191.0","0.0","0.0","0.0"));
        datas.add(new Data("01516c15-7fcd-49bc-9b68-dbd218de8050","46308","26426834.0","17","0.5187165775","0.0","4.2","2605.0","None","1570.0","False","hotel_impression","41509.0","4606.0","1000.0","1.0","0.0","0.0"));
        datas.add(new Data("01516c15-7fcd-49bc-9b68-dbd218de8050","38959","26426834.0","16","0.3269230769","0.0","4.5","3495.0","None","1532.0","False","hotel_impression","27377.0","6227.0","1548.0","0.0","0.0","0.0"));
        datas.add(new Data("01516c15-7fcd-49bc-9b68-dbd218de8050","52317","26426834.0","11","0.0","0.0","4.5","2966.0","None","1871.0","False","hotel_impression","21887.0","2257.0","398.0","3.0","0.0","0.0"));
        datas.add(new Data("01516c15-7fcd-49bc-9b68-dbd218de8050","51342","26426834.0","18","0.4285714286","0.0","4.4","1878.0","None","1080.0","False","hotel_impression","17509.0","3014.0","591.0","4.0","0.0","0.0"));
        return datas;
    }
}
