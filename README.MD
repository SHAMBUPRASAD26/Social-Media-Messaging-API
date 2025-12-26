# Social Media API – Spring Boot Project

This project is a simple Social Media REST API built using Spring Boot and Java 21.  
It allows users to register, log in, and create, read, update, and delete messages.

The application uses Spring Data JPA with an H2 database and follows RESTful principles.

---

## Technologies Used

- Java 21
- Spring Boot
- Spring Web
- Spring Data JPA
- H2 Database
- Maven

---

## Project Features

- User Registration
- User Login
- Create a Message
- Get All Messages
- Get Message by ID
- Update a Message
- Delete a Message
- Get All Messages by User

---

## API Endpoints

### Register User
POST /register

Request Body:
{
  "username": "user1",
  "password": "pass1234"
}

---

### Login
POST /login

Request Body:
{
  "username": "user1",
  "password": "pass1234"
}

---

### Create Message
POST /messages

Request Body:
{
  "message_text": "Hello Spring Boot!",
  "postedBy": 1
}

---

### Get All Messages
GET /messages

---

### Get Message by ID
GET /messages/{message_id}

---

### Update Message
PATCH /messages/{message_id}

Request Body:
{
  "message_text": "Updated message"
}

---

### Delete Message
DELETE /messages/{message_id}

---

### Get Messages by User
GET /accounts/{account_id}/messages

---

## Database

The application uses an H2 in-memory database by default.  
All data will be cleared when the server restarts.

---

## How to Run the Project

1. Open the project in VS Code
2. Make sure Java 21 is installed
3. Run the following command:

   mvn clean spring-boot:run

4. The application will start at:
   http://localhost:8080

---

## Notes

- This project is intended for learning and assignment purposes.
- REST APIs return appropriate HTTP status codes.
- Spring annotations are used for dependency injection and request handling.

---

## Author

Shambu Prasad Jakka
