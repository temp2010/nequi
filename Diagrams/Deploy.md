graph TD
    subgraph VPC
        direction TB
        ECSCluster[ECS Cluster]
        RDS[RDS PostgreSQL]

        ECSCluster -->|Contains| ECR[Elastic Container Registry]
        ECSCluster -->|Hosts| FranchiseAPI[franchise-api-1.1.jar]
        FranchiseAPI -->|Accesses| RDS
    end

    subgraph External
        direction TB
        User[User]
        Internet[Internet]
        ALB[Application Load Balancer]
        
        User -->|Requests| ALB
        ALB -->|Forwards requests| FranchiseAPI
    end

    Internet -- Connects to --> ALB
    ALB -- Routes to --> FranchiseAPI
    RDS -- Connects to --> FranchiseAPI

    style VPC fill:#f9f,stroke:#333,stroke-width:4px
    style External fill:#ccf,stroke:#333,stroke-width:4px