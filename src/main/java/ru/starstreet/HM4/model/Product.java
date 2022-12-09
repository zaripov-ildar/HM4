package ru.starstreet.HM4.model;

import lombok.Data;

@Data
public class Product {
    private Long id;
    private String name;
    private Integer price;

    public Product(String name, Integer price) {
        id = -1L;
        this.name = name;
        this.price = price;
    }
}

