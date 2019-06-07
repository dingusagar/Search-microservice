package com.example.training_project2.Searchmicroservice.service;

import com.example.training_project2.Searchmicroservice.DTOs.ProductDTO;
import com.example.training_project2.Searchmicroservice.DTOs.SuccessFailureResponseDTO;
import com.example.training_project2.Searchmicroservice.model.Product;
import com.example.training_project2.Searchmicroservice.repository.ProductRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SearchServiceImpl implements SearchService {

    @Autowired
    ProductRepository productRepository;


    @Override
    public SuccessFailureResponseDTO loadData(ProductDTO productDTO) {
        try {
            Product product = new Product();
            BeanUtils.copyProperties(productDTO,product);
            productRepository.save(product);
            return new SuccessFailureResponseDTO(true,"Insertion Successful");
        } catch (Exception e) {
            return new SuccessFailureResponseDTO(false,"Something went wrong while inserting");
        }
    }

    @Override
    public List<ProductDTO> search_all() {
        List<ProductDTO> productDTOList = new ArrayList<>();
        Iterable<Product> products = productRepository.findAll();

        for(Product product : products){
            ProductDTO productDTO = new ProductDTO();
            BeanUtils.copyProperties(product,productDTO);
            productDTOList.add(productDTO);
        }
        return productDTOList;
    }

    @Override
    public SuccessFailureResponseDTO delete_all() {
        try {
            productRepository.deleteAll();
            return new SuccessFailureResponseDTO(true,"Deleted");
        } catch (Exception e) {
            return new SuccessFailureResponseDTO(false,"Error deleting");
        }
    }


}
