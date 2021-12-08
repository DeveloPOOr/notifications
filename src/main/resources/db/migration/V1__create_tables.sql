CREATE TABLE project
(
    id          SERIAL PRIMARY KEY,
    name        VARCHAR(50) NOT NULL,
    description TEXT
);

CREATE TABLE employee
(
    id         SERIAL PRIMARY KEY,
    phone      TEXT,
    birthday   DATE        NOT NULL,
    start_work DATE        NOT NULL,
    city       VARCHAR(50) NOT NULL,
    project_id BIGINT      NOT NULL,
    FOREIGN KEY (project_id) REFERENCES project (id)
);

CREATE TABLE present
(
    id          SERIAL PRIMARY KEY,
    name        VARCHAR(50) NOT NULL,
    description TEXT,
    link        VARCHAR(255),
    employee_id BIGINT      NOT NULL,
    FOREIGN KEY (employee_id) REFERENCES employee (id)
);

CREATE TABLE notification
(
    id          SERIAL PRIMARY KEY,
    type        VARCHAR(15) NOT NULL,
    employee_id BIGINT      NOT NULL,
    FOREIGN KEY (employee_id) REFERENCES employee (id),
    CONSTRAINT valid_type CHECK (type = 'BIRTHDAY' OR type = 'ANNIVERSARY')
)