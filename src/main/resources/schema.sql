CREATE DATABASE spring_jwt_practice;

CREATE TABLE app_users
(
    user_id   SERIAL PRIMARY KEY  NOT NULL,
    full_name VARCHAR(100) UNIQUE NOT NULL,
    email     VARCHAR(100) UNIQUE NOT NULL,
    password  VARCHAR(255)        NOT NULL
);

CREATE TABLE roles
(
    role_id SERIAL PRIMARY KEY NOT NULL,
    role_name    VARCHAR(50) UNIQUE NOT NULL
);

CREATE TABLE user_role
(
    user_id INT NOT NULL REFERENCES app_users (user_id) ON DELETE CASCADE ON UPDATE CASCADE,
    role_id INT NOT NULL REFERENCES roles (role_id) ON DELETE CASCADE ON UPDATE CASCADE,
    PRIMARY KEY (user_id, role_id)
);