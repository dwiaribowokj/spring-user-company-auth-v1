# 🔐 user-company-auth-v1

Microservice ini bertanggung jawab untuk menangani proses **autentikasi** seperti login, register, dan validasi token.  
Service ini akan digunakan oleh gateway dan client untuk otorisasi akses endpoint yang dilindungi.

---

## 🚀 Fitur

- ✅ Register User (`POST /auth/register`)
- ✅ Login dan generate JWT (`POST /auth/login`)
- 🧠 (Opsional) Get user info dari token (`GET /auth/me`)
- 🔐 Password terenkripsi menggunakan BCrypt
- 🪪 Token berbasis JWT
- 🌐 Integrasi Eureka dan siap digunakan dari Gateway

---

## ⚙️ Konfigurasi `application.yml`

```yaml
server:
  port: 8083

spring:
  application:
    name: user-company-auth-v1

eureka:
  client:
    service-url:
      defaultZone: http://localhost:8761/eureka
```

---

## 🧩 Dependency Penting

- Spring Boot Web
- Spring Boot Security
- Spring Boot Validation
- JJWT (JWT Generator/Parser)
- Lombok

---

## 📂 Struktur Awal

```
src/main/java/com/company/user/auth/v1/
├── controller/
│   └── AuthController.java
├── dto/
│   ├── AuthLoginRequest.java
│   ├── AuthRegisterRequest.java
│   └── AuthResponse.java
├── service/
│   ├── AuthService.java
│   └── AuthServiceImpl.java
├── config/
│   └── SecurityConfig.java
├── util/
│   └── JwtUtil.java
└── UserCompanyAuthV1Application.java
```

---

## ▶️ Menjalankan

```bash
mvn clean install
mvn spring-boot:run
```

Swagger dapat ditambahkan untuk eksplorasi endpoint.

---

## 🔐 Catatan Keamanan

- Token JWT perlu diverifikasi di Gateway di masa depan
- Token dapat ditambahkan ke header: `Authorization: Bearer <token>`
- Durasi token dan secret bisa dikonfigurasi di `application.yml`

---

## 👨‍💻 Maintainer

[@dwiaribowokj](https://github.com/dwiaribowokj)