# Student and Subject Management API

This project provides a REST API for managing students and subjects, including functionalities to create and fetch lists of students and subjects.

## Requirements

- Java 21
- Maven
- Spring Boot
- H2 Database (In-memory)
- Spring Security
### Accessing the H2 Database Console

1. **Start the application**.
2. **for opening the H2 Console**:
- Navigate to `http://localhost:8088/h2-console` in your web browser.
- driver class `org.h2.Driver`
- **Database URL**: `jdbc:h2:mem:testdb`
- **Username**: `sa`
- **Password**: 

### API Endpoints

**Base URL**
`http://localhost:8088`
- You can use postman to test these url
**Test Endpoint**
- **GET** `http://localhost:8088/test`
  - **Description**: Returns a test message.
  - **Response**: `"hi"`

**Student Endpoints**
- **POST** `http://localhost:8088/student/save`
  - **Description**: Save a new student.
  - **Request Body**:
    ```json
    {
      "name": "John Doe",
      "address": "123 Main St",
      "subjectIds": [1, 2, 3]
    }
    ```
  - **Response**:
    - **201 Created**: `"Student saved with id {id}"`
    - **500 Internal Server Error**: `"Error saving student: {error message}"`

- **GET** `http://localhost:8088/student/list`
  - **Description**: Get a list of all students.
  - **Response**:
    - **200 OK**: List of students
    - **500 Internal Server Error**

**Subject Endpoints**
- **POST** `http://localhost:8088/subject/save`
  - **Description**: Save a new subject.
  - **Request Body**:
    ```json
    {
      "name": "Mathematics"
    }
    ```
  - **Response**:
    - **200 OK**: `"saved subject with id {id}"`

- **GET** `http://localhost:8088/subject/list`
  - **Description**: Get a list of all subjects.
  - **Response**:
    - **200 OK**: List of subjects
## Things Not Completed

- **JWT-based Login**: Implementation of JWT-based authentication and authorization is not yet completed.
