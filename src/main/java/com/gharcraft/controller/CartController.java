package com.gharcraft.controller;

import com.gharcraft.dto.AddCartRequest;
import com.gharcraft.model.*;
import com.gharcraft.repository.*;
import com.gharcraft.service.CurrentUser;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import java.math.BigDecimal;
import java.util.*;

@RestController
@RequestMapping("/api/cart")
public class CartController {
    private final CartRepository carts; private final ProductRepository products; private final CurrentUser currentUser;
    public CartController(CartRepository carts, ProductRepository products, CurrentUser currentUser){this.carts=carts;this.products=products;this.currentUser=currentUser;}
    @GetMapping public Map<String,Object> get(HttpSession session){
        AppUser user=currentUser.require(session); List<CartItem> items=carts.findByUserId(user.getId());
        BigDecimal total=items.stream().map(i->i.getProduct().getPrice().multiply(BigDecimal.valueOf(i.getQuantity()))).reduce(BigDecimal.ZERO,BigDecimal::add);
        return Map.of("items",items,"total",total);
    }
    @PostMapping("/items") public Map<String,String> add(@Valid @RequestBody AddCartRequest request,HttpSession session){
        AppUser user=currentUser.require(session); Product product=products.findById(request.productId()).orElseThrow(()->new IllegalArgumentException("Product not found."));
        if(product.getStock()<request.quantity()) throw new IllegalArgumentException("Not enough stock available.");
        CartItem item=carts.findByUserIdAndProductId(user.getId(),product.getId()).orElse(new CartItem(user,product,0));
        int newQty=item.getQuantity()+request.quantity();
        if(newQty>product.getStock()) throw new IllegalArgumentException("Requested quantity exceeds available stock.");
        item.setQuantity(newQty); carts.save(item); return Map.of("message","Product added to cart.");
    }
    @PutMapping("/items/{id}") public Map<String,String> update(@PathVariable Long id,@RequestParam int quantity,HttpSession session){
        AppUser user=currentUser.require(session); CartItem item=carts.findByIdAndUserId(id,user.getId()).orElseThrow(()->new IllegalArgumentException("Cart item not found."));
        if(quantity<1||quantity>item.getProduct().getStock()) throw new IllegalArgumentException("Invalid quantity.");
        item.setQuantity(quantity);carts.save(item);return Map.of("message","Cart updated.");
    }
    @DeleteMapping("/items/{id}") public Map<String,String> remove(@PathVariable Long id,HttpSession session){
        AppUser user=currentUser.require(session); CartItem item=carts.findByIdAndUserId(id,user.getId()).orElseThrow(()->new IllegalArgumentException("Cart item not found."));
        carts.delete(item);return Map.of("message","Item removed.");
    }
}
