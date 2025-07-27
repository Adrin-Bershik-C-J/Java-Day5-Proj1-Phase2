# 🐞 Bug Tracking System (Java + PostgreSQL)

This is a **console-based Bug Tracking System** built in Java (Maven project) with **PostgreSQL** as the database.  
It allows users to **add, view, update, and delete** bug records.

---

## 📂 Project Structure
```
adrin-bershik-c-j-java-day5-proj1-phase2/
├── pom.xml                     # Maven configuration
└── src/
    ├── main/java/com/day5proj1phase2/
    │   ├── Main.java           # Entry point (menu-driven program)
    │   ├── dao/BugDAO.java     # DAO layer for database operations
    │   ├── models/Bug.java     # Bug entity class
    │   └── utils/DBUtil.java   # Database connection utility
    └── test/java/com/day5proj1phase2/
        └── AppTest.java        # Placeholder for tests
```

---

## ⚡ Features
✔️ Add a new bug  
✔️ View all bugs  
✔️ Delete a bug by ID  
✔️ Update bug status by ID  
✔️ Input validation & exception handling  

---

## 🛠️ Technologies Used
- **Java 17+**
- **PostgreSQL**
- **JDBC**
- **Maven**

---

## 🗄️ Database Setup
1. Install and start PostgreSQL.  
2. Create a table:
```sql
CREATE TABLE bugtable (
    id SERIAL PRIMARY KEY,
    title VARCHAR(100),
    description TEXT,
    status VARCHAR(50)
);
```
3. Update `DBUtil.java` with your PostgreSQL credentials:
```java
con = DriverManager.getConnection(
    "jdbc:postgresql://localhost:5432/postgres", 
    "postgres", 
    "your_password"
);
```

---

## ▶️ How to Run
1. Clone the repository:
   ```bash
   git clone https://github.com/your-username/adrin-bershik-c-j-java-day5-proj1-phase2.git
   cd adrin-bershik-c-j-java-day5-proj1-phase2
   ```
2. Build the project:
   ```bash
   mvn clean install
   ```
3. Run the program:
   ```bash
   mvn exec:java -Dexec.mainClass="com.day5proj1phase2.Main"
   ```

---

## 🖥️ Usage
When you run the program, you’ll see:
```
1. Insert a bug
2. View all bugs
3. Delete bug by ID
4. Update bug status by ID
5. Exit
```
Follow the menu to manage bugs interactively.

---

## ✅ Example Run
```
1. Insert a bug
2. View all bugs
3. Delete bug by ID
4. Update bug status by ID
5. Exit
Enter your choice: 1
Enter title: Login Issue
Enter description: Cannot log in with credentials
Enter status: Open
✅ Bug inserted successfully!
```

---

## 🤝 Contribution
Feel free to fork and improve the project. Pull requests are welcome!

---

