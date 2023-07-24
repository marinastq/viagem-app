-- This file allow to write SQL commands that will be emitted in test and dev.
-- The commands are commented as their support depends of the database
-- insert into myentity (id, field) values(1, 'field-1');
-- insert into myentity (id, field) values(2, 'field-2');
-- insert into myentity (id, field) values(3, 'field-3');
-- alter sequence myentity_seq restart with 4;
/*
CREATE SEQUENCE HIBERNATE_SEQUENCE START WITH 10 INCREMENT BY 1;
insert into CLIENTE (id, nome) values(nextval('HIBERNATE_SEQUENCE'), 'Joao');
insert into CLIENTE (id, nome) values(nextval('HIBERNATE_SEQUENCE'), 'Maria');
insert into CLIENTE (id, nome) values(nextval('HIBERNATE_SEQUENCE'), 'Jose');
insert into CLIENTE (id, nome) values(nextval('HIBERNATE_SEQUENCE'), 'Ana'); 
insert into CLIENTE (id, nome) values(nextval('HIBERNATE_SEQUENCE'), 'Elsa');
*/

insert into CLIENTE (id, nome) values(1, 'Joao');
insert into CLIENTE (id, nome) values(2, 'Maria');
insert into CLIENTE (id, nome) values(3, 'Jose');
insert into CLIENTE (id, nome) values(4, 'Ana');
insert into CLIENTE (id, nome) values(5, 'Elsa');

alter sequence cliente_seq  restart with 6;
