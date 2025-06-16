# 🏋️‍♂️ Spring Boot Fitness App

**Spring Boot Fitness App** is a modern multi-module backend project built with Java and Spring Boot 3.x.
It showcases microservice architecture principles, production-grade Actuator monitoring, Git metadata tracking, and PostgreSQL database integration.

---

## 📦 Project Structure

    springboot-fitness-app/ │
        ├── pom.xml (Root Project)
        └── userservice/
            ├── pom.xml (User Service Module)
            ├── src/main/java/com/fitness/userservice/
            └── src/main/resources/

- **Root Project**: Manages shared configuration, parent dependencies, and build plugins.
- **User Service**: A Spring Boot microservice for managing user data (registration, login, profiles).

---

## 🚀 Features

- **Multi-Module Maven Project**
- **Spring Boot 3.x** with Java 21/24
- **PostgreSQL Database Integration**
- **Spring Data JPA**
- **Docker-ready** (PostgreSQL containerized)
- **Spring Boot Actuator** endpoints for health, metrics, and info
- **Git Commit Metadata** and **Build Info** injected into `/actuator/info`
- **Lombok** for clean and concise models

---

## 🛠 Tech Stack

- Java 21 / 24 (OpenJDK)
- Spring Boot 3.x
- Maven (multi-module setup)
- PostgreSQL (local or Docker)
- Spring Data JPA
- Lombok
- Docker
- Spring Boot Actuator

---

## ⚙️ Setup and Run

### 1. Clone the Repository

```
git clone https://github.com/yourusername/springboot-fitness-app.git
cd springboot-fitness-app
```

### 2. Start PostgreSQL via Docker (optional)

    docker run --name postgres-fitness \
        -e POSTGRES_PASSWORD=postgres123 \
        -p 5432:5432 \
        -d postgres

### 3. Build the project

    ./mvnw clean install

### 4. Run the User/<Individual> Service (Optional)

    cd userservice
    mvn spring-boot:run

## 🧠 Credits

Built with ❤️ and ☕ by [Ashish Karki](https://github.com/ashishkarki)

Learning, Building, and Sharing modern backend architectures.
