package com.gharcraft.controller;

import com.gharcraft.dto.CheckoutRequest;
import com.gharcraft.model.*;
import com.gharcraft.repository.*;
import com.gharcraft.service.CurrentUser;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
    private final OrderRepository orders; private final CartRepository carts; private final CurrentUser currentUser;
    public OrderController(OrderRepository orders,CartRepository carts,CurrentUser currentUser){this.orders=orders;this.carts=carts;this.currentUser=currentUser;}
    @PostMapping @Transactional public CustomerOrder checkout(@Valid @RequestBody CheckoutRequest request,HttpSession session){
        AppUser user=currentUser.require(session); List<CartItem> cart=carts.findByUserId(user.getId());
        if(cart.isEmpty()) throw new IllegalArgumentException("Your cart is empty.");
        BigDecimal total=cart.stream().map(i->i.getProduct().getPrice().multiply(BigDecimal.valueOf(i.getQuantity()))).reduce(BigDecimal.ZERO,BigDecimal::add);
        CustomerOrder order=new CustomerOrder(user,total,request.shippingAddress().trim());
        for(CartItem ci:cart){
            Product p=ci.getProduct();
            if(p.getStock()<ci.getQuantity()) throw new IllegalArgumentException("Insufficient stock for "+p.getName());
            p.setStock(p.getStock()-ci.getQuantity());
            order.addItem(new OrderItem(p.getName(),p.getPrice(),ci.getQuantity()));
        }
        CustomerOrder saved=orders.save(order); carts.deleteAll(cart); return saved;
    }
    @GetMapping public List<CustomerOrder> mine(HttpSession session){AppUser user=currentUser.require(session);return orders.findByUserIdOrderByCreatedAtDesc(user.getId());}
}
