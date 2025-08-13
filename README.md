# Walmart Logistics & Retail Data Platform Development

This repository contains my work for the **Walmart Logistics & Retail Data Platform**, developed as part of a simulated real-world engineering project.  
The platform streamlines **shipment prioritization** for logistics operations and provides a **centralized retail database** for Walmart's pet department.  

---

## 🚀 Project Overview

### **1. Logistics Shipment Prioritization Engine**
- Implemented an **optimized heap data structure** in Java for shipment load balancing and priority scheduling.
- Designed for **fast retrieval** of high-priority shipments, reducing delays in logistics workflows.

### **2. Data Processor System Architecture**
- Created a **UML class diagram** for a modular data processor.
- Supported multiple operating modes and seamless database connectivity for scalable data handling.

### **3. Retail Product Database**
- Designed an **Entity Relationship Diagram (ERD)** for Walmart's pet department.
- Modeled manufacturers, products, customers, transactions, and shipments with **full normalization**.

### **4. Automated Data Ingestion**
- Developed a **Python ETL script** to populate an SQLite database from shipping data spreadsheets.
- Enforced **data integrity**, avoided duplicates, and logged import operations.

---

## 🛠️ Tech Stack
- **Languages:** Java, Python
- **Database:** SQLite
- **Design Tools:** UML, ERD
- **Version Control:** Git

---

## Showcase

### UML Class Diagram
```mermaid
---
id: 130fc9b4-9bcc-4b2f-abc8-5ca6227ccae4
---
classDiagram
    %% Main relationships
    Processor "1" --> "1" ModeIdentifier : uses
    Processor "1" --> "1" DatabaseIdentifier : uses
    Processor "1" --> "1" DatabaseHandler : has
    Processor ..> Datapoint : processes
    
    %% Database handler relationships
    DatabaseHandler <|.. PostgresHandler : implements
    DatabaseHandler <|.. RedisHandler : implements
    DatabaseHandler <|.. ElasticHandler : implements
    
    %% Database handlers work with datapoints
    PostgresHandler ..> Datapoint : operates on
    RedisHandler ..> Datapoint : operates on
    ElasticHandler ..> Datapoint : operates on

    %% Given classes (provided in requirements)
    class Datapoint {
        <<given class>>
        - data: Object
        + getData(): Object
        + setData(data: Object): void
    }

    class ModeIdentifier {
        <<enumeration>>
        DUMP
        PASSTHROUGH
        VALIDATE
    }

    class DatabaseIdentifier {
        <<enumeration>>
        POSTGRES
        REDIS
        ELASTIC
    }

    %% Main processor class
    class Processor {
        - currentMode: ModeIdentifier
        - currentDatabase: DatabaseIdentifier
        - databaseHandler: DatabaseHandler
        + configure(mode: ModeIdentifier, db: DatabaseIdentifier): void
        + process(datapoint: Datapoint): void
        - createDatabaseHandler(db: DatabaseIdentifier): DatabaseHandler
    }

    %% Database handler interface
    class DatabaseHandler {
        <<interface>>
        + connect(): void
        + insert(datapoint: Datapoint): void
        + validate(datapoint: Datapoint): boolean
    }

    %% Concrete database implementations
    class PostgresHandler {
        - connectionString: String
        - connection: Connection
        + connect(): void
        + insert(datapoint: Datapoint): void
        + validate(datapoint: Datapoint): boolean
    }

    class RedisHandler {
        - host: String
        - port: int
        - client: RedisClient
        + connect(): void
        + insert(datapoint: Datapoint): void
        + validate(datapoint: Datapoint): boolean
    }

    class ElasticHandler {
        - endpoint: String
        - index: String
        - client: ElasticClient
        + connect(): void
        + insert(datapoint: Datapoint): void
        + validate(datapoint: Datapoint): boolean
    }
```

### Entity Relationship Diagram
![ERD](https://github.com/jayanthmani8045/WalmartGlobalTechASE/blob/main/Task%203%20ERD/ERD.png?raw=true)

---
