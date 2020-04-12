package com.example.SpringBoot.config;

import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

import java.net.InetAddress;

@Configuration
@EnableElasticsearchRepositories(basePackages = "com.example.SpringBoot.model.Repository")
@ComponentScan(basePackages = { "com.example.SpringBoot.Service" })
public class ElasticSearchConfiuration {

    @Value("${elasticsearch.home:/usr/local/Cellar/elasticsearch/7.6.1}")
    private String elasticsearchHome;

    @Value("${elasticsearch.cluster.name:elasticsearch}")
    private String clusterName;

    @Bean
    public Client client() {
        Settings elasticsearchSettings = Settings.builder()
                .put("client.transport.sniff", true)
                .put("path.home", elasticsearchHome)
                .put("cluster.name", clusterName).build();
        try {
            Client client = new PreBuiltTransportClient(elasticsearchSettings)
                                    .addTransportAddress(new TransportAddress(InetAddress.getByName("127.0.0.1"), 9300));
            return client;
        }catch(Exception e){}
        return new PreBuiltTransportClient(elasticsearchSettings);
    }

    @Bean
    public ElasticsearchOperations elasticsearchTemplate() {
        return new ElasticsearchTemplate(client());
    }

}
