💼 Payroll Management System

A desktop-based payroll automation system designed to simplify and modernize employee salary processing.

Built using Java (Swing/AWT) and MySQL, this application provides an end-to-end solution for managing employees, attendance, and payroll with accuracy, efficiency, and real-world business logic.

👨‍💻 Author

Ranajit Baran Chowdhury
Software QA Engineer | Automation & Manual Testing

Passionate about building practical, real-world software solutions and scalable systems.

🚀 Key Features

A complete suite of payroll operations tailored for HR teams and small organizations:

🔐 Secure Authentication
User Login & Signup
Credential validation and access control
👨‍💼 Employee Management
Add, update, search, and delete employee records
Structured employee database handling
💰 Automated Salary Calculation
Calculates:
HRA (House Rent Allowance)
DA (Dearness Allowance)
PF (Provident Fund)
Generates:
Gross Salary
Net Salary
📅 Attendance Tracking
Daily attendance marking
Leave management
Monthly attendance reports
🗄️ Database Integration
MySQL-based persistent storage
Efficient data retrieval using JDBC
🧾 Pay Slip Generation
Generate professional salary slips
Printable payroll reports
🧩 System Architecture
Login / Signup
      │
      ▼
Main Dashboard
      │
 ┌───────────────┬───────────────┬───────────────┐
 ▼               ▼               ▼
Employee     Attendance     Salary Module
Management   Management     (HRA/DA/PF)
     │             │               │
     ▼             ▼               ▼
Employee DB   Attendance DB   Payroll Records
      │
      ▼
 Pay Slip Output
🛠️ Tech Stack
💻 Frontend & Application Logic
Java (Swing / AWT GUI)
Core Java (OOP concepts)
🗄️ Database
MySQL
JDBC (Java Database Connectivity)
🧰 Tools & IDEs
IntelliJ IDEA / Eclipse / NetBeans
MySQL Workbench
MySQL Connector/J
📋 Prerequisites

Before running the project, make sure you have:

JDK 8 or higher installed
MySQL Server installed
MySQL Workbench
MySQL Connector/J (JDBC Driver)
⚙️ Installation & Setup
1️⃣ Create Database

Open MySQL Workbench and run:

CREATE DATABASE payroll_db;

Then create required tables:

Employee
Login
Attendance
Salary
2️⃣ Clone Repository
git clone https://github.com/your-username/PayrollManagementSystems.git
3️⃣ Add JDBC Driver
Download MySQL Connector/J
Add .jar file to project build path
4️⃣ Configure Database Connection

Update your Conn.java file:

connection = DriverManager.getConnection(
    "jdbc:mysql:///payroll_db",
    "root",
    "YOUR_PASSWORD"
);
🖥️ How to Run
Run:
Splash.java or Login.java
Sign Up (if new user)
Login to access dashboard
Use the system to:
Manage employees
Track attendance
Calculate payroll
Generate salary slips
🎯 Why This Project Stands Out

This project demonstrates strong real-world software engineering skills:

✔ Desktop application development using Java
✔ Full CRUD operations with MySQL
✔ Secure authentication implementation
✔ Real-world payroll business logic
✔ Clean separation of UI, logic, and database layers
✔ Strong understanding of JDBC integration

📊 Project Highlights
End-to-end payroll workflow
Real-world HR use case implementation
Scalable and maintainable architecture
Beginner-to-intermediate full-stack Java project
📌 Future Enhancements
Role-based access control (Admin/HR/User)
Export payslip as PDF
REST API integration
Web-based version (Spring Boot + React)
Reporting dashboard with charts
⭐ Support

If you like this project:

⭐ Star the repository
🍴 Fork it
🛠️ Contribute
📄 License

This project is open-source and available under the MIT License.

🚀 Final Note

This project is ideal for:

💼 Portfolio showcase
🧪 QA Automation practice
👨‍💻 Java + Database learning
🎯 Interview preparation
