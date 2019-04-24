create sequence hibernate_sequence start 1 increment 1;

create table Clients
(
    id         integer not null auto_increment,
    e_mail     varchar(30),
    firstname  varchar(30),
    lastname   varchar(30),
    phone      varchar(15),
    id_country integer,
    primary key (id)
);
create table booking
(
    id         integer not null auto_increment,
    end_date   date,
    start_date date,
    id_client  integer,
    id_room    integer,
    primary key (id)
);
create table city
(
    id         integer not null auto_increment,
    city_name  varchar(30),
    id_country integer,
    primary key (id)
);
create table country
(
    id           integer not null auto_increment,
    country_name varchar(30),
    primary key (id)
);
create table hotel
(
    id         bigint not null auto_increment,
    adress     varchar(30),
    e_mail     varchar(30),
    hotel_name varchar(30),
    phone      varchar(15),
    id_city    integer,
    primary key (id)
);
create table room
(
    id           integer not null auto_increment,
    count_places integer,
    room_number  integer,
    id_hotel     bigint,
    id_room_type integer,
    primary key (id)
);
create table roomtype
(
    id   integer not null auto_increment,
    type varchar(30),
    primary key (id)
);
create table visa
(
    id         integer not null auto_increment,
    end_date   date,
    start_date date,
    id_client  integer,
    id_country integer,
    primary key (id)
);
alter table Clients
    add constraint FK_client_to_country foreign key (id_country) references country (id) ;
alter table booking
    add constraint FK_booking_to_client foreign key (id_client) references Clients (id);
alter table booking
    add constraint FK_booking_to_room foreign key (id_room) references room (id);
alter table city
    add constraint FK_city_to_country foreign key (id_country) references country (id) on DELETE CASCADE;
alter table hotel
    add constraint FK_hotel_to_city foreign key (id_city) references city (id) on DELETE CASCADE;
alter table room
    add constraint FK_room_to_hotel foreign key (id_hotel) references hotel (id) on DELETE CASCADE;
alter table room
    add constraint FK_room_to_roomtype foreign key (id_room_type) references roomtype (id);
alter table visa
    add constraint FK_visa_to_clients foreign key (id_client) references Clients (id);
alter table visa
    add constraint FK_visa_to_country foreign key (id_country) references country (id);