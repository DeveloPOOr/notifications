INSERT INTO users (username, password, enabled)
VALUES ('user1', '$2a$12$nxgoF8x6G3FNxoLw79DkMOwcsVII7QQ9HQVRdF2/xzCHCqAZwmDF.', true),
       ('user2', '$2a$12$nxgoF8x6G3FNxoLw79DkMOwcsVII7QQ9HQVRdF2/xzCHCqAZwmDF.', true),
       ('user3', '$2a$12$nxgoF8x6G3FNxoLw79DkMOwcsVII7QQ9HQVRdF2/xzCHCqAZwmDF.', true),
       ('user4', '$2a$12$nxgoF8x6G3FNxoLw79DkMOwcsVII7QQ9HQVRdF2/xzCHCqAZwmDF.', true),
       ('user5', '$2a$12$nxgoF8x6G3FNxoLw79DkMOwcsVII7QQ9HQVRdF2/xzCHCqAZwmDF.', true),
       ('user6', '$2a$12$nxgoF8x6G3FNxoLw79DkMOwcsVII7QQ9HQVRdF2/xzCHCqAZwmDF.', true),
       ('user7', '$2a$12$nxgoF8x6G3FNxoLw79DkMOwcsVII7QQ9HQVRdF2/xzCHCqAZwmDF.', true),
       ('user8', '$2a$12$nxgoF8x6G3FNxoLw79DkMOwcsVII7QQ9HQVRdF2/xzCHCqAZwmDF.', true),
       ('user9', '$2a$12$nxgoF8x6G3FNxoLw79DkMOwcsVII7QQ9HQVRdF2/xzCHCqAZwmDF.', true),
       ('user10', '$2a$12$nxgoF8x6G3FNxoLw79DkMOwcsVII7QQ9HQVRdF2/xzCHCqAZwmDF.', true);

INSERT INTO authorities(username, authority)
VALUES ('user1', 'ROLE_USER'),
       ('user2', 'ROLE_USER'),
       ('user3', 'ROLE_USER'),
       ('user4', 'ROLE_USER'),
       ('user5', 'ROLE_USER'),
       ('user6', 'ROLE_USER'),
       ('user7', 'ROLE_USER'),
       ('user8', 'ROLE_USER'),
       ('user9', 'ROLE_USER'),
       ('user10', 'ROLE_USER');

INSERT INTO employee (birthday, phone, start_work, full_name, city, username)
VALUES (DATE '2002-12-28', '+79992434271', DATE '2018-10-10', 'Zubenko Mikhail Petrovich1', 'London', 'user1'),
       (DATE '2002-12-26', '+79992434271', DATE '2018-10-10', 'Zubenko Mikhail Petrovich2', 'London', 'user2'),
       (DATE '2002-12-24', '+79992434271', DATE '2018-10-10', 'Zubenko Mikhail Petrovich3', 'London', 'user3'),
       (DATE '2002-10-28', '+79992434271', DATE '2018-10-10', 'Zubenko Mikhail Petrovich4', 'London', 'user4'),
       (DATE '2002-12-27', '+79992434271', DATE '2018-10-10', 'Zubenko Mikhail Petrovich5', 'London', 'user5'),
       (DATE '2002-09-28', '+79992434271', DATE '2002-12-24', 'Zubenko Mikhail Petrovich6', 'London', 'user6'),
       (DATE '2002-08-28', '+79992434271', DATE '2018-10-10', 'Zubenko Mikhail Petrovich7', 'London', 'user7'),
       (DATE '2002-12-28', '+79992434271', DATE '2018-10-10', 'Zubenko Mikhail Petrovich8', 'London', 'user8'),
       (DATE '2002-10-28', '+79992434271', DATE '2018-10-10', 'Zubenko Mikhail Petrovich9', 'London', 'user9'),
       (DATE '2002-10-28', '+79992434271', DATE '2002-12-24', 'Zubenko Mikhail Petrovich10', 'London', 'user10');

INSERT INTO project (name, description)
VALUES ('Just Tinkoff1', 'Just description1'),
       ('Just Tinkoff2', 'Just description2'),
       ('Just Tinkoff3', 'Just description3'),
       ('Just Tinkoff4', 'Just description4'),
       ('Just Tinkoff5', 'Just description5');

INSERT INTO employee_project_relationship (employee_id, project_id)
VALUES (1, 1),
       (2, 1),
       (3, 1),
       (1, 2),
       (4, 2),
       (5, 2),
       (6, 2),
       (7, 3),
       (8, 4),
       (9, 4),
       (10, 4);

INSERT INTO present (name, description, link, employee_id)
VALUES ('Present1', 'Description1', 'link1', 1),
       ('Present2', 'Description2', 'link2', 1),
       ('Present3', 'Description3', 'link3', 1),
       ('Present4', 'Description4', 'link4', 2),
       ('Present5', 'Description5', 'link5', 2),
       ('Present6', 'Description6', 'link6', 3),
       ('Present7', 'Description7', 'link7', 4),
       ('Present8', 'Description8', 'link8', 5),
       ('Present9', 'Description9', 'link9', 5),
       ('Present10', 'Description10', 'link10', 6),
       ('Present11', 'Description11', 'link11', 6),
       ('Present12', 'Description12', 'link12', 7),
       ('Present13', 'Description13', 'link13', 8),
       ('Present14', 'Description14', 'link14', 9),
       ('Present15', 'Description15', 'link15', 10),
       ('Present16', 'Description16', 'link16', 10);





