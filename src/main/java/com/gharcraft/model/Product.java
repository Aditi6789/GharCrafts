package com.gharcraft.model;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "products")
public class Product {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false) private String name;
    @Column(length = 1500) private String description;
    @Column(nullable = false) private String category;
    @Column(nullable = false, precision = 10, scale = 2) private BigDecimal price;
    private String imageUrl;
    private int stock;
    private boolean featured;

    public Product() {}
    public Product(String name, String description, String category, BigDecimal price, String imageUrl, int stock, boolean featured) {
        this.name=name; this.description=description; this.category=category; this.price=price;
        this.imageUrl=imageUrl; this.stock=stock; this.featured=featured;
    }
    public Long getId(){return id;} public void setId(Long id){this.id=id;}
    public String getName(){return name;} public void setName(String name){this.name=name;}
    public String getDescription(){return description;} public void setDescription(String description){this.description=description;}
    public String getCategory(){return category;} public void setCategory(String category){this.category=category;}
    public BigDecimal getPrice(){return price;} public void setPrice(BigDecimal price){this.price=price;}
    public String getImageUrl(){return imageUrl;} public void setImageUrl(String imageUrl){this.imageUrl=imageUrl;}
    public int getStock(){return stock;} public void setStock(int stock){this.stock=stock;}
    public boolean isFeatured(){return featured;} public void setFeatured(boolean featured){this.featured=featured;}
}
