drop table IF EXISTS employee_project_relationship;

drop table IF EXISTS project;

drop table IF EXISTS present;

drop table IF EXISTS colleague_notification;

drop table IF EXISTS notification;

drop table IF EXISTS employee;

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
    full_name  VARCHAR(100) NOT NULL,
    birthday   DATE         NOT NULL,
    start_work DATE         NOT NULL,
    city       VARCHAR(50)  NOT NULL
);
CREATE TABLE employee_project_relationship
(
    employee_id BIGINT,
    project_id  BIGINT,
    FOREIGN KEY (employee_id) REFERENCES employee (id) ON DELETE CASCADE,
    FOREIGN KEY (project_id) REFERENCES project (id) ON DELETE CASCADE,
    UNIQUE (employee_id, project_id)
);
CREATE TABLE present
(
    id          SERIAL PRIMARY KEY,
    name        VARCHAR(50) NOT NULL,
    description TEXT,
    link        VARCHAR(255),
    employee_id BIGINT      NOT NULL,
    FOREIGN KEY (employee_id) REFERENCES employee (id) ON DELETE CASCADE
);
CREATE TABLE notification
(
    id          SERIAL PRIMARY KEY,
    type        VARCHAR(15) NOT NULL,
    employee_id BIGINT      NOT NULL,
    FOREIGN KEY (employee_id) REFERENCES employee (id) ON DELETE CASCADE,
    CONSTRAINT valid_type CHECK (type = 'BIRTHDAY' OR type = 'ANNIVERSARY')
);