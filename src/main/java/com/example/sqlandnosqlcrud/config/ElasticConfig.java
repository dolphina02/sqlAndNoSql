//package com.example.sqlandnosqlcrud.config;
//
//
//import co.elastic.clients.elasticsearch.ElasticsearchClient;
//import co.elastic.clients.json.jackson.JacksonJsonpMapper;
//import co.elastic.clients.transport.rest_client.RestClientTransport;
//import org.apache.http.HttpHost;
//import org.apache.http.auth.AuthScope;
//import org.apache.http.auth.UsernamePasswordCredentials;
//import org.apache.http.impl.client.BasicCredentialsProvider;
//import org.elasticsearch.client.RestClient;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class ElasticConfig {
//
//
//    @Value("${spring.elasticsearch.uris}")
//    private String host;
//
//    @Value("${spring.elasticsearch.port}")
//    private int port;
//
//    @Value("${spring.elasticsearch.username}")
//    private String userId;
//
//    @Value("${spring.elasticsearch.password}")
//    private String password;
//
//    @Bean(destroyMethod = "close")
//    public RestClient restClient() {
//        final BasicCredentialsProvider credentialsProvider = new BasicCredentialsProvider();
//        credentialsProvider.setCredentials(AuthScope.ANY,
//                new UsernamePasswordCredentials(userId, password));
//
//        return RestClient.builder(new HttpHost(host, port))
//                .setHttpClientConfigCallback(httpClientBuilder ->
//                        httpClientBuilder.setDefaultCredentialsProvider(credentialsProvider))
//                .build();
//    }
////    @Bean(destroyMethod = "close")
////    public RestClient restClient() {
////        return RestClient.builder(new HttpHost(host, port))
////                .build();
////    }
//
//    @Bean
//    public ElasticsearchClient elasticsearchClient(RestClient restClient) {
//        RestClientTransport transport = new RestClientTransport(restClient, new JacksonJsonpMapper());
//        return new ElasticsearchClient(transport);
//    }
//}