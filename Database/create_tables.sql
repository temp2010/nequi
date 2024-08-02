-- Table for Franchise
CREATE TABLE franchise (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL
);

-- Table for Branch
CREATE TABLE branch (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    franchise_id INT NOT NULL,
    FOREIGN KEY (franchise_id) REFERENCES franchise(id) ON DELETE CASCADE
);

-- Table for Product
CREATE TABLE product (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    stock INT NOT NULL,
    branch_id INT NOT NULL,
    FOREIGN KEY (branch_id) REFERENCES branch(id) ON DELETE CASCADE
);