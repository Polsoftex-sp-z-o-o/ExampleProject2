package com.polsoftex.ExampleProject2.model;

import lombok.Data;

import java.util.UUID;

@Data
public class ProductDTO {
    private UUID id;
    private String name;
    private String description;
    private float price;
    private int quantity;
}
