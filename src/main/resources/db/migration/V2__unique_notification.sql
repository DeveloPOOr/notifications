ALTER TABLE notification
    ADD CONSTRAINT unique_type_employee UNIQUE (type, employee_id);