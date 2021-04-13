package com.polsoftex.ExampleProject2.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderedProductDTO {
    private UUID productId;
    private int quantity;
}
