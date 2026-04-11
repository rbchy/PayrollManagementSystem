# PayrollManagementSystem
💼 Payroll Management System
A desktop‑based payroll automation solution engineered to simplify and modernize employee salary processing. Built using Java (Swing/AWT) and MySQL, this system provides a complete workflow for managing employees, attendance, and payroll generation with accuracy and efficiency.

Developed by Ranajit Baran Chowdhury, this project demonstrates strong command over Java application development, database integration, and real‑world payroll logic.


🚀 Key Features
A complete suite of payroll operations designed for HR teams and small organizations.

Secure Authentication – Login & signup with credential validation.

Employee Management – Add, update, search, and delete employee records.

Automated Salary Calculation – Computes HRA, DA, PF, gross salary, and net salary.

Attendance Tracking – Daily presence, leave records, and monthly attendance logs.

MySQL Database Integration – Persistent and structured data storage.

Pay Slip Generation – View and print professional salary slips.


🧩 Feature Diagram
A high‑level view of how the system components interact.

                   ┌──────────────────────────┐
                   │      Login / Signup      │
                   └─────────────┬────────────┘
                                 │
                                 ▼
                   ┌──────────────────────────┐
                   │      Main Dashboard      │
                   └─────────────┬────────────┘
                                 │
     ┌───────────────────────────┼───────────────────────────┐
     ▼                           ▼                           ▼
┌──────────────┐         ┌──────────────┐         ┌────────────────┐
│ Employee      │         │ Attendance   │         │ Salary Module  │
│ Management    │         │ Management   │         │ (HRA/DA/PF)    │
└──────┬────────┘         └──────┬───────┘         └──────┬─────────┘
       │                           │                        │
       ▼                           ▼                        ▼
┌──────────────┐         ┌──────────────┐         ┌────────────────┐
│ Employee DB  │         │ Attendance DB│         │ Payroll Records │
└──────────────┘         └──────────────┘         └────────────────┘

                     ┌──────────────────────────┐
                     │     Pay Slip Output      │
                     └──────────────────────────┘
                     

🛠️ Tech Stack
Frontend & Logic
Java (Swing / AWT GUI)

Core Java OOP principles

Database
MySQL

JDBC (Java Database Connectivity)

Tools
IntelliJ / Eclipse / NetBeans

MySQL Workbench

MySQL Connector/J



📋 Prerequisites
Install the following before running the project:

JDK 8 or higher

MySQL Server + MySQL Workbench

MySQL Connector/J (JDBC driver)

⚙️ Installation & Setup 
1. Create the Database
Open MySQL Workbench and run:
CREATE DATABASE payroll_db;

Import the provided .sql file (if included) or manually create:

Employee table

Login table

Attendance table

Salary table

2. Clone the Project
git clone https://github.com/your-username/PayrollManagementSystems.git

3. Add JDBC Driver
Add mysql-connector.jar to your project’s build path.

4. Update Database Credentials
In Conn.java:
connection = DriverManager.getConnection(
    "jdbc:mysql:///payroll_db",
    "root",
    "YOUR_PASSWORD"
);

🖥️ How to Use
Run Login.java or Splash.java to start the application.

Sign Up if you’re a new user.

Log In to access the dashboard.

Navigate through the menu to:

Manage employees

Track attendance

Calculate monthly payroll

Generate and print salary slips

🎯 Why This Project Stands Out
This system demonstrates practical software engineering skills:

Desktop application development

CRUD operations with MySQL

Secure authentication flows

Real‑world payroll logic

Clean separation of UI, logic, and database layers

Strong understanding of Java Swing and JDBC

It is ideal for showcasing full‑stack Java development and backend integration in a professional portfolio.

👨‍💻 Author
Ranajit Baran Chowdhury  
Software QA Engineer | Automation & Manual Testing

Passionate about building practical, real‑world software solutions.
