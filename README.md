# Payroll Management System

A comprehensive desktop-based payroll automation solution built with **Java Swing/AWT** and **MySQL**. This application provides end-to-end payroll management for small to medium-sized organizations with secure authentication, employee management, attendance tracking, and automated salary calculations.

## Quick Overview

| Component | Technology |
|-----------|-----------|
| **Frontend** | Java Swing / AWT GUI |
| **Backend Logic** | Core Java (OOP) |
| **Database** | MySQL |
| **Database Connectivity** | JDBC (Java Database Connectivity) |
| **IDEs** | IntelliJ IDEA / Eclipse / NetBeans |
| **Tools** | MySQL Workbench, MySQL Connector/J |

---

## Key Features

### 🔐 Secure Authentication
- User login and signup functionality
- Credential validation with secure access control
- Role-based session management

### 👨‍💼 Employee Management
- Add, update, search, and delete employee records
- Structured employee database with complete information storage
- Quick employee lookup and profile management

### 💰 Automated Salary Calculation
Intelligent payroll calculations including:
- **HRA** (House Rent Allowance)
- **DA** (Dearness Allowance)
- **PF** (Provident Fund)
- Gross Salary and Net Salary generation

### 📅 Attendance Tracking
- Daily attendance marking
- Leave management and tracking
- Monthly attendance reports
- Attendance history records

### 🗄️ Database Integration
- MySQL-based persistent storage
- Efficient data retrieval using JDBC
- Reliable transaction management

### 🧾 Pay Slip Generation
- Professional salary slip generation
- Printable payroll reports
- Detailed payment breakdowns

---

## System Architecture

```
┌─────────────────────────────────────────┐
│      Login / Signup Module              │
└────────────────┬────────────────────────┘
                 │
                 ▼
┌─────────────────────────────────────────┐
│      Main Dashboard                     │
└────────────────┬────────────────────────┘
                 │
    ┌────────────┼────────────┐
    │            │            │
    ▼            ▼            ▼
┌─────────┐ ┌──────────┐ ┌─────────────┐
│Employee │ │Attendance│ │   Salary    │
│Management│ │Management│ │  Calculation│
└────┬────┘ └────┬─────┘ └──────┬──────┘
     │           │              │
     ▼           ▼              ▼
┌─────────┐ ┌──────────┐ ┌─────────────┐
│Employee │ │Attendance│ │   Payroll   │
│  Table  │ │  Table   │ │   Records   │
└────┬────┘ └────┬─────┘ └──────┬──────┘
     │           │              │
     └───────────┴──────────────┘
              │
              ▼
        ┌──────────────┐
        │  Pay Slip    │
        │   Output     │
        └──────────────┘
```

---

## Tech Stack

### Frontend & Application Logic
- **Java Swing** - Rich GUI components for desktop application
- **AWT** - Additional UI rendering capabilities
- **Core Java** - OOP principles, collections, exception handling, and design patterns

### Database Layer
- **MySQL** - Relational database management
- **JDBC** - Java Database Connectivity for seamless DB operations
- **MySQL Connector/J** - JDBC driver for MySQL

### Development Environment
- **IDEs**: IntelliJ IDEA, Eclipse, NetBeans
- **Database Tool**: MySQL Workbench
- **Version Control**: Git

---

## Prerequisites

Before setting up the project, ensure you have:

- ✅ **JDK 8 or higher** installed and configured
- ✅ **MySQL Server** installed and running
- ✅ **MySQL Workbench** for database management
- ✅ **MySQL Connector/J** JDBC Driver (.jar file)
- ✅ **Git** for version control

---

## Installation & Setup

### Step 1: Create Database

Open MySQL Workbench and execute:

```sql
CREATE DATABASE payroll_db;
USE payroll_db;
```

### Step 2: Create Required Tables

Execute the following table creation scripts:

```sql
-- Employee Table
CREATE TABLE Employee (
    emp_id INT PRIMARY KEY AUTO_INCREMENT,
    emp_name VARCHAR(100),
    designation VARCHAR(50),
    department VARCHAR(50),
    salary DECIMAL(10, 2),
    email VARCHAR(100)
);

-- Login Table
CREATE TABLE Login (
    user_id INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(50) UNIQUE,
    password VARCHAR(100),
    emp_id INT,
    FOREIGN KEY (emp_id) REFERENCES Employee(emp_id)
);

-- Attendance Table
CREATE TABLE Attendance (
    attendance_id INT PRIMARY KEY AUTO_INCREMENT,
    emp_id INT,
    attendance_date DATE,
    status VARCHAR(20),
    FOREIGN KEY (emp_id) REFERENCES Employee(emp_id)
);

-- Salary Table
CREATE TABLE Salary (
    salary_id INT PRIMARY KEY AUTO_INCREMENT,
    emp_id INT,
    basic DECIMAL(10, 2),
    hra DECIMAL(10, 2),
    da DECIMAL(10, 2),
    pf DECIMAL(10, 2),
    gross_salary DECIMAL(10, 2),
    net_salary DECIMAL(10, 2),
    month_year VARCHAR(10),
    FOREIGN KEY (emp_id) REFERENCES Employee(emp_id)
);
```

