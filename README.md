# eBanking Secure Application

A secure REST API for banking operations built with Spring Boot and Spring Security, implementing Basic Authentication for user access control.

## 📋 Overview

This application provides a secure banking interface where users can:
- View their account details, balance, loans, and cards
- Access public information like notices and contact details
- Manage user accounts (admin functionality)

## 🔐 Security Features

- Basic Authentication
- Role-based access control (USER, ADMIN roles)
- Password encryption using BCrypt
- Stateless session management
- Custom authentication provider
- Centralized exception handling

## 🛠️ Technical Stack

- Java 17
- Spring Boot
- Spring Security
- Spring Data JPA
- BCrypt Password Encoder
- H2/MySQL Database (configurable)

## 🔄 API Endpoints

### Public Endpoints (No Authentication Required)

```
GET /api/notices           - View system announcements
GET /api/contact          - Get customer support information
POST /api/users/register  - Register new user
```

### Protected Endpoints (Authentication Required)

#### Banking Operations
```
GET /api/myAccount        - View account details
GET /api/myBalance       - Check account balance
GET /api/myLoans         - View loan information
GET /api/myCards         - View card information
```

#### User Management (ADMIN only)
```
GET /api/users                           - List all users
GET /api/users/{username}                - Get user details
DELETE /api/users/{username}             - Delete user
PUT /api/users/{username}/updateRole     - Update user role
```

#### User Operations
```
PUT /api/users/{username}/password       - Change password
```

## 🏗️ Project Structure

```
src/main/java/com.ebanking.eBankSecure/
├── config/
│   ├── SecurityConfig
│   ├── TestPasswordEncoderConfig
│   └── TestSecurityConfig
├── controller/
│   ├── BankingController
│   └── UserController
├── entity/
│   ├── dto/
│   │   └── UserDTO
│   ├── enums/
│   │   └── Role
│   └── User
├── exception/
│   ├── GlobalExceptionHandler
│   ├── InvalidPasswordException
│   ├── UsernameAlreadyExistsException
│   └── UserNotFoundException
├── repository/
│   └── UserRepository
├── security/
│   └── CustomUserDetailsService
├── service/
│   └── UserService
└── EBankSecureApplication
```

## 🚀 Getting Started

1. Clone the repository
2. Configure application.properties with your database settings
3. Run the application using Maven:
   ```bash
   mvn spring:run
   ```

## 🔒 Security Configuration

- Custom UserDetailsService for user authentication
- BCrypt password encoding
- Stateless session configuration
- Role-based access control
- Global exception handling for security events

## ⚙️ Configuration

### Application Properties
```properties
# Database Configuration
spring.datasource.url=jdbc:mysql://localhost:3306/ebanking
spring.datasource.username=root
spring.datasource.password=root

# JPA Configuration
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

# Security Logging
logging.level.org.springframework.security=TRACE
```

## 🛡️ Exception Handling

The application includes comprehensive exception handling:
- Custom exceptions for business logic
- Global exception handler using @RestControllerAdvice
- Specific handling for security exceptions
- Structured error responses

## 👥 User Management

- Default role for new users: ROLE_USER
- Password encryption using BCrypt
- Role modification restricted to ADMIN users
- Username uniqueness validation
- Password change functionality with old password verification

## 📝 Testing

The application includes test configurations:
- TestSecurityConfig for security testing
- TestPasswordEncoderConfig for password encoding in test environment
- Comprehensive test coverage for controllers and services



Created with ❤️ by ouchin55edcx
