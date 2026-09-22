# POS & COFFEE MANAGEMENT SYSTEM

A Point of Sale (POS) and coffee shop inventory management backend system built using **Domain-Driven Design (DDD)** and **Hexagonal Architecture (Ports & Adapters)**.

---

## ARCHITECTURE & DESIGN PRINCIPLES

This system applies **Hexagonal Architecture** to keep the *Domain Core* clean and framework-agnostic:

* **Domain Layer:** Contains Aggregate Roots, Entities, Value Objects, and Domain Events (Pure Java).
* **Application Layer:** Contains Use Cases / Command Handlers and Port Interfaces (Pure Java).
* **Adapter Layer (Primary & Secondary):** Contains REST Controllers, Mappers (MapStruct), JPA Repositories, and external integrations.

Cross-bounded context logic resolution is connected via loose coupling using **Domain & Integration Events**.

---

## BOUNDED CONTEXTS

1. **Account Context:** Manages user accounts, verification, and roles (`CUSTOMER`, `ADMIN`).
2. **Recipe Context:** Manages recipe formulas, portion sizes, and mapping to raw material SKUs.
3. **Inventory Context:** Tracks raw material stocks per branch, batch tracking, and handles the **FEFO (First-Expired, First-Out)** algorithm.
4. **Menu Catalog Context:** Master data for menu catalog and availability status (`Available` / `Not Available`).
5. **Branch Context:** Manages physical store branch data.
6. **Order Context:** Handles draft order creation, total calculation, and checkout.
7. **Payment Context:** Integrates payment gateways and payment transaction history.

---

## REST API ENDPOINTS LIST

*(Detailed request/response DTO schemas are managed separately in the OpenAPI/Swagger specification)*

### 1. Account Context
* `POST /accounts` — Register a new account
* `GET /accounts/{id}` — Get account profile details
* `PATCH /accounts/{id}/verify` — Verify account status
* `PATCH /accounts/{id}/suspend` — Suspend an account
* `PATCH /accounts/{id}/role` — Update user role

### 2. Recipe Context
* `POST /recipes` — Create a new recipe formula
* `GET /recipes` — Get recipe list
* `GET /recipes/{id}` — Get recipe details & raw materials (SKUs)
* `PUT /recipes/{id}` — Update main recipe info
* `POST /recipes/{id}/materials` — Add raw material (SKU) to a recipe
* `DELETE /recipes/{id}/materials/{sku}` — Remove raw material (SKU) from a recipe
* `DELETE /recipes/{id}` — Delete a recipe

### 3. Inventory Context
* `POST /inventory/items` — Record raw material stock arrival (FEFO Batch)
* `GET /inventory/items` — Get raw material stock list (Filter: `branchId`, `sku`)
* `GET /inventory/items/{id}` — Get details for a specific stock batch
* `POST /inventory/items/{id}/adjust` — Stock audit / waste adjustment
* `POST /inventory/items/{id}/restore` — Restore stock due to cancelled transaction
* `DELETE /inventory/items/{id}` — Delete a stock batch record

### 4. Menu Catalog Context
* `POST /menu-items` — Add a new menu item to master catalog
* `GET /menu-items` — Get menu catalog
* `GET /menu-items/{id}` — Get menu item details
* `PATCH /menu-items/{id}/price` — Update menu selling price
* `PATCH /menu-items/{id}/availability` — Toggle menu availability status
* `POST /menu-items/{id}/select` — Select menu item at POS
* `DELETE /menu-items/{id}` — Remove item from catalog

### 5. Branch Context
* `POST /branches` — Add a new branch
* `GET /branches` — Get branch list
* `GET /branches/{id}` — Get branch details
* `PUT /branches/{id}` — Update branch details

### 6. Order Context
* `POST /orders` — Create a new draft order
* `GET /orders/{id}` — Get order details and status
* `POST /orders/{id}/items` — Add item to order
* `DELETE /orders/{id}/items/{itemId}` — Remove item from order
* `POST /orders/{id}/checkout` — Process order checkout
* `POST /orders/{id}/cancel` — Cancel an order

### 7. Payment Context
* `POST /payments` — Initiate a new payment transaction session
* `GET /payments/{id}` — Check payment status
* `POST /payments/{id}/success` — Callback / mark payment as successful
* `POST /payments/{id}/fail` — Callback / mark payment as failed
* `POST /payments/{id}/refund` — Process refund

---

## TECH STACK & PREREQUISITES

* **Java:** 17+ / 21
* **Framework:** Spring Boot 3.x
* **Database:** MySQL 8.x
* **Database Migration:** Flyway
* **Mapper:** MapStruct

---

## HOW TO RUN THE APPLICATION

1. **Database Configuration:**
   Create a new database in MySQL:
   ```sql
   CREATE DATABASE pos_kopi_db;

```

2. **Set Environment Variable / Application Properties:**
Configure your database credentials in `src/main/resources/application.yml`:
```yaml
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/pos_kopi_db?useSSL=false&serverTimezone=UTC
    username: root
    password: your_password
  flyway:
    enabled: true

```


3. **Run the Application:**
Open a terminal in the root project directory and execute:
```bash
./mvnw spring-boot:run

```


*(Flyway will automatically run database schema migrations upon startup).*

