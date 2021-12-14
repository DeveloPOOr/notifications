INSERT INTO project (name, description)
VALUES ('Тинькофф инвестиции', 'Про инвестиции'),
       ('Тинькофф банк', 'Про банк'),
       ('Тинькофф просто', 'Ну просто описание');

INSERT INTO employee (birthday, phone, start_work, full_name, city)
VALUES (DATE '2002-12-18', '+79992434271', DATE '2020-10-10', 'Зубенко Михаил Петрович', 'Лондон'),
       (DATE '2021-12-17', '+7122434271', DATE '2020-10-10', 'Зубенко Людмила Петровна', 'Милан'),
       (DATE '2007-10-10', '+7122434271', DATE '2020-10-10', 'Зубенко Петр Николаевич', 'Тугулым'),
       (DATE '2007-10-10', '+7122434271', DATE '2020-10-10', 'Фио4', 'Тугулым');

INSERT INTO employee_project_relationship (employee_id, project_id)
VALUES (1, 1),
       (2, 1),
       (3, 2),
       (4, 3);

INSERT INTO present (name, link, description, employee_id)
VALUES ('Подарок1', 'ссылка1', 'описание1', 1),
       ('Подарок2', 'ссылка2', 'описание2', 1),
       ('Подарок3', 'ссылка3', 'описание3', 1),
       ('Подарок4', 'ссылка4', 'описание4', 2),
       ('Подарок5', 'ссылка5', 'описание5', 2),
       ('Подарок6', 'ссылка6', 'описание6', 3);


-- INSERT INTO notification (type, employee_id)
-- VALUES ('BIRTHDAY', 1),
--        ('BIRTHDAY', 2),
--        ('ANNIVERSARY', 3),
--        ('ANNIVERSARY', 3);