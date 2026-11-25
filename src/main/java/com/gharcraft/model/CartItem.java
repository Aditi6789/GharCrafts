package com.gharcraft.model;

import jakarta.persistence.*;

@Entity
@Table(name="cart_items")
public class CartItem {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
    @ManyToOne(optional=false) private AppUser user;
    @ManyToOne(optional=false) private Product product;
    private int quantity;
    public CartItem() {}
    public CartItem(AppUser user, Product product, int quantity){this.user=user;this.product=product;this.quantity=quantity;}
    public Long getId(){return id;} public void setId(Long id){this.id=id;}
    public AppUser getUser(){return user;} public void setUser(AppUser user){this.user=user;}
    public Product getProduct(){return product;} public void setProduct(Product product){this.product=product;}
    public int getQuantity(){return quantity;} public void setQuantity(int quantity){this.quantity=quantity;}
}
