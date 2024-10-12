package com.example.myapp.service;

import com.example.myapp.model.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProductServiceTest {
    private ProductService productService;

    private final String jsonFilePath = "src/main/resources/products.json";

    @BeforeEach
    public void setUp() {
        productService = new ProductService();
    }

    @Test
    public void testReadProductsFromJson() throws IOException {
        Product product = productService.readProductsFromJson(jsonFilePath);

        assertEquals(3, product.getFruits().size(), "Should have 3 fruits");
        assertEquals(3, product.getVegetables().size(), "Should have 3 vegetables");

        assertEquals(5, product.getFruits().get("apple").get("green"), "Apple should have 5 green");
        assertEquals(21, product.getVegetables().get("carrot").get("red"), "Carrot should have 21 red");
    }

    @Test
    public void testFindMax() throws IOException {
        Product product = productService.readProductsFromJson(jsonFilePath);

        String maxDescription = productService.findMax(product);
        assertEquals("vegetables -> carrot -> red: 21", maxDescription, "Should return max value");
    }
    @Test
    public void testEmptyJson() throws IOException {
        Product emptyProduct = new Product();
        emptyProduct.setFruits(Map.of());
        emptyProduct.setVegetables(Map.of());

        String maxDescription = productService.findMax(emptyProduct);
        assertEquals("No products available.", maxDescription, "Max description should indicate no products");
    }

    @Test
    public void testFindMaxSingleProduct() throws IOException {
        Product product = new Product();
        product.setFruits(Map.of("banana", Map.of("yellow", 0)));
        product.setVegetables(Map.of("tomato", Map.of("red", 5)));

        String maxDescription = productService.findMax(product);
        assertEquals("vegetables -> tomato -> red: 5", maxDescription, "Should return the only available product with zero value");
    }
}
