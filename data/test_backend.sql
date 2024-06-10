create database if not exists test_backend;

use test_backend;

create table if not exists header
(
    id            varchar(255) not null
    primary key,
    tanggal_awal  date         not null,
    tanggal_akhir date         not null,
    nominal       double       not null,
    constraint header_id_uindex
    unique (id)
    );

create table if not exists detail
(
    id            varchar(255) not null
        primary key,
    tanggal_awal  date         not null,
    tanggal_akhir date         null,
    nominal       double       not null,
    header_id     varchar(255) not null,
    constraint detail_id_uindex
        unique (id)
);