<div align="center">

# 💼 Payroll Management System — Java Swing · MySQL · JDBC

### A desktop payroll application: employees, a pay engine with overtime / double-time / holiday pay, payslips and cheques. It is built, tested against a real MySQL database and packaged as a runnable JAR on every push.

[![Typing SVG](https://readme-typing-svg.demolab.com/?font=Fira+Code&size=18&pause=1500&color=22C55E&center=true&vCenter=true&width=900&repeat=true&lines=Java+21+%C2%B7+Swing+%C2%B7+MySQL+8+%C2%B7+JDBC;Employees+%C2%B7+Payroll+engine+%C2%B7+Payslip+%26+Cheque;160+%2F+160+JUnit+tests+%C2%B7+runnable+JAR+in+CI)](https://git.io/typing-svg)

<!-- ============ STATUS BAR ============ -->
[![CI](https://github.com/rbchy/PayrollManagementSystem/actions/workflows/ci.yml/badge.svg)](https://github.com/rbchy/PayrollManagementSystem/actions/workflows/ci.yml)
![Tests](https://img.shields.io/badge/Tests-160%20%2F%20160%20passed-22c55e?style=for-the-badge&logo=checkmarx&logoColor=white)
![DB](https://img.shields.io/badge/DB%20tests-real%20MySQL%208-4479A1?style=for-the-badge&logo=mysql&logoColor=white)
![JAR](https://img.shields.io/badge/Runnable%20JAR-built%20in%20CI-0ea5e9?style=for-the-badge)

![Java](https://img.shields.io/badge/Java-21-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Swing](https://img.shields.io/badge/UI-Java%20Swing-E76F00?style=for-the-badge)
![MySQL](https://img.shields.io/badge/MySQL-8.0-4479A1?style=for-the-badge&logo=mysql&logoColor=white)
![JDBC](https://img.shields.io/badge/JDBC-Connector%2FJ%209-6DB33F?style=for-the-badge)
![JUnit5](https://img.shields.io/badge/JUnit-5.10-25A162?style=for-the-badge&logo=junit5&logoColor=white)
![Maven](https://img.shields.io/badge/Maven-Build-C71A36?style=for-the-badge&logo=apachemaven&logoColor=white)

![Last Commit](https://img.shields.io/github/last-commit/rbchy/PayrollManagementSystem?style=flat-square&color=22c55e&label=Last%20commit)
![Repo Size](https://img.shields.io/github/repo-size/rbchy/PayrollManagementSystem?style=flat-square&color=155e75&label=Repo%20size)

</div>

---

## 📌 At a Glance

<table>
<tr>
<td width="50%" valign="top">

**🙋 What this is**

The **application repository** of the Payroll Management System: a Java Swing desktop app on MySQL for small-business payroll.

- employee records: add, view, update, search, delete
- a **pay engine**: normal pay (first 40 h), overtime ×1.5, double time ×2, extended / holiday / special-work hours, bonus, 20 % tax, 10 % medical
- **payslip and cheque** for an employee and pay date, with the amount in words

The full test-automation suite for the same app lives in the companion repo **[PayrollManagementSystems_Automation_Java_MySql_Selenium](https://github.com/rbchy/PayrollManagementSystems_Automation_Java_MySql_Selenium)**: 260 tests, including Cucumber BDD and AssertJ-Swing UI robots. This repo keeps the app with a focused regression suite of **160 JUnit tests**.

</td>
<td width="50%" valign="top">

**📍 Quick facts**

| | |
|---|---|
| 🖥️ **App** | Java 21 Swing, 9 tabs |
| 🗄️ **Database** | MySQL 8, `payroll_db.employees` (35 columns) |
| 🧪 **Tests** | 160 JUnit 5 tests · ≈ 14 s |
| 🗃️ **DB tests** | Add / Update / Search / View / Payslip / Delete on real MySQL |
| 📦 **Output** | `payroll-system-1.0.0.jar` (fat JAR) |
| 🔁 **Runs** | push · pull request · manual |
| 🔐 **DB settings** | `PAYROLL_DB_URL` / `_USER` / `_PASSWORD` |

</td>
</tr>
</table>

---

## ✅ Latest Results (GitHub Actions)

| Group | Classes | Tests | ✅ Passed |
|---|---|---:|---:|
| 🧩 Business logic | `PayrollCalculator` · `AmountToWordsConverter` · `PayslipFormatter` · `EmployeeFormValidator` · `AuthService` · `SearchQueryHelper` · `SearchFilterHelper` · `DeleteEmployeeHelper` | 125 | 125 |
| 🛡️ Security | `SecurityTest` (SQL-injection inputs, bad regex) | 24 | 24 |
| 🖥️ Swing (headless) | `UIHelperTest`, `ViewEmployeeTabTest` | 5 | 5 |
| 📐 SQL ↔ schema | `SqlSchemaConsistencyTest` (scans every SQL string) | 1 | 1 |
| 📦 Build | `BuildConfigTest` (JAR main class exists) | 1 | 1 |
| 🗄️ Real MySQL | `EmployeeSqlIntegrationTest` | 4 | 4 |
| **Total** | **15 classes** | **160** | **160** |

```mermaid
pie showData
    title 160 tests by group
    "Business logic (125)" : 125
    "Security (24)" : 24
    "Swing headless (5)" : 5
    "Real MySQL (4)" : 4
    "SQL vs schema (1)" : 1
    "Build config (1)" : 1
```

```mermaid
xychart-beta
    title "Tests per class"
    x-axis ["FormValid", "Security", "PayslipFmt", "PayrollCalc", "SearchQuery", "AmtWords", "DeleteHlp", "Auth", "SearchFilt", "DBInteg", "ViewTab", "UIHelper", "SqlSchema", "BuildCfg"]
    y-axis "Tests" 0 --> 45
    bar [40, 24, 20, 19, 15, 9, 9, 8, 5, 4, 3, 2, 1, 1]
```

### Red first, then green

The two new regression tests went in **before** the fixes, and CI was red for exactly the bugs they target:

| CI run | What happened |
|---|---|
| 1 | ❌ **compile error**: `PayrollTabbedGUI.java` also defined `ViewEmployeeTab`, `DeleteEmployeeTab`, `WelcomeTab`, `LoginTab`, `RefreshTab` (duplicate classes) |
| 2 | ❌ compile error: `new RefreshTab(viewTab)`, but the real constructor needs the View **and** Update tabs |
| 3 | ❌ 2 / 2 tests failed: `bankname, accountno, holiday_paid_hours, special_work_hours` are not columns; JAR main class `PayrollSystem_V14_DB_Full` does not exist |
| 4 | ✅ 160 / 160 after the fixes; JAR manifest verified |

```mermaid
xychart-beta
    title "Tests passing per CI run"
    x-axis ["Run 1", "Run 2", "Run 3", "Run 4"]
    y-axis "Passing tests" 0 --> 170
    bar [0, 0, 0, 160]
```

---

## 🏗️ Architecture

```mermaid
flowchart LR
    subgraph UI["🖥️ Swing tabs (PayrollTabbedGUI)"]
        W[Welcome] --> L[Login]
        A[Add Employee]
        V[View Employees]
        U[Update Employee]
        D[Delete Employee]
        S[Search Employee]
        P[Payslip]
        R[Refresh]
    end
    subgraph Logic["🧠 Pure logic (unit tested)"]
        PC[PayrollCalculator]
        AW[AmountToWordsConverter]
        PF[PayslipFormatter]
        EV[EmployeeFormValidator]
        AS[AuthService]
        SQ[SearchQueryHelper]
        SF[SearchFilterHelper]
        DH[DeleteEmployeeHelper]
    end
    DB[(MySQL 8<br/>payroll_db.employees)]
    L --> AS
    A & U --> PC & EV
    P --> PF & AW
    S --> SQ
    V --> SF
    D --> DH
    UI -->|DBConnection · PAYROLL_DB_*| DB
```

### CI pipeline

```mermaid
flowchart TD
    P([push / PR / manual]) --> T[Job 1: tests]
    T --> M[(MySQL 8 service)]
    M --> S[db/setup_payroll_db.sql<br/>schema · admin user · 2 sample rows]
    S --> X[mvn test · 160 JUnit 5 tests]
    X --> C{DB tests ran?<br/>skipped = 0}
    C -->|green| J[Job 2: mvn package]
    J --> K{Main-Class in the JAR<br/>really exists?}
    K --> JAR[(payroll-system-1.0.0.jar)]
```

### Add an employee

```mermaid
sequenceDiagram
    autonumber
    actor HR as HR user
    participant A as AddEmployeeTab
    participant V as EmployeeFormValidator
    participant C as PayrollCalculator
    participant DB as MySQL
    HR->>A: name, phone, dates, rate $20, 40 h + 5 h OT
    A->>V: names (O'Brien OK), phone (+1 / dashes OK), MM/dd/yyyy STRICT
    V-->>A: valid
    A->>C: calculate(20, 40, 5, 0, 0, 0, 0, 0)
    C-->>A: gross 950.00 · tax 190.00 · medical 95.00 · net 665.00
    A->>DB: INSERT (34 columns, ytd_gross = gross)
    DB-->>A: 1 row
    A-->>HR: Employee added ✓ (View tab reloads)
```

### Employee record lifecycle

```mermaid
stateDiagram-v2
    [*] --> Validated: Add form
    Validated --> Rejected: invalid name / phone / date / negative hours
    Rejected --> Validated: fix and retry
    Validated --> Active: INSERT, pay calculated
    Active --> Active: Update (pay recalculated, every amount saved)
    Active --> Paid: payslip + cheque for a pay date
    Paid --> Active: next period
    Active --> Hidden: active = 0
    Hidden --> Active: active = 1
    Active --> [*]: Delete
    Hidden --> [*]: Delete
```

---

## 💰 Payroll Rules

| Component | Formula |
|---|---|
| Normal pay | `min(totalHours, 40) × rate` |
| Overtime | `overtimeHours × rate × 1.5` |
| Double time | `doubletimeHours × rate × 2` |
| Extended / Holiday / Special work | `hours × rate` |
| **Gross** | sum of the above + bonus |
| Tax | `gross × 20 %` |
| Medical | `gross × 10 %` |
| **Net** | `gross − tax − medical` |

```mermaid
pie showData
    title "Where a $950 gross goes (40 h x $20 + 5 h OT)"
    "Net pay" : 665
    "Tax 20%" : 190
    "Medical 10%" : 95
```

Negative rates, hours or bonuses are rejected. Money is rounded half-up to cents. The cheque line reads `SIX HUNDRED SIXTY FIVE AND 00/100`.

---

## 🗄️ Database

The schema the code actually uses is in [`db/setup_payroll_db.sql`](db/setup_payroll_db.sql). One `employees` table holds the profile, hours, amounts and the last pay date.

```mermaid
erDiagram
    EMPLOYEES {
        int id PK
        int employee_id UK
        varchar first_name
        varchar last_name
        varchar ssn
        varchar designation
        varchar department
        varchar contact_no
        varchar email_id
        date hire_date
        varchar bank_name
        varchar account_no
        double pay_rate_hourly
        double Total_hours
        double overtime_hours
        double overtime_amount
        double holidaypaid_hours
        double holidaypaid_amount
        double bonus_amount
        double gross_salary
        double ytd_gross
        double tax_deduction
        double medical_insurance
        double net_salary
        date pay_date
        tinyint active
    }
```

<sub>Simplified: the table also has doubletime, extended and special-work hours/amounts, `customer`, `salary` and `total_deductions`.</sub>

---

## ▶️ Running Locally

**Prerequisites:** JDK 21, Maven 3.9+, MySQL 8.

```bash
# 1. Database: payroll_db, user admin/admin123 (local demo only), 2 sample employees
mysql -u root -p < db/setup_payroll_db.sql

# 2. Tests (DB tests skip if MySQL is not reachable)
mvn test

# 3. Build and run
mvn -DskipTests package
java -jar target/payroll-system-1.0.0.jar      # demo login: admin / admin123
```

| Setting | Env var | `-D` property | Default |
|---|---|---|---|
| JDBC URL | `PAYROLL_DB_URL` | `payroll.db.url` | `jdbc:mysql://localhost:3306/payroll_db` |
| DB user | `PAYROLL_DB_USER` | `payroll.db.user` | `admin` |
| DB password | `PAYROLL_DB_PASSWORD` | `payroll.db.password` | `admin123` |

---

## 📁 Project Structure

```text
PayrollManagementSystem/
├── .github/workflows/ci.yml        # MySQL service + JUnit, fat-JAR job
├── db/setup_payroll_db.sql         # schema, app user, sample rows
├── pom.xml                         # Java 21 · Connector/J · JUnit 5 · shade
└── src/
    ├── main/java/com/payroll/
    │   ├── PayrollTabbedGUI.java   # main window (JAR entry point)
    │   ├── *Tab.java               # Welcome, Login, Add, View, Update, Delete, Search, Payslip, Refresh
    │   ├── PayrollCalculator.java  # pay engine
    │   ├── AmountToWordsConverter.java · PayslipFormatter.java
    │   ├── EmployeeFormValidator.java · AuthService.java
    │   ├── SearchQueryHelper.java · SearchFilterHelper.java · DeleteEmployeeHelper.java
    │   └── DBConnection.java
    └── test/java/com/payroll/      # 15 JUnit 5 classes
```

---

## 🧹 Maintenance Log

| Area | Before | Now |
|---|---|---|
| **Build** | **did not compile**: 5 tab classes defined twice; `RefreshTab` called with the wrong arguments | compiles; CI builds every push |
| **Runnable JAR** | manifest pointed at `PayrollSystem_V14_DB_Full`, which does not exist | `com.payroll.PayrollTabbedGUI`; CI checks the manifest |
| **Update Employee** | SQL used 4 non-existent columns → every update failed; gross / net never saved | correct columns, all amounts saved; proven on real MySQL |
| Pay maths | Add and Update used different formulas (no 40 h cap, extended ×1.5, special work without the rate) | one `PayrollCalculator` for both |
| Cheque | words lost a space, billions dropped, cents in words | `… AND 50/100`, singular "One Dollar" |
| Dates | `11/31/2025` silently became `11/30/2025` | rejected (STRICT parsing) |
| Validation | `O'Brien`, `Anne-Marie`, `+1 555-0100` rejected | accepted; negative hours rejected |
| Live search | typing `(` or `*` threw `PatternSyntaxException` | safe filter |
| YTD gross | always 0 | starts at the first period's gross |
| Database | README showed an `Employee(emp_id, emp_name…)` + `Attendance` schema the code never used | real schema in `db/setup_payroll_db.sql` |
| Repo | `target/`, `.classpath`, `.project` committed | removed; `.gitignore` |
| README | described HRA / DA / PF, attendance tracking and sign-up, none of which exist | rewritten from the code and the CI run |

---

## 📈 Roadmap

- [x] Compiles, tested and packaged in CI
- [x] Update Employee works against the real schema
- [ ] `payroll_history` table so YTD gross is a real yearly sum
- [ ] Hash the login password instead of a fixed demo pair
- [ ] PDF payslips (iText 7 is already a dependency)
- [ ] Excel payroll report (Apache POI is already a dependency)

---

## 🔗 Related Projects

| Repo | What it is |
|---|---|
| [PayrollManagementSystems_Automation_Java_MySql_Selenium](https://github.com/rbchy/PayrollManagementSystems_Automation_Java_MySql_Selenium) | Same app with the full 260-test suite: Cucumber BDD, AssertJ-Swing UI robots, MySQL |
| [InventoryControlManagement_JavaMySql](https://github.com/rbchy/InventoryControlManagement_JavaMySql) | Java Swing + MySQL inventory app with CI |
| [BhojanAloy-Food-Coffee-Shop-POS-System](https://github.com/rbchy/BhojanAloy-Food-Coffee-Shop-POS-System) | Java POS system with MySQL |
| [rbchy](https://github.com/rbchy/rbchy) | Profile and full project list |

---

## ⚠️ Disclaimer

Educational / portfolio project. Tax and insurance rates are fixed demo values, not real payroll law. `admin / admin123` are local demo credentials only.

---

## 👤 Author

<div align="center">

**Ranajit Baran Chowdhury (RB Chowdhury)**
Software Programmer & QA Automation Engineer · West Norriton, Pennsylvania, USA

[![LinkedIn](https://img.shields.io/badge/LinkedIn-0077B5?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/rbchy/)
[![GitHub](https://img.shields.io/badge/GitHub-181717?style=for-the-badge&logo=github&logoColor=white)](https://github.com/rbchy)
[![Website](https://img.shields.io/badge/Website-rbchy.github.io%2Frbchy-0d9488?style=for-the-badge&logo=githubpages&logoColor=white)](https://rbchy.github.io/rbchy/)
[![Portfolio](https://img.shields.io/badge/Portfolio-Website-blueviolet?style=for-the-badge&logo=wix&logoColor=white)](https://rbc6543.wixsite.com/rbc-portfolio)
[![Gmail](https://img.shields.io/badge/Gmail-D14836?style=for-the-badge&logo=gmail&logoColor=white)](mailto:chyranajit@gmail.com)

⭐ *If this project helps you, a star on the repo is appreciated.*

</div>
