# GharCraft – Full Stack E-Commerce Application

A student portfolio project for a handmade and handcrafted products store. It includes a responsive storefront, Java + Spring Boot REST backend, MySQL persistence, customer registration/login, shopping cart and demo checkout/order history.

## Features

- Responsive product catalogue with product images, categories and search
- 12 sample products inserted automatically on first run
- Customer registration and login (passwords stored as BCrypt hashes)
- Session-based authentication
- Add to cart, change quantity and remove cart items
- Checkout with delivery address and order creation
- Stock validation and stock reduction after successful order
- Order history API
- Spring Data JPA + MySQL
- H2 demo profile to run without installing MySQL

> This is a learning/portfolio application. It does not integrate a payment gateway, email/SMS service, production-grade security hardening, or an admin dashboard. Product photos are loaded from remote Unsplash image URLs and need an internet connection to display.

## Requirements

- Java 17 or newer
- Maven 3.8+
- MySQL 8+ (optional if using the H2 demo profile)

## Run with MySQL

1. Start MySQL.
2. Create a database (or let the configured JDBC URL create it):
   ```sql
   CREATE DATABASE gharcraft;
   ```
3. Open a terminal in this project folder.
4. Run:
   ```bash
   mvn spring-boot:run
   ```
5. Open **http://localhost:8080**.

Default local MySQL settings in `application.properties` are username `root` and password `root`. Change these for your machine using environment variables:

**Windows PowerShell**
```powershell
$env:DB_USERNAME="root"
$env:DB_PASSWORD="your_mysql_password"
mvn spring-boot:run
```

**macOS/Linux**
```bash
DB_USERNAME=root DB_PASSWORD='your_mysql_password' mvn spring-boot:run
```

## Run without MySQL (quick demo)

```bash
mvn spring-boot:run -Dspring-boot.run.profiles=demo
```
Then open **http://localhost:8080**. H2 is in-memory; demo data is recreated after each restart.

## Main API endpoints

| Method | Endpoint | Purpose |
|---|---|---|
| GET | `/api/products` | List products |
| GET | `/api/products/{id}` | Product details |
| POST | `/api/auth/register` | Create customer account |
| POST | `/api/auth/login` | Sign in |
| GET | `/api/auth/me` | Current session |
| POST | `/api/auth/logout` | Sign out |
| GET | `/api/cart` | View current cart |
| POST | `/api/cart/items` | Add product (`productId`, `quantity`) |
| PUT | `/api/cart/items/{id}?quantity=2` | Change quantity |
| DELETE | `/api/cart/items/{id}` | Remove cart item |
| POST | `/api/orders` | Place order (`shippingAddress`) |
| GET | `/api/orders` | Current customer's orders |

Authentication uses the server session cookie. Sign in before using cart and order endpoints.

## Project structure

```text
GharCraft-Full-Stack-Ecommerce/
├── pom.xml
├── README.md
└── src/
    └── main/
        ├── java/com/gharcraft/
        │   ├── config/       # App config and sample product seeder
        │   ├── controller/   # REST controllers and error handler
        │   ├── dto/          # Request DTOs and validation
        │   ├── model/        # JPA entities
        │   ├── repository/   # Spring Data repositories
        │   └── service/      # Current logged-in user helper
        └── resources/
            ├── application.properties
            ├── application-demo.properties
            └── static/       # HTML, CSS and JavaScript frontend
```

## Portfolio / interview description

**GharCraft – Full Stack E-Commerce Application**  
Technologies: Java, Spring Boot, Spring Data JPA, MySQL, HTML, CSS, JavaScript.

Developed a full-stack storefront for handmade and handcrafted products. Implemented product browsing, category filtering, customer registration and login, shopping cart management, and demo order placement through REST APIs. Used Spring Data JPA for database operations and MySQL for persistent storage.

Only describe features you have run and verified yourself in an interview. Before publishing this project, configure your own database credentials and test the complete user flow locally.
