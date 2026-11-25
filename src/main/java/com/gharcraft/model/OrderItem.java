package com.gharcraft.model;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.math.BigDecimal;

@Entity
@Table(name="order_items")
public class OrderItem {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
    @ManyToOne(optional=false) private CustomerOrder order;
    @Column(nullable=false) private String productName;
    @Column(nullable=false, precision=10, scale=2) private BigDecimal unitPrice;
    private int quantity;
    public OrderItem() {}
    public OrderItem(String productName, BigDecimal unitPrice, int quantity){this.productName=productName;this.unitPrice=unitPrice;this.quantity=quantity;}
    public Long getId(){return id;} public void setId(Long id){this.id=id;}
    @JsonIgnore public CustomerOrder getOrder(){return order;} public void setOrder(CustomerOrder order){this.order=order;}
    public String getProductName(){return productName;} public void setProductName(String productName){this.productName=productName;}
    public BigDecimal getUnitPrice(){return unitPrice;} public void setUnitPrice(BigDecimal unitPrice){this.unitPrice=unitPrice;}
    public int getQuantity(){return quantity;} public void setQuantity(int quantity){this.quantity=quantity;}
}
