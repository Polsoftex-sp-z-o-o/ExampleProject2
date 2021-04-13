package com.polsoftex.ExampleProject2.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "ordered_product")
@Table(name = "ordered_products")
@IdClass(OrderedProductId.class)
public class OrderedProductDAO {
    @Id
    @Column(name = "order_id")
    @Type(type = "org.hibernate.type.UUIDCharType")
    private UUID orderId;
    @Id
    @Column(name = "product_id")
    @Type(type = "org.hibernate.type.UUIDCharType")
    private UUID productId;
    private int quantity;
}
