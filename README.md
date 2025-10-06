# 🌐 Employee Data Management (Full Stack Application)

## 1️⃣ Project Description

The **Employee Data Management** project is a full-stack web application built with **Angular (frontend)** and **Spring Boot (backend)**.  
It enables users to manage employee records efficiently through a user-friendly interface.

Each employee record includes details like `ID`, `Name`, `Email`, `Position`, and `Salary`.

---

### ✨ Key Features

#### 🖥️ Frontend (Angular)
- Responsive and clean UI for managing employees  
- Create, read, update, and delete (CRUD) employee records  
- Integrated search functionality  
- Form validation for input fields  
- Real-time data updates via REST API integration  

#### ⚙️ Backend (Spring Boot)
- REST APIs for employee operations  
- Validation using `@Valid` annotations  
- Global exception handling for clean error responses  
- In-memory **H2 Database** (easy setup and testing)  
- Layered architecture (Controller → Service → Repository)

---

## 2️⃣ Setup and Run Instructions (Local)

### 🧩 Prerequisites

| Component | Required |
|------------|-----------|
| Java | 17 or higher |
| Node.js | 18+ |
| npm | 9+ |
| Maven | Installed |
| IDE | Eclipse |

---

## ⚙️ Backend Setup (Spring Boot)

1. **Clone the repository**
   ```bash
   git clone https://github.com/Sanskruti2214/Employee-Data-Management.git
   ```

2. **Open the project in Eclipse**
   - Open **Eclipse IDE**
   - Go to `File → Import → Existing Maven Projects`
   - Select the backend project folder (e.g., `employee-management`)
   - Click **Finish**

3. **Configure database (H2 In-Memory)**
   No external setup required.  
   Once the app runs, the database is automatically created in memory.

4. **Run the backend**
   - Right-click on `EmployeeDataManagementApplication.java`
   - Select `Run As → Spring Boot App`
   - Backend runs at:  
     👉 `http://localhost:8080/api/employees`

5. **Access H2 Console**
   ```
   http://localhost:8080/h2-console
   ```
   - **JDBC URL:** `jdbc:h2:mem:employee_db`  
   - **Username:** `Employee`  
   - **Password:** 1234

---

## 🖥️ Frontend Setup (Angular)

1. **Navigate to the frontend folder**
   ```bash
   cd src/main/frontend
   ```

2. **Install dependencies**
   ```bash
   npm install
   ```

3. **Run the Angular application**
   ```bash
   ng serve
   ```

4. The frontend runs at:  
   👉 `http://localhost:4200/home`

5. Make sure your **Spring Boot backend** is running at  `http://localhost:8080/api/employees`
   (The Angular app consumes the backend APIs.)

---

## 3️⃣ Running Test Cases

### 🧪 Backend Tests
Run JUnit tests via:
In Eclipse:
```
Right-click → Run As → JUnit Test
```

## 4️⃣ Assumptions and Design Choices

- Each employee must have a **unique email address**.
- Used **H2 Database** for simplicity — no manual setup needed.
- Follows **3-tier architecture**:
  - **Controller Layer** → API endpoints  
  - **Service Layer** → Business logic & validation  
  - **Repository Layer** → Database interaction
- Global exception handling ensures clean and consistent API responses.
- Angular uses a service class to communicate with backend REST APIs via `HttpClient`.
- Both modules can run independently for testing.

---

## 🧠 Tech Stack

| Layer | Technology |
|--------|-------------|
| Frontend | Angular 17, TypeScript, HTML, CSS |
| Backend | Spring Boot 3, Java 17 |
| Database | H2 (In-Memory) |
| Build Tools | Maven (backend), npm (frontend) |
| IDEs | Eclipse  |
| Testing | JUnit (backend) |

---

## 🧩 Folder Structure Overview

```
Employee-Data-Management/
│
├── backend/
│   ├── src/main/java/com/example/employee/...
│   ├── src/main/resources/
│   │   ├── application.properties
│   └── pom.xml
│
└── frontend/
    ├── src/app/
    ├── package.json
    └── angular.json
```

---

## 🧑‍🔧 Author

**Sanskruti Bhise**  
📧 [sanskrutibhise03@gmail.com](mailto:sanskrutibhise03@gmail.com)

---

