package com.example.training_project2.Searchmicroservice.controllers;

import com.example.training_project2.Searchmicroservice.DTOs.ProductDTO;
import com.example.training_project2.Searchmicroservice.DTOs.SuccessFailureResponseDTO;
import com.example.training_project2.Searchmicroservice.builder.SearchQueryBuilder;
import com.example.training_project2.Searchmicroservice.model.Product;
import com.example.training_project2.Searchmicroservice.repository.ProductRepository;
import com.example.training_project2.Searchmicroservice.service.SearchService;
import com.oracle.tools.packager.Log;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
public class SearchController {


    @Autowired
    private SearchService searchService;


    @Autowired
    private SearchQueryBuilder searchQueryBuilder;


    // FOR DEBUGGING
    @GetMapping(value = "/search_all")
    public List<ProductDTO> searchAll() {
        return searchService.search_all();
    }



    @GetMapping(value = "search")
    public List<Product> searchByQuerry( @RequestParam String searchParam) {
        Log.info("Getting into search builder");
        return searchQueryBuilder.getByMasterSearch(searchParam);
    }


    @PostMapping("/loadData")
    public SuccessFailureResponseDTO loadData(@RequestBody ProductDTO productDTO) {
         return searchService.loadData(productDTO);

    }



    // For Debugging :
    // TODO : find a way to access elastic database through command line and remove this endpoint to be accessed by user
    @DeleteMapping("/deleteAllData")
    public SuccessFailureResponseDTO deleteAllData() {
            return searchService.delete_all();

    }

    //    // For Debugging
//    @DeleteMapping("/delete")
//    public Boolean deleteAllData(@RequestParam(value = "productId") String productId) {
//        try {
//            productRepository.delete(productId);
//            return true;
//        } catch (Exception e) {
//            return false;
//        }
//
//    }


}
