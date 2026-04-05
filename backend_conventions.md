# Backend Development Conventions & Context

This document serves as the "Source of Truth" for the Hoi An Cooking Class Backend project. It defines the architecture, patterns, and coding standards to ensure consistency across the codebase.

## Project Context
- **Project Name**: Hoi An Cooking Class
- **Domain**: Tourism/Education (Cooking classes, food tours, lantern & coffee workshops).
- **Frontend**: Next.js (located in `hoian-cooking-class-fe/hoian-cooking`).
- **Backend Stack**: Spring Boot 4.0.3, Java 21, Maven, PostgreSQL, Liquibase.

## Architecture Guidelines
- **Pattern**: Layered Architecture + Feature-based packaging (Modular).
- **Location**: `src/main/java/com/example/hoian_cooking`.
- **Packaging Structure**:
    - `common`: Shared infrastructure (exceptions, configs, utils, common DTOs).
    - `modules`: Business domains (e.g., `content`, `booking`, `identity`).
    - `security`: Security-specific code (JWT, Auth filters).
- **Layers within Modules**:
    - `controller`: API endpoints.
    - `service`: Business logic (Interface + `impl` package).
    - `repository`: Data access interfaces.
    - `model`: JPA Entities.
    - `dto`: Request and Response objects.

## Coding Standards
- **Naming Conventions**:
    - Classes: PascalCase.
    - Methods/Variables: camelCase.
    - Database Columns: snake_case (Liquibase).
    - API Endpoints: kebab-case (e.g., `/api/v1/page-contents`).
- **REST API Guidelines**:
    - Versioning: `/api/v1/...`.
    - Use proper HTTP verbs: GET (read), POST (create), PUT (update), DELETE (delete).
    - Wrap all responses in a standard `ApiResponse<T>` wrapper.
- **DTOs**:
    - Never expose Entities directly.
    - Use `Request` suffix for incoming data (e.g., `PageRequest`).
    - Use `Response` suffix for outgoing data (e.g., `PageResponse`).
- **Exception Handling**:
    - Use `GlobalExceptionHandler` to catch all exceptions.
    - Return a consistent error structure: `errorCode`, `message`, `details`.

## Database (Liquibase)
- Migrations are located in `src/main/resources/db/changelog/migrations`.
- Naming format: `XXX-description.sql` (e.g., `001-initial-schema.sql`).
- Always use `SERIAL` for IDs and `snake_case` for columns.

## Common Terms & Domain Model
- **Page**: A main landing page/category (Cooking Class, Food Tour, etc.).
- **PageContent**: Itineraries or small items within a tour.
- **Menu**: Dishes served in a class.
- **Image**: Media assets (Hero, Gallery, Content).

---
*Note: This file is a living document and should be updated as the project evolves.*
