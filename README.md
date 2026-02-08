#  System Employee Management

A simple **Employee Management System** built with **Spring Boot**.  
This project is for **learning purposes**, focusing on CRUD operations, entity relationships, and basic Spring Security configuration.

---

## Features

- Employee management (Create, Update, Delete, List)
- Department management
- Leave request management
- Entity relationships (Employee ↔ Department ↔ Leave)
- DTO pattern (Create / Update)
- Password encryption using BCrypt
- Basic Spring Security configuration
- RESTful API architecture

---

## Tech Stack

- **Java 17**
- **Spring Boot**
- **Spring Data JPA**
- **Spring Security**
- **MariaDB**
- **Maven**

---

##  Project Structure


---

## 🧩 Entities

### Employee
- id
- firstName
- lastName
- email
- department

### Department
- id
- name

### LeaveRequest
- id
- startDate
- endDate
- status
- employee

### UserAccount
- username
- password (BCrypt encrypted)

---

## 🔐 Security

- Spring Security configured using `SecurityFilterChain`
- CSRF & CORS disabled (for development)
- Passwords encrypted using `BCryptPasswordEncoder`
- Authentication **not fully implemented** (educational project)

---

## ⚙️ Configuration

### Database (application.properties)

```properties
spring.application.name=employee
spring.datasource.url=jdbc:mariadb://localhost:3306/employee_System_db
spring.datasource.username=root
spring.datasource.driver-class-name=org.mariadb.jdbc.Driver
spring.datasource.password=1234
spring.jpa.hibernate.ddl-auto=update
spring.jpa.database-platform=org.hibernate.dialect.MariaDBDialect

server.port=8080
