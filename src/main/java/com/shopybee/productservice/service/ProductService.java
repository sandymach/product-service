package com.shopybee.productservice.service;

import com.shopybee.productservice.dto.ProductRequest;
import com.shopybee.productservice.dto.ProductResponse;
import com.shopybee.productservice.model.Product;
import com.shopybee.productservice.repo.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {

    private  final ProductRepository productRepository;
    public void createProduct(ProductRequest productRequest){
        Product product = Product.builder().name(productRequest.getName())
                .amount(productRequest.getAmount()).description(productRequest.getDescription()).build();
       productRepository.save(product);
       log.info("product  {} saved ",product.getId());

  }


    public List<ProductResponse> getAllProducts() {

        List<Product> products = productRepository.findAll();

        return  products.stream().map(product -> mapProductToProductResponse(product)) .collect(Collectors.toList())   ;
    }

    private ProductResponse mapProductToProductResponse(Product product) {
        return  ProductResponse.builder(). id(product.getId())
                 .name(product.getName())
                .amount(product.getAmount())
                .description(product.getDescription())
                .status("CREATED") .
                build();
    }
}
