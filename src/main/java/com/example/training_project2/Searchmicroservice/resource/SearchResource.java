package com.example.training_project2.Searchmicroservice.resource;

import com.example.training_project2.Searchmicroservice.builder.SearchQueryBuilder;
import com.example.training_project2.Searchmicroservice.model.Product;
import com.example.training_project2.Searchmicroservice.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;



@RestController
public class SearchResource {

    @Autowired
    ProductRepository productRepository;

//    @GetMapping(value = "/{search_text}")
//    public List<ProductSimple> search(@PathVariable final String search_text) {
//        return productRepository.findByProductName(search_text);
//    }
//




    @GetMapping(value = "/search_all")
    public List<Product> searchAll() {
        List<Product> productList = new ArrayList<>();
        Iterable<Product> products = productRepository.findAll();
        products.forEach(productList::add);
        return productList;
    }



    @Autowired
    private SearchQueryBuilder searchQueryBuilder;

    @GetMapping(value = "search/{text}")
    public List<Product> getAll(@PathVariable final String text) {
        return searchQueryBuilder.getAll(text);
    }


    @PostMapping("/loadData")
    public Boolean createEmployee(@RequestBody Product product ){
        try {
            productRepository.save(product);
            return true;
        } catch (Exception e) {
            return false;
        }

    }


}
