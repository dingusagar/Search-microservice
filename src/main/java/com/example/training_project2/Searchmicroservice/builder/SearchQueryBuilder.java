package com.example.training_project2.Searchmicroservice.builder;

import com.example.training_project2.Searchmicroservice.model.Product;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.stereotype.Component;

import java.util.List;

import static org.elasticsearch.index.query.QueryBuilders.boolQuery;
import static org.elasticsearch.index.query.QueryBuilders.termQuery;

@Component
public class SearchQueryBuilder {

    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;


    public List<Product> getAll(String requestParam) {


        QueryBuilder query = boolQuery()
                .should(
                        QueryBuilders.queryStringQuery(requestParam)
                                .lenient(true)
                                .field("productName")
                                .field("category")
                                .field("description")
                ).should(QueryBuilders.queryStringQuery("*" + requestParam + "*")
                        .lenient(true)
                        .field("productName")
                        .field("category")
                        .field("description")
                );

        QueryBuilder filterQuery = QueryBuilders.nestedQuery(
                "variants", boolQuery().should(termQuery("variants.ram", requestParam)).should(
                        termQuery("variants.colour", requestParam)));

        NativeSearchQuery build = new NativeSearchQueryBuilder()
                .withQuery(query)
                .withQuery(filterQuery)
                .build();

        List<Product> products = elasticsearchTemplate.queryForList(build, Product.class);

        return products;
    }
}
