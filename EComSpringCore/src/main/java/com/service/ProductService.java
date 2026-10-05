package com.service;

import com.dto.ProductDTO;
import com.exception.InvalidListException;
import com.model.Category;
import com.model.Product;
import com.model.Vendor;
import com.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }


    public void save(String name, double price, Long stockQty, Category category, Vendor vendor) {
        int productId = (int)(Math.random()*10000);
        Product product = new Product(productId , name , price , stockQty , category , vendor);
        productRepository.insertProduct(product);
    }

    public ProductDTO findById(int productId) {
        List<ProductDTO> productList = productRepository.fetchById(productId);
        if(productList == null || productList.isEmpty()){
            throw new InvalidListException("List given is null or empty");
        }
        return  productList.getFirst();
    }

    public void updateStock(int productId, Long newStockQty) throws SQLException {
        productRepository.updateProductStock(productId , newStockQty);
    }

    public Map<String, Integer> countProductsByVendor() {

        List<Map.Entry<String, Integer>> mapEntries = productRepository.countProductByVendor();

        if(mapEntries == null || mapEntries.isEmpty()){
            throw new InvalidListException("List given is null or empty");
        }
//        Map<String, Integer> map = new HashMap<>();
//        map = mapEntries
//                .stream()
//                .collect(Collectors.toMap(
//                        Map.Entry::getKey,
//                        Map.Entry::getValue
//                ));

        return new HashMap<>(mapEntries
                    .stream()
                    .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue
                )));

    }
}
