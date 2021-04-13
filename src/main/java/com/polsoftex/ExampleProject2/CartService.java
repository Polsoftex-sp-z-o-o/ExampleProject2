package com.polsoftex.ExampleProject2;

import com.polsoftex.ExampleProject2.model.OrderDAO;
import com.polsoftex.ExampleProject2.model.OrderDTO;
import com.polsoftex.ExampleProject2.model.OrderedProductDAO;
import com.polsoftex.ExampleProject2.model.OrderedProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class CartService {
    //TODO: Transactions

    @Autowired
    private OrdersRepository ordersRepository;
    @Autowired
    private OrderedProductsRepository orderedProductsRepository;

    public OrderDTO getCart(UUID userId) {
        OrderDAO cartDAO = ordersRepository.findCart(userId);
        if (cartDAO == null) {
            return null;
        }
        return prepareOrderDTO(cartDAO);
    }

    public OrderDTO addProductToCart(UUID userId, OrderedProductDTO orderedProductDTO) {
        OrderDAO orderDAO = ordersRepository.findCart(userId);
        if (orderDAO == null) {
            // TODO: Builder?
            orderDAO = new OrderDAO();
            orderDAO.setUserId(userId);
            orderDAO.setState("cart");
            orderDAO = ordersRepository.save(orderDAO);
        }
        OrderedProductDAO newlyOrderedProductDAO = new OrderedProductDAO(orderDAO.getId(), orderedProductDTO.getProductId(), orderedProductDTO.getQuantity());
        newlyOrderedProductDAO = orderedProductsRepository.save(newlyOrderedProductDAO);
        return prepareOrderDTO(orderDAO);
    }

    public void updateCart(UUID userId, OrderDTO orderDTO) {
        OrderDAO orderDAO = ordersRepository.findCartByUserId(userId);
        orderedProductsRepository.deleteAllByOrderId(orderDAO.getId());
        List<OrderedProductDAO> orderedProductDAOs = new ArrayList<>();
        for (OrderedProductDTO orderedProductDTO : orderDTO.getOrderedProductDTOs()) {
            orderedProductDAOs.add(new OrderedProductDAO(orderDAO.getId(), orderedProductDTO.getProductId(), orderedProductDTO.getQuantity()));
        }
        orderedProductsRepository.saveAll(orderedProductDAOs);
    }

    public void deleteCart(UUID userId) {
        ordersRepository.deleteCart(userId);
    }

    private OrderDTO prepareOrderDTO(OrderDAO orderDAO) {
        List<OrderedProductDAO> orderedProductDAOs = orderedProductsRepository.findAllByOrderId(orderDAO.getId());
        return new OrderDTO(orderDAO, orderedProductDAOs);
    }
}
