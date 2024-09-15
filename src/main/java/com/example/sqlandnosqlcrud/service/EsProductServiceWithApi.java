//package com.example.sqlandnosqlcrud.service;
//
//import co.elastic.clients.elasticsearch.ElasticsearchClient;
//import co.elastic.clients.elasticsearch.core.IndexRequest;
//import co.elastic.clients.elasticsearch.core.IndexResponse;
//import co.elastic.clients.elasticsearch.core.SearchRequest;
//import co.elastic.clients.elasticsearch.core.SearchResponse;
//import com.example.sqlandnosqlcrud.entity.Product;
//import co.elastic.clients.elasticsearch.core.search.Hit;
//import org.springframework.stereotype.Service;
//
//import java.io.IOException;
//import java.util.List;
//
//@Service
//public class EsProductServiceWithApi {
//
//    private final ElasticsearchClient elasticsearchClient;
//
//    public EsProductServiceWithApi(ElasticsearchClient elasticsearchClient) {
//        this.elasticsearchClient = elasticsearchClient;
//    }
//
//    // Product 문서를 Elasticsearch에 삽입하는 메서드
//    public String addProduct(Product product) {
//        try {
//            // 색인 요청 생성
//            IndexRequest<Product> request = IndexRequest.of(i -> i
//                    .index("productinfo_api") // 인덱스 이름
//                    .id(product.getId().toString()) // 문서 ID 설정
//                    .document(product) // 삽입할 문서
//            );
//
//            // Elasticsearch에 색인 실행
//            IndexResponse response = elasticsearchClient.index(request);
//
//            // 응답 결과 반환
//            return response.id(); // 성공적으로 삽입된 문서의 ID 반환
//        } catch (IOException e) {
//            e.printStackTrace();
//            throw new RuntimeException("Failed to index product", e);
//        }
//    }
//
//    public List<Product> getProductInfoByDescriptionWithKeyword(String keyword) {
//        try {
//            // SearchRequest 생성
//            SearchRequest searchRequest = SearchRequest.of(s -> s
//                    .index("productinfo_api") // 인덱스 이름
//                    .query(q -> q
//                            .match(m -> m
//                                    .field("description")
//                                    .query(keyword))));
//
//            // 검색 실행
//            SearchResponse<Product> response = elasticsearchClient.search(searchRequest, Product.class);
//
//            // 검색 결과 반환
//            return response.hits().hits().stream()
//                    .map(Hit::source)
//                    .toList();
//
//        } catch (IOException e) {
//            e.printStackTrace();
//            throw new RuntimeException("Failed to search products", e);
//        }
//    }
//
//}
