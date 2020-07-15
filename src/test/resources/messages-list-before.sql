delete from message;

insert into message(id, text) values
(1, 'first'),
(2, 'second'),
(3, 'third'),
(4, 'fourth');

alter sequence hibernate_sequence restart with 10;