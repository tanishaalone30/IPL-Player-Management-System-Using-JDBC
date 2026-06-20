# 🏏 IPL Player Management System

A console-based **CRUD application** for managing IPL (Indian Premier League) player data, built with **Core Java** and **JDBC** following a layered **MVC architecture**.

---

## 📋 Table of Contents

- [About the Project](#about-the-project)
- [Features](#features)
- [Tech Stack](#tech-stack)
- [Project Architecture](#project-architecture)
- [Database Schema](#database-schema)
- [Getting Started](#getting-started)
- [Usage](#usage)
- [Project Structure](#project-structure)

---

## 📖 About the Project

This project is a **Java Full Stack** learning exercise that demonstrates how to perform database operations using **JDBC (Java Database Connectivity)** with **MySQL**. It provides a menu-driven console interface to manage IPL cricket players — including adding, viewing, updating, and deleting player records — along with filtering capabilities by role and team.

---

## ✨ Features

| # | Feature | Description |
|---|---------|-------------|
| 1 | **View All Players** | Retrieve and display the complete list of IPL players from the database |
| 2 | **Insert Player** | Add a new player with details like jersey number, name, runs, wickets, team, and role |
| 3 | **Update Runs** | Update the run count for a specific player by their Player ID |
| 4 | **Delete Player** | Remove a player record from the database by Player ID |
| 5 | **Filter Bowlers** | View all players whose role is *Bowler* |
| 6 | **Filter Batters** | View all players whose role is *Batter* |
| 7 | **Filter All-Rounders** | View all players whose role is *AllRounder* |
| 8 | **Team-Wise Filter** | View all players belonging to a specific IPL team |

---

## 🛠️ Tech Stack

| Technology | Purpose |
|------------|---------|
| **Java (Core)** | Application logic |
| **JDBC** | Database connectivity |
| **MySQL** | Relational database |
| **MySQL Connector/J** | JDBC driver (`com.mysql.cj.jdbc.Driver`) |

---

## 🏗️ Project Architecture

The project follows a **3-tier layered architecture** (MVC pattern):

```
┌─────────────────────────────────┐
│       Controller Layer          │
│   (IPLController.java)          │
│   Console UI / Menu-driven      │
├─────────────────────────────────┤
│        Service Layer            │
│   (IPLService.java)             │
│   Business logic & filtering    │
├─────────────────────────────────┤
│          DAO Layer              │
│   (IPLDao.java)                 │
│   JDBC queries & DB operations  │
├─────────────────────────────────┤
│         Entity Layer            │
│   (Player.java)                 │
│   Data model / POJO             │
├─────────────────────────────────┤
│       MySQL Database            │
│   Table: ipl_player             │
└─────────────────────────────────┘
```

---

## 🗄️ Database Schema

### Database: `kiran_sql`

### Table: `ipl_player`

```sql
CREATE TABLE ipl_player (
    pid      INT PRIMARY KEY,
    jn       INT,
    pname    VARCHAR(100),
    runs     INT,
    wickets  INT,
    tname    VARCHAR(100),
    role     VARCHAR(50)
);
```

| Column    | Type          | Description             |
|-----------|---------------|-------------------------|
| `pid`     | INT (PK)      | Player ID               |
| `jn`      | INT           | Jersey Number           |
| `pname`   | VARCHAR(100)  | Player Name             |
| `runs`    | INT           | Total Runs Scored       |
| `wickets` | INT           | Total Wickets Taken     |
| `tname`   | VARCHAR(100)  | Team Name (e.g., CSK)   |
| `role`    | VARCHAR(50)   | Role (Batter / Bowler / AllRounder) |

### Sample Data

```sql
INSERT INTO ipl_player VALUES (1, 18, 'Virat Kohli', 8004, 4, 'RCB', 'Batter');
INSERT INTO ipl_player VALUES (2, 7, 'MS Dhoni', 5082, 0, 'CSK', 'Batter');
INSERT INTO ipl_player VALUES (3, 63, 'Jasprit Bumrah', 56, 145, 'MI', 'Bowler');
INSERT INTO ipl_player VALUES (4, 55, 'Ravindra Jadeja', 2502, 132, 'CSK', 'AllRounder');
```

---

## 🚀 Getting Started

### Prerequisites

- **Java JDK 8** or higher
- **MySQL Server** (5.7+)
- **MySQL Connector/J** JAR file (JDBC driver)

### Setup Instructions

1. **Clone the repository**
   ```bash
   git clone https://github.com/your-username/IPL_Project_byJDBC.git
   cd IPL_Project_byJDBC
   ```

2. **Create the database and table in MySQL**
   ```sql
   CREATE DATABASE kiran_sql;
   USE kiran_sql;

   CREATE TABLE ipl_player (
       pid      INT PRIMARY KEY,
       jn       INT,
       pname    VARCHAR(100),
       runs     INT,
       wickets  INT,
       tname    VARCHAR(100),
       role     VARCHAR(50)
   );
   ```

3. **Configure database credentials**

   Open `dao/IPLDao.java` and update the connection details:
   ```java
   private String url  = "jdbc:mysql://localhost:3306/kiran_sql";
   private String user = "root";
   private String pwd  = "your_password";
   ```

4. **Add the MySQL Connector/J JAR to your classpath**

5. **Compile and run**
   ```bash
   javac -cp ".;mysql-connector-j-8.x.x.jar" com/tka/controller/IPLController.java
   java  -cp ".;mysql-connector-j-8.x.x.jar" com.tka.controller.IPLController
   ```
   > On Linux/macOS, replace `;` with `:` in the classpath separator.

---

## 🎮 Usage

When you run the application, you'll see an interactive menu:

```
===== IPL MENU =====
1. Get All Players
2. Insert
3. Update Runs
4. Delete
5. Bowlers
6. Batters
7. All Rounders
8. Team Wise
9. Exit
```

**Example — Inserting a player:**
```
Choose option: 2
PID: 5
Jersey: 45
Name: Rohit Sharma
Runs: 6211
Wickets: 15
Team: MI
Role: Batter
→ 1 Inserted
```

**Example — Filtering by team:**
```
Choose option: 8
Enter Team Name: CSK
→ 2 7 MS Dhoni 5082 0 CSK Batter
→ 4 55 Ravindra Jadeja 2502 132 CSK AllRounder
```

---

## 📂 Project Structure

```
IPL_Project_byJDBC/
│
├── controller/
│   └── IPLController.java      # Entry point — menu-driven console UI
│
├── service/
│   └── IPLService.java         # Business logic — role & team filtering
│
├── dao/
│   └── IPLDao.java             # Data Access — JDBC CRUD operations
│
├── entity/
│   └── Player.java             # POJO — Player data model
│
├── src/
│   └── com/tka/                # Package-mirrored source (com.tka.*)
│       ├── controller/
│       ├── service/
│       ├── dao/
│       └── entity/
│
└── README.md
```

---

## 📝 Key Concepts Demonstrated

- **JDBC Connection** using `DriverManager` and MySQL Connector/J
- **PreparedStatement** for parameterized, SQL-injection-safe queries
- **CRUD Operations** — Create, Read, Update, Delete
- **MVC Layered Architecture** — Controller → Service → DAO → Entity
- **Java Collections** — `ArrayList`, `List` for data handling
- **Stream-style iteration** with `forEach` and method references

---

## ⚠️ Important Notes

- Update the **database credentials** in `IPLDao.java` before running.
- Ensure the MySQL server is running and the `ipl_player` table exists.
- The `role` field accepts: `Batter`, `Bowler`, or `AllRounder` (case-insensitive for filtering).

---

## 📄 License

This project is for **educational purposes** as part of Java Full Stack learning.

---

> Built with ☕ Java & 🏏 Love for Cricket
