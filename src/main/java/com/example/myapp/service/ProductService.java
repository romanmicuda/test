package com.example.myapp.service;

import com.example.myapp.model.Product;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.Map;

@Service
public class ProductService {

    public Product readProductsFromJson(String jsonFilePath) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(new File(jsonFilePath), Product.class);
    }

    public void printProducts(Product product) {
        System.out.println("fruits");
        product.getFruits().forEach((fruit, colors) -> {
            System.out.println(".. " + fruit);
            colors.forEach((color, value) -> {
                System.out.println(".... " + color);
            });
        });

        System.out.println("vegetables");
        product.getVegetables().forEach((vegetable, colors) -> {
            System.out.println(".. " + vegetable);
            colors.forEach((color, value) -> {
                System.out.println(".... " + color);
            });
        });
    }

}
