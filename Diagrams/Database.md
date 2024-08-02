erDiagram
    FRANCHISE {
        int id PK
        string name
    }

    BRANCH {
        int id PK
        int franchise_id FK
        string name
    }

    PRODUCT {
        int id PK
        int branch_id FK
        string name
        int stock
    }

    FRANCHISE ||--o{ BRANCH : "has many"
    BRANCH ||--o{ PRODUCT : "has many"