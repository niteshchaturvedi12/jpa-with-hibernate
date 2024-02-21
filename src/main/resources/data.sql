create table person (
    id integer not null,
    name VARCHAR(255) NOT NULL,
    location varchar(255),
    birth_date timestamp,
    primary key(id)
);
insert into person (id, name, location, birth_date) values (10001, 'Nitesh', 'Jaipur', CURRENT_TIMESTAMP());
insert into person (id, name, location, birth_date) values (10002, 'Khushbu', 'Sawai Madhopur', CURRENT_TIMESTAMP());
insert into person (id, name, location, birth_date) values (10003, 'Rishabh', 'Indore', CURRENT_TIMESTAMP());
insert into person (id, name, location, birth_date) values (10004, 'Neelu', 'Niwai', CURRENT_TIMESTAMP());
insert into person (id, name, location, birth_date) values (10005, 'Nitesh', 'Deoli', CURRENT_TIMESTAMP());