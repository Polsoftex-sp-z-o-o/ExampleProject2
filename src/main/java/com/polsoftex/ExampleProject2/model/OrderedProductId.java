package com.polsoftex.ExampleProject2.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderedProductId implements Serializable {
    UUID orderId;
    UUID productId;
}
