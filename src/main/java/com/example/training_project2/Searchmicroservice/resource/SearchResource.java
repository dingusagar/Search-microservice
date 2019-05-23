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

    @GetMapping(value = "search")

    public List<Product> getAll( @RequestParam String searchParam) {

        return searchQueryBuilder.getAll(searchParam);
    }


    @PostMapping("/loadData")
    public Boolean createEmployee(@RequestBody Product product) {
        try {
            productRepository.save(product);
            return true;
        } catch (Exception e) {
            return false;
        }

    }


    @DeleteMapping("/deleteAllData")
    public Boolean deleteAllData() {
        try {
            productRepository.deleteAll();
            return true;
        } catch (Exception e) {
            return false;
        }

    }


}
