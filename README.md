# TaskFlow Fullstack

A fullstack task management application built as a portfolio project for Java Backend / Werkstudent applications.

## Tech Stack

**Backend**
- Java 17
- Spring Boot 3
- Spring Web
- Spring Data JPA
- Spring Security
- H2 Database
- Bean Validation
- JUnit 5

**Frontend**
- React
- Vite
- JavaScript
- CSS

## Features

- Create, read, update and delete tasks
- Task status workflow: TODO, IN_PROGRESS, DONE
- Priority levels: LOW, MEDIUM, HIGH
- Search tasks by title
- Filter tasks by status
- Dashboard statistics
- Input validation
- Centralized error handling
- Clean layered architecture: controller, service, repository, DTO, model
- Unit tests for service layer
- API documentation with example requests

## Why this project is useful for applications

This project demonstrates practical skills required in many Werkstudent Backend / Fullstack roles:
REST APIs, database persistence, validation, error handling, tests, clean code structure and frontend-backend communication.

## Backend setup

```bash
cd backend
mvn spring-boot:run
```

Backend runs on:

```text
http://localhost:8080
```

H2 database console:

```text
http://localhost:8080/h2-console
```

JDBC URL:

```text
jdbc:h2:mem:taskflowdb
```

## Frontend setup

```bash
cd frontend
npm install
npm run dev
```

Frontend runs on:

```text
http://localhost:5173
```

## API Endpoints

| Method | Endpoint | Description |
|---|---|---|
| GET | `/api/tasks` | Get all tasks |
| GET | `/api/tasks/{id}` | Get task by id |
| POST | `/api/tasks` | Create task |
| PUT | `/api/tasks/{id}` | Update task |
| DELETE | `/api/tasks/{id}` | Delete task |
| GET | `/api/tasks/search?title=exam` | Search tasks |
| GET | `/api/tasks/status/TODO` | Filter by status |
| GET | `/api/tasks/stats` | Dashboard statistics |

## Example Request

```json
{
  "title": "Prepare Java portfolio",
  "description": "Finish GitHub project before applying",
  "status": "TODO",
  "priority": "HIGH",
  "dueDate": "2026-06-15"
}
```

## What to write in CV

**TaskFlow Fullstack** — Built a fullstack task management application using Java, Spring Boot, Spring Data JPA, H2, React and REST APIs. Implemented CRUD operations, validation, search/filter functionality, statistics endpoint and unit tests following a clean layered architecture.
