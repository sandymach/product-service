package com.shopybee.productservice.controller;

import com.shopybee.productservice.dto.ProductRequest;
import com.shopybee.productservice.dto.ProductResponse;
import com.shopybee.productservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductController {

    private final  ProductService productService;



    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createProduct(@RequestBody ProductRequest request){
        productService.createProduct(request);

    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProductResponse> getProducts(){

      return  productService.getAllProducts();
        }


}
