CREATE TABLE IF NOT EXISTS users (
    id BIGINT PRIMARY KEY,
    username VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS user_products (
    id BIGINT PRIMARY KEY,
    account_number VARCHAR(255) UNIQUE NOT NULL,
    balance NUMERIC(15, 2) NOT NULL,
    product_type VARCHAR(50) NOT NULL CHECK (product_type IN ('счет', 'карта')),
    user_id BIGINT NOT NULL,
    CONSTRAINT fk_user FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE
);
