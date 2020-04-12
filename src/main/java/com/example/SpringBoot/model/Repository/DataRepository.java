package com.example.SpringBoot.model.Repository;

import com.example.SpringBoot.model.Data;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface DataRepository  extends ElasticsearchRepository<Data,String> {

}
