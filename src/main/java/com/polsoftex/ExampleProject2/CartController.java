package com.polsoftex.ExampleProject2;

import com.polsoftex.ExampleProject2.model.OrderDTO;
import com.polsoftex.ExampleProject2.model.OrderedProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/cart")
public class CartController {

    //TODO This should be drawn from token
    private UUID userId = new UUID(1, 1);

    @Autowired
    private CartService cartService;

    @GetMapping("")
    OrderDTO getCart() {
        return cartService.getCart(userId);
    }

    @PostMapping("")
    OrderDTO addItemToCart(@RequestBody OrderedProductDTO orderedProductDTO) {
        return cartService.addProductToCart(userId, orderedProductDTO);
    }

    @PutMapping("")
    void updateCart(@RequestBody OrderDTO orderDTO) {
        cartService.updateCart(userId, orderDTO);
    }

    @DeleteMapping("")
    void clearCart() {
        cartService.deleteCart(userId);
    }
}
