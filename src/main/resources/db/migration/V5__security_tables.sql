-- Table: users
CREATE TABLE users
(
    id          SERIAL PRIMARY KEY,
    username    VARCHAR(255) NOT NULL,
    password    VARCHAR(255) NOT NULL,
    employee_id BIGINT       NOT NULL,
    FOREIGN KEY (employee_id) REFERENCES employee (id) ON DELETE CASCADE,
)


-- Table: roles
CREATE TABLE roles
(
    id   SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL
)


-- Table for mapping user and roles: user_roles
CREATE TABLE user_roles
(
    user_id INT NOT NULL,
    role_id INT NOT NULL,

    FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE,
    FOREIGN KEY (role_id) REFERENCES roles (id) ON DELETE CASCADE,

    UNIQUE (user_id, role_id)
)

INSERT INTO roles (name) VALUES ('USER_ROLE'), ('ADMIN_ROLE')