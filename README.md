Employee Management System

Employee Management System built with Spring Boot and Spring Data JPA.  
This project is created for learning purposes, focusing on backend development, database relationships, and basic security concepts.


Features

- Authentication & Login (basic – learning purpose)
- Employee CRUD operations
- Department Management
- Leave Management
  - Request Leave
  - Approve / Reject Leave
- Role-based logic (ADMIN / EMPLOYEE – basic)


Technologies Used

- Java
- Spring Boot
- Spring Data JPA
- MariaDB
- Maven
- Hibernate



Database Design

Entities
- Employee
- Department
- Leave
- login

Relationships
- Employee ➝ Department (ManyToOne)
- Leave ➝ Employee (ManyToOne)
- Department ➝ Employees (OneToMany)

JPA annotations are used to manage relationships and persistence.


Security

Spring Security is implemented **for educational purposes only.

- Basic authentication setup
- No advanced authorization yet
- No JWT or OAuth (planned for future improvement)

How to Run the Project

1. Create Database
Create a MariaDB database
password '1234'
```sql
CREATE DATABASE employee_system;
