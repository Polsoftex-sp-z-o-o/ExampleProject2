package com.polsoftex.ExampleProject2;

import com.polsoftex.ExampleProject2.model.OrderedProductDAO;
import com.polsoftex.ExampleProject2.model.OrderedProductId;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

public interface OrderedProductsRepository extends CrudRepository<OrderedProductDAO, OrderedProductId> {

    List<OrderedProductDAO> findAllByOrderId(UUID orderId);

    @Transactional
    @Modifying
    void deleteAllByOrderId(UUID orderId);
}
