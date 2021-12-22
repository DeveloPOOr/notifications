CREATE TABLE colleague_notification
(
    id              SERIAL PRIMARY KEY,
    notification_id BIGINT,
    colleague_id    BIGINT,
    FOREIGN KEY (notification_id) REFERENCES notification (id) ON DELETE CASCADE,
    FOREIGN KEY (colleague_id) REFERENCES employee (id) ON DELETE CASCADE,
    CONSTRAINT unique_notification_colleague UNIQUE (notification_id, colleague_id)
);