# 🛍 ShopEase — Java OOP + JDBC Console Application

## 📁 Project Structure

```
ShopEase/
├── src/
│   └── shopease/
│       ├── model/          ← OOP: Model classes (Entities)
│       │   ├── User.java           (Abstract base class)
│       │   ├── Customer.java       (extends User)
│       │   ├── Admin.java          (extends User)
│       │   ├── Product.java
│       │   ├── Order.java
│       │   └── ReturnRequest.java
│       ├── dao/            ← JDBC: Database Access Objects
│       │   ├── DBConnection.java   (Singleton pattern)
│       │   ├── UserDAO.java        (Interface)
│       │   ├── UserDAOImpl.java    (JDBC implementation)
│       │   ├── ProductDAO.java     (Interface)
│       │   ├── ProductDAOImpl.java
│       │   ├── OrderDAO.java       (Interface)
│       │   ├── OrderDAOImpl.java
│       │   ├── ReturnDAO.java      (Interface)
│       │   └── ReturnDAOImpl.java
│       ├── service/        ← Business Logic Layer
│       │   └── ShopService.java
│       └── ui/             ← Console UI
│           ├── Main.java           (Entry point)
│           ├── CustomerUI.java
│           └── AdminUI.java
├── lib/
│   └── mysql-connector-j-9.x.x.jar  ← (you download this)
├── database_setup.sql      ← Run this in MySQL first
└── .vscode/
    ├── launch.json
    └── settings.json
```

---

## 🔑 OOP Concepts Used

| Concept | Where Used |
|---|---|
| **Abstraction** | `User` abstract class, `UserDAO` / `ProductDAO` / `OrderDAO` interfaces |
| **Inheritance** | `Customer extends User`, `Admin extends User` |
| **Polymorphism** | `loginAs()` returns `User`, cast to `Admin` or `Customer` at runtime |
| **Encapsulation** | All fields private with getters/setters in every model class |
| **Composition** | `ShopService` HAS-A `UserDAO`, `ProductDAO`, `OrderDAO`, `ReturnDAO` |
| **Interface** | `UserDAO`, `ProductDAO`, `OrderDAO`, `ReturnDAO` define contracts |
| **Singleton** | `DBConnection` — one shared DB connection |

---

## ⚙️ Step 1 — Install Requirements

### A. Java JDK 17+
- Download from: https://www.oracle.com/java/technologies/downloads/
- Install and set PATH
- Verify: open terminal → `java -version`

### B. MySQL
- Download from: https://dev.mysql.com/downloads/installer/
- Install MySQL Server + MySQL Workbench
- Set root password (remember it — you'll need it)

### C. VS Code + Extensions
- Download VS Code: https://code.visualstudio.com/
- Install extension: **"Extension Pack for Java"** by Microsoft
  (includes Language Support, Debugger, Maven, etc.)

---

## ⚙️ Step 2 — Download MySQL JDBC Driver

1. Go to: https://dev.mysql.com/downloads/connector/j/
2. Select: **Platform Independent → ZIP Archive**
3. Download and unzip
4. Copy the file `mysql-connector-j-X.X.X.jar` into the `ShopEase/lib/` folder

---

## ⚙️ Step 3 — Set Up Database

1. Open **MySQL Workbench** (or MySQL CLI)
2. Connect to your MySQL server
3. Open the file `database_setup.sql`
4. Click **Run** (⚡ button) or press `Ctrl+Shift+Enter`
5. You should see: `Setup complete!` with user and product counts

---

## ⚙️ Step 4 — Configure DB Password in Code

Open this file:
```
src/shopease/dao/DBConnection.java
```

Change line 12 to your MySQL root password:
```java
private static final String PASSWORD = "your_actual_password";
```

If your MySQL username is not `root`, change that too:
```java
private static final String USER = "root";  // change if different
```

---

## ⚙️ Step 5 — Open Project in VS Code

1. Open VS Code
2. **File → Open Folder** → select the `ShopEase` folder
3. VS Code will detect it as a Java project automatically
4. Wait for the Java extension to finish loading (bottom status bar)

---

## ▶️ Step 6 — Run the Project

### Option A — Using VS Code Run Button
1. Open `src/shopease/ui/Main.java`
2. Click the **▶ Run** button that appears above `public static void main`

### Option B — Using VS Code Terminal
```bash
# From inside the ShopEase folder:

# Compile all files
javac -cp "lib/*" -d bin src/shopease/model/*.java src/shopease/dao/*.java src/shopease/service/*.java src/shopease/ui/*.java

# Run
java -cp "bin;lib/*" shopease.ui.Main
```
> On Mac/Linux use `:` instead of `;` in classpath:
```bash
java -cp "bin:lib/*" shopease.ui.Main
```

### Option C — Using launch.json (Debug)
1. Press `F5` or go to **Run → Start Debugging**
2. Select **"Run ShopEase"**

---

## 🔐 Demo Login Accounts

| Role | Email | Password |
|---|---|---|
| Admin | admin@shopease.com | admin123 |
| Customer | rahul@shopease.com | pass123 |
| Customer | priya@shopease.com | pass123 |
| Customer | amit@shopease.com | pass123 |

---

## 🎯 Features

### Customer
- Register (saves to DB, shows welcome email simulation)
- Login (shows login notification simulation)
- Browse all 23 products / Browse by category
- Place order (reduces stock, saves to DB)
- View my orders
- Submit return request
- View my return status

### Admin
- View all customers with risk level, order count, return count
- View all orders + total revenue (confirmed orders only)
- View all return requests (Pending / Approved / Rejected)
- Approve or Reject return requests
- Block / Unblock customers
- Update customer risk level (low / medium / high)
- View all products
- Add new products

---

## ❗ Common Errors

| Error | Fix |
|---|---|
| `ClassNotFoundException: com.mysql.cj.jdbc.Driver` | JAR not in `lib/` folder or not added to classpath |
| `Access denied for user 'root'` | Wrong password in `DBConnection.java` |
| `Unknown database 'shopease_db'` | Run `database_setup.sql` first |
| `Communications link failure` | MySQL server is not running — start it first |
| `java: error: release version 17 not supported` | Set Java 17+ in VS Code settings |
