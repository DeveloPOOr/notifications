create table users
(
    username varchar(50)  not null primary key,
    password varchar(100) not null,
    enabled  boolean      not null
);
create table authorities
(
    username  varchar(50) not null,
    authority varchar(50) not null,
    constraint fk_authorities_users foreign key (username) references users (username)
);
create unique index ix_auth_username on authorities (username, authority);

insert into users(username, password, enabled)
values ('admin', '$2a$12$gfK44mBkw8e2HCli/nxqMuMSdseKhYf.nGVdKq8CdPHNe.UEy4wCu', true);
insert into authorities(username, authority)
values ('admin', 'ROLE_ADMIN');