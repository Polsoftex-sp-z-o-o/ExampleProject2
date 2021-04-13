package com.polsoftex.ExampleProject2.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO {
    private UUID id;
    private UUID userId;
    private Date placementDate;
    private String state;
    @JsonProperty("orderedProducts")
    private List<OrderedProductDTO> orderedProductDTOs;

    public OrderDTO(OrderDAO orderDAO, List<OrderedProductDAO> orderedProductDAOs) {
        this.id = orderDAO.getId();
        this.userId = orderDAO.getUserId();
        this.placementDate = orderDAO.getPlacementDate();
        this.state = orderDAO.getState();
        orderedProductDTOs = new ArrayList<>();
        for (OrderedProductDAO orderedProductDAO : orderedProductDAOs) {
            orderedProductDTOs.add(new OrderedProductDTO(orderedProductDAO.getProductId(), orderedProductDAO.getQuantity()));
        }
    }
}
