package com.gharcraft.controller;

import com.gharcraft.model.Product;
import com.gharcraft.repository.ProductRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    private final ProductRepository products;
    public ProductController(ProductRepository products){this.products=products;}
    @GetMapping public List<Product> all(@RequestParam(required=false) String category, @RequestParam(required=false) String q){
        List<Product> result=(category==null||category.isBlank())?products.findAll():products.findByCategoryIgnoreCase(category);
        if(q!=null&&!q.isBlank()) result=result.stream().filter(p->p.getName().toLowerCase().contains(q.toLowerCase())||p.getDescription().toLowerCase().contains(q.toLowerCase())).toList();
        return result;
    }
    @GetMapping("/{id}") public Product one(@PathVariable Long id){return products.findById(id).orElseThrow(()->new IllegalArgumentException("Product not found."));}
}
