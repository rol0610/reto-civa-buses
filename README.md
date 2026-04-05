# reto-civa-buses

## Tecnologías
- Backend: Java 17, Spring Boot 3, Spring Security, JPA
- Base de datos: PostgreSQL
- Frontend: React 18

## Cómo ejecutar

### Backend
1. Crear base de datos:
   CREATE DATABASE buses_db;
2. Ingresar a application.properties en back\api-bus\src\main\resources\application.properties y colocar user y pass de postgre local
3. Ejecutar en carpeta proyecto api-bus:
   mvn spring-boot:run
4. http://localhost:8080/bus    http://localhost:8080/bus/(numero)

### Frontend
1. En carpeta frontend:
2. npm install
3. npm start
4. http://localhost:3000/

### Credenciales
- Usuario: admin
- Password: 1234

## Autor
Rolando Torres
