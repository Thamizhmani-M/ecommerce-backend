# 🛒 E-Commerce Backend Application

A robust and secure e-commerce backend REST API built with Java and Spring Boot. This application handles user authentication, product catalog management, shopping cart operations, order processing, and order history tracking.

---

## 🛠️ Tech Stack
* **Language:** Java
* **Framework:** Spring Boot, Spring Data JPA (Hibernate)
* **Security:** Spring Security, JWT (JSON Web Token)
* **Database:** MySQL
* **API Testing:** Postman

---

## ✨ Features
* **User Authentication & Authorization:** Secure registration, login, and stateless authentication using JWT.
* **Product Catalog:** Complete CRUD operations for managing products.
* **Shopping Cart Management:** Add items, view cart, and manage quantities.
* **Order Checkout & History:** Secure checkout workflow that processes orders and allows users to retrieve past transaction summaries via authenticated endpoints.
* **Global Exception Handling:** Centralized exception handling (`@ControllerAdvice`) returning standardized JSON error responses.

---

## 🚀 API Endpoints Overview

### 1. Authentication
* `POST /api/auth/register` - Register a new user
* `POST /api/auth/login` - Authenticate and receive a JWT token

### 2. Products
* `GET /api/products` - View all products
* `POST /api/products` - Add a new product (Admin)

### 3. Cart
* `POST /api/cart/add/{email}` - Add product to user cart
* `GET /api/cart/{email}` - View user cart

### 4. Orders
* `POST /api/orders/checkout/{email}` - Place an order from cart items
* `GET /api/orders/user/{email}` - Get order history for a specific user

---

## ⚙️ Getting Started

### 📋 Prerequisites
* Java 17 or higher
* MySQL Database
* Maven

### 📥 Installation & Setup
1. Clone the repository:
   ```bash
   git clone https://github.com/Thamizhmani-M/ecommerce-backend.git
2. Configure your MySQL database credentials in `src/main/resources/application.properties`:

   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/ecommerce_db
   spring.datasource.username=root
   spring.datasource.password=your_password
   spring.jpa.hibernate.ddl-auto=update

3. Run the application using Maven or your IDE:

   ```bash
   mvn spring-boot:run

## 📁 Project Structure

   ```text
ecommerce-backend/
├── src/
│   ├── main/
│   │   ├── java/com/ecommerce/ecommerce_backend/
│   │   │   ├── controller/      # REST Endpoints (Auth, Product, Cart, Order)
│   │   │   ├── exception/       # Global Exception Handler (@ControllerAdvice)
│   │   │   ├── model/           # Entity Classes & DTOs
│   │   │   ├── repository/      # Spring Data JPA Repositories
│   │   │   ├── security/        # JWT Filters, Security Config, and Utils
│   │   │   └── service/         # Business Logic Layer
│   │   │
│   │   └── resources/
│   │       └── application.properties # Database & Server Configurations
│   │
└── pom.xml                      # Maven Dependencies Configuration
