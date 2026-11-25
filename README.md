# 🏺 GharCrafts - Handmade Marketplace

GharCrafts is a full-stack e-commerce platform for handmade and local artisan products. 
It allows artisans to list their handmade products and customers to browse, search, and order them.

Built with **Java, Spring Boot, MySQL, Thymeleaf & Bootstrap**.

🔗 **Live Demo:** Coming Soon  
🔗 **GitHub:** https://github.com/Aditi6789/GharCrafts

---

## ✨ Features

### 👤 User Features
- User Registration & Login (Spring Security)
- Browse products by category (Pottery, Textiles, Jewellery, Woodwork, etc.)
- Product Search & Filtering
- Product Details Page with Images
- Add to Cart & Checkout
- Order History

### 🎨 Artisan / Seller Features
- Add / Edit / Delete Products
- Manage Product Images & Stock
- View Orders

### 🛠️ Admin Features
- Manage Users, Products & Categories
- View All Orders

---

## 🛠️ Tech Stack

| Layer | Technology |
| :--- | :--- |
| **Backend** | Java 17, Spring Boot 3, Spring Data JPA, Spring Security |
| **Frontend** | Thymeleaf, HTML, CSS, Bootstrap, JavaScript |
| **Database** | MySQL |
| **Build Tool** | Maven |
| **IDE** | IntelliJ IDEA |

---

## 📂 Project Structure

GharCrafts/
├── src/main/java/com/GharCrafts/
│   ├── controller/     # Web Controllers (Home, Product, Cart, Auth)
│   ├── model/          # JPA Entities (User, Product, Order, Category)
│   ├── repository/     # Spring Data JPA Repositories
│   ├── service/        # Business Logic
│   └── config/         # Security Config
├── src/main/resources/
│   ├── templates/      # Thymeleaf HTML Pages
│   ├── static/         # CSS, JS, Images
│   └── http://application.properties
└── http://pom.xml

---

## ⚙️ How to Run Locally

### 1. Clone the Project
```bash
git clone https://github.com/Aditi6789/GharCrafts.git
cd GharCrafts
### 2. Setup Database (MySQL)
Create a database in MySQL:
CREATE DATABASE gharcrafts;
### 3. Update `application.properties`
spring.datasource.url=jdbc:mysql://localhost:3306/gharcrafts
spring.datasource.username=root
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
### 4. Run the Project
In IntelliJ, run `GharCraftApplication.java`
OR using terminal:
./mvnw spring-boot:run
### 5. Open in Browser
http://localhost:8080
*Demo Mode (Without MySQL):*
./mvnw spring-boot:run -Dspring-boot.run.profiles=demo
---

## 🔑 API Endpoints
Method | Endpoint | Description
`GET` | `/` | Home Page
`GET` | `/products` | All Products
`GET` | `/products/{id}` | Product Details
`GET` | `/cart` | View Cart
`POST` | `/cart/add` | Add to Cart
`GET` | `/login` | Login Page
`GET` | `/register` | Register Page
---

## 👩‍💻 Author

*Aditi Jain*
- GitHub: https://github.com/Aditi6789

---

## 📝 Future Improvements
- [ ] Payment Gateway Integration (Razorpay)
- [ ] Order Tracking System
- [ ] Wishlist Feature
- [ ] Product Reviews & Ratings