### Step 3: Clone the Repository

```bash
git clone https://github.com/rbchy/PayrollManagementSystem.git
cd PayrollManagementSystem
```

### Step 4: Add JDBC Driver

1. Download **MySQL Connector/J** from [MySQL Official Site](https://dev.mysql.com/downloads/connector/j/)
2. Extract the `.jar` file
3. Add the `.jar` file to your project's **Build Path**:
   - **IntelliJ IDEA**: Project Structure → Libraries → Add JAR
   - **Eclipse**: Build Path → Add External Archives
   - **NetBeans**: Right-click Project → Properties → Libraries → Add JAR

### Step 5: Configure Database Connection

Update your `Conn.java` file with your MySQL credentials:

```java
package com.payroll.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conn {
    public static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/payroll_db",
                "root",
                "YOUR_PASSWORD"  // Replace with your MySQL password
            );
            System.out.println("Database connection established successfully!");
        } catch (ClassNotFoundException e) {
            System.err.println("MySQL JDBC Driver not found!");
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("Connection failed!");
            e.printStackTrace();
        }
        return connection;
    }
}
```

---

## How to Run

1. **Open the project** in your preferred IDE (IntelliJ IDEA, Eclipse, or NetBeans)

2. **Run the main application** by executing:
   - `Splash.java` (for splash screen)
   - `Login.java` (to start login interface)

3. **Create a new account** (Sign Up) or **Login** with existing credentials

4. **Access the Dashboard** and perform:
   - ✅ Manage employee records
   - ✅ Track daily attendance
   - ✅ Calculate and process payroll
   - ✅ Generate and view pay slips

---

## Project Structure

```
PayrollManagementSystem/
├── src/
│   ├── com/payroll/
│   │   ├── database/
│   │   │   └── Conn.java
│   │   ├── models/
│   │   │   ├── Employee.java
│   │   │   ├── Salary.java
│   │   │   └── Attendance.java
│   │   ├── views/
│   │   │   ├── Login.java
│   │   │   ├── Splash.java
│   │   │   ├── Dashboard.java
│   │   │   └── EmployeePanel.java
│   │   └── controllers/
│   │       └── PayrollController.java
├── lib/
│   └── mysql-connector-java-x.x.x.jar
├── README.md
└── .gitignore
```

---

## Why This Project Stands Out

✅ **Desktop Application Development** - Full-featured Swing/AWT GUI with responsive design  
✅ **Complete CRUD Operations** - Full Create, Read, Update, Delete functionality with MySQL  
✅ **Secure Authentication** - User login with credential validation  
✅ **Real-World Business Logic** - Accurate payroll calculations with deductions and allowances  
✅ **JDBC Integration** - Efficient database connectivity and transaction management  
✅ **Clean Architecture** - Separation of concerns (UI, Business Logic, Database Layer)  
✅ **OOP Principles** - Proper use of classes, inheritance, and encapsulation  

---

## Future Enhancements

🔄 Role-based access control (Admin / HR / Employee)  
📄 Export pay slips as PDF  
🔗 REST API integration for web service connectivity  
🌐 Web-based version using Spring Boot + React  
📊 Advanced reporting dashboard with charts and analytics  
🔔 Email notifications for salary processing  
📱 Mobile application companion  

---

## Contributing

We welcome contributions! To contribute:

1. Fork the repository
2. Create a new branch (`git checkout -b feature/improvement`)
3. Commit your changes (`git commit -m 'Add new feature'`)
4. Push to the branch (`git push origin feature/improvement`)
5. Submit a Pull Request

---

## License

This project is open-source and available under the **MIT License**. See [LICENSE](LICENSE) file for more details.

---

## Support & Feedback

If you found this project helpful:

⭐ **Star** the repository  
🍴 **Fork** it for your use  
💬 **Open an issue** for bugs or suggestions  
🤝 **Contribute** to improve the project  

---

## Author

**Ranajit Baran Chowdhury**  
Software QA Engineer | Automation & Manual Testing  
🔗 [GitHub](https://github.com/rbchy)

---

## Disclaimer

This project is designed for educational and small-scale organizational use. For enterprise-level payroll processing, consider consulting with payroll specialists and compliance experts to ensure adherence to local tax laws and regulations.

---

**Last Updated**: 2026-04-14 01:17:05  
**Version**: 1.0
