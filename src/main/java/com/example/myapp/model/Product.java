package com.example.myapp.model;

import java.util.Map;

public class Product {
    private Map<String, Map<String, Integer>> fruits;
    private Map<String, Map<String, Integer>> vegetables;

    public Map<String, Map<String, Integer>> getFruits() {
        return fruits;
    }

    public void setFruits(Map<String, Map<String, Integer>> fruits) {
        this.fruits = fruits;
    }

    public Map<String, Map<String, Integer>> getVegetables() {
        return vegetables;
    }

    public void setVegetables(Map<String, Map<String, Integer>> vegetables) {
        this.vegetables = vegetables;
    }
}
