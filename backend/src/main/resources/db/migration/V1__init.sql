CREATE TABLE roles (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(50) NOT NULL UNIQUE
);

CREATE TABLE users (
    id BIGSERIAL PRIMARY KEY,
    username VARCHAR(100) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    enabled BOOLEAN NOT NULL DEFAULT TRUE,
    role_id BIGINT NOT NULL,
    CONSTRAINT fk_user_role
        FOREIGN KEY (role_id)
        REFERENCES roles(id)
);

INSERT INTO roles (name) VALUES ('ADMIN');
INSERT INTO roles (name) VALUES ('USER');

CREATE TABLE products (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    sku VARCHAR(100) NOT NULL UNIQUE,
    barcode VARCHAR(100) UNIQUE,
    purchase_price DECIMAL(10,2) NOT NULL,
    sale_price DECIMAL(10,2) NOT NULL,
    stock_quantity INTEGER NOT NULL,
    alert_threshold INTEGER NOT NULL,
    category VARCHAR(255),
    description TEXT
);

CREATE TABLE customers (
    id BIGSERIAL PRIMARY KEY,
    first_name VARCHAR(255) NOT NULL,
    last_name VARCHAR(255) NOT NULL,
    email VARCHAR(255) UNIQUE,
    phone VARCHAR(50),
    company VARCHAR(255),
    address VARCHAR(255),
    city VARCHAR(255),
    postal_code VARCHAR(20),
    country VARCHAR(100)
);

CREATE TABLE suppliers (
    id BIGSERIAL PRIMARY KEY,
    company_name VARCHAR(255) NOT NULL,
    contact_name VARCHAR(255),
    email VARCHAR(255) UNIQUE,
    phone VARCHAR(50),
    address VARCHAR(255),
    city VARCHAR(255),
    postal_code VARCHAR(20),
    country VARCHAR(100)
);

INSERT INTO roles (name) VALUES ('ADMIN');
INSERT INTO roles (name) VALUES ('USER');

INSERT INTO users (
    username,
    password,
    email,
    enabled,
    role_id
)
VALUES (
    'admin',
    '$2a$10$7EqJtq98hPqEX7fNZaFWoOHiH6L6VQ0m1Y9D4V7R2xQ4f3FvQ3i5K',
    'admin@erp.com',
    TRUE,
    1
);
