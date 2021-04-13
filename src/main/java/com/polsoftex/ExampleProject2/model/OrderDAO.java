package com.polsoftex.ExampleProject2.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
import java.util.UUID;

@Data
@NoArgsConstructor
@Entity(name = "order")
@Table(name = "orders")
public class OrderDAO {
    @Id
    @GeneratedValue
    @Type(type = "org.hibernate.type.UUIDCharType")
    private UUID id;
    @Column(name = "user_id")
    @Type(type = "org.hibernate.type.UUIDCharType")
    private UUID userId;
    @Column(name = "placement_date")
    private Date placementDate;
    private String state;
}
