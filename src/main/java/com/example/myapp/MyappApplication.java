package com.example.myapp;

import com.example.myapp.model.Product;
import com.example.myapp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class MyappApplication implements CommandLineRunner {

    @Autowired
    private ProductService productService;

    public static void main(String[] args) {
        SpringApplication.run(MyappApplication.class, args);
    }

    @Override
    public void run(String... args) {
        if (args.length < 2) {
            System.out.println("Please provide an operation (print/findMax) and the JSON file path.");
            return;
        }

        String operation = args[0];
        String jsonFilePath = args[1];

        try {
            Product product = productService.readProductsFromJson(jsonFilePath);
            switch (operation) {
                case "print":
                    productService.printProducts(product);
                    break;
                default:
                    System.out.println("Unknown operation: " + operation);
                    break;
            }
        } catch (IOException e) {
            System.out.println("Error reading JSON file: " + e.getMessage());
        }
    }
}
