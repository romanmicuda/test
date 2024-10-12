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

    public String findMax(Product product) {
        int maxValue = Integer.MIN_VALUE;
        String maxDescription = "";
        boolean found = false;

        for (Map.Entry<String, Map<String, Integer>> entry : product.getFruits().entrySet()) {
            for (Map.Entry<String, Integer> colorEntry : entry.getValue().entrySet()) {
                if (colorEntry.getValue() > maxValue) {
                    maxValue = colorEntry.getValue();
                    maxDescription = "fruits -> " + entry.getKey() + " -> " + colorEntry.getKey() + ": " + maxValue;
                    found = true;
                }
            }
        }

        for (Map.Entry<String, Map<String, Integer>> entry : product.getVegetables().entrySet()) {
            for (Map.Entry<String, Integer> colorEntry : entry.getValue().entrySet()) {
                if (colorEntry.getValue() > maxValue) {
                    maxValue = colorEntry.getValue();
                    maxDescription = "vegetables -> " + entry.getKey() + " -> " + colorEntry.getKey() + ": " + maxValue;
                    found = true;
                }
            }
        }

        if (!found) {
            return "No products available.";
        }

        return maxDescription;
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
