ALTER TABLE employee
    ADD username VARCHAR(255);
ALTER TABLE employee
    ADD CONSTRAINT fk_username FOREIGN KEY (username) REFERENCES users (username) ON DELETE CASCADE;