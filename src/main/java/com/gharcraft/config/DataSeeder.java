package com.gharcraft.config;

import com.gharcraft.model.Product;
import com.gharcraft.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.math.BigDecimal;
import java.util.List;

@Configuration
public class DataSeeder {
    @Bean CommandLineRunner seedProducts(ProductRepository products){
        return args -> {
            if(products.count()>0) return;
            products.saveAll(List.of(
                p("Terracotta Table Planter","Hand-finished terracotta planter for indoor plants.","Home Decor","399","https://images.unsplash.com/photo-1485955900006-10f4d324d411?w=800",18,true),
                p("Blue Pottery Vase","Decorative blue pottery vase inspired by traditional Indian craft.","Home Decor","1299","https://images.unsplash.com/photo-1578749556568-bc2c40e68b61?w=800",10,true),
                p("Handwoven Jute Basket","Multipurpose handwoven basket for storage and decor.","Storage","549","https://images.unsplash.com/photo-1593085260707-5377ba37f868?w=800",22,false),
                p("Block Print Cushion Cover","Cotton cushion cover with artisan-inspired block print.","Textiles","449","https://images.unsplash.com/photo-1584100936595-c0654b55a2e2?w=800",25,true),
                p("Wooden Serving Tray","Minimal handcrafted wooden tray for serving and styling.","Kitchen","899","https://images.unsplash.com/photo-1610701596007-11502861dcfa?w=800",12,false),
                p("Macrame Wall Hanging","Textured handmade wall hanging for a warm living space.","Wall Art","799","https://images.unsplash.com/photo-1603006905003-be475563bc59?w=800",9,true),
                p("Hand-painted Ceramic Mug","Artisan-style ceramic mug for everyday tea and coffee.","Kitchen","349","https://images.unsplash.com/photo-1514228742587-6b1558fcca3d?w=800",30,false),
                p("Brass Diya Set","Decorative brass diya set with a timeless traditional look.","Festive","699","https://images.unsplash.com/photo-1603006905003-be475563bc59?w=800",16,false),
                p("Natural Fiber Coasters","Set of handcrafted natural-fiber drink coasters.","Kitchen","199","https://images.unsplash.com/photo-1603199506016-b9a594b593c0?w=800",40,false),
                p("Handcrafted Wooden Bowl","Small decorative wooden bowl with a natural finish.","Home Decor","599","https://images.unsplash.com/photo-1610701596007-11502861dcfa?w=800",14,false),
                p("Printed Cotton Tote Bag","Reusable cotton tote with a colourful artisan print.","Accessories","299","https://images.unsplash.com/photo-1590874103328-eac38a683ce7?w=800",28,false),
                p("Decorative Clay Wall Plate","Handmade decorative plate for a statement wall.","Wall Art","749","https://images.unsplash.com/photo-1578749556568-bc2c40e68b61?w=800",8,false)
            ));
        };
    }
    private Product p(String n,String d,String c,String price,String image,int stock,boolean featured){
        return new Product(n,d,c,new BigDecimal(price),image,stock,featured);
    }
}
