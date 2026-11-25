package com.gharcraft.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="customer_orders")
public class CustomerOrder {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
    @ManyToOne(optional=false) private AppUser user;
    @Column(nullable=false, precision=10, scale=2) private BigDecimal total;
    @Column(nullable=false) private String status = "PLACED";
    @Column(nullable=false, length=1000) private String shippingAddress;
    private LocalDateTime createdAt = LocalDateTime.now();
    @OneToMany(mappedBy="order", cascade=CascadeType.ALL, orphanRemoval=true)
    private List<OrderItem> items = new ArrayList<>();

    public CustomerOrder() {}
    public CustomerOrder(AppUser user, BigDecimal total, String address){this.user=user;this.total=total;this.shippingAddress=address;}
    public void addItem(OrderItem item){items.add(item);item.setOrder(this);}
    public Long getId(){return id;} public void setId(Long id){this.id=id;}
    public AppUser getUser(){return user;} public void setUser(AppUser user){this.user=user;}
    public BigDecimal getTotal(){return total;} public void setTotal(BigDecimal total){this.total=total;}
    public String getStatus(){return status;} public void setStatus(String status){this.status=status;}
    public String getShippingAddress(){return shippingAddress;} public void setShippingAddress(String shippingAddress){this.shippingAddress=shippingAddress;}
    public LocalDateTime getCreatedAt(){return createdAt;} public void setCreatedAt(LocalDateTime createdAt){this.createdAt=createdAt;}
    public List<OrderItem> getItems(){return items;} public void setItems(List<OrderItem> items){this.items=items;}
}
