# Walmart USA – Advanced Software Engineering Virtual Experience Program

This repository showcases my work completed as part of the **Walmart USA Advanced Software Engineering Virtual Experience Program** on [Forage](https://www.theforage.com/), August 2025.  
The program simulated real-world software engineering challenges faced by Walmart’s engineering teams, covering **data structures, database design, and system modeling**.

---

## 📂 Project Overview

### **1. Heap Data Structure Implementation**
- Developed an optimized **heap** in Java for Walmart’s shipping department.
- Improved performance for priority-based shipment processing and load optimization.
- Demonstrated **algorithmic efficiency**, **problem-solving**, and **OOP design principles**.

### **2. UML Class Diagram**
- Designed a UML class diagram for a **data processor system**.
- Incorporated **multiple operating modes** and **database connection handling**.
- Ensured maintainable and scalable architecture aligned with system requirements.

### **3. Entity Relationship Diagram (ERD)**
- Created an ERD for Walmart’s **pet department database**.
- Modeled **products, manufacturers, customers, transactions, and shipments**.
- Ensured **normalization** and support for complex queries.

### **4. Database Integration & Data Population**
- Wrote a **Python script** to populate an SQLite database from shipping data spreadsheets.
- Implemented robust logic to avoid duplicate records and maintain **data integrity**.

---

## 🛠️ Tech Stack
- **Languages:** Java, Python
- **Database:** SQLite
- **Modeling Tools:** UML, ERD
- **Version Control:** Git

---

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
