create table schedule
(
    id            bigint not null
        constraint schedule_pkey
            primary key,
    schedule_desc varchar(255),
    schedule_name varchar(255),
    schedule_url  varchar(255),
    group_id      bigint
        constraint fk_schedule_group
            references groups
);

create sequence schedule_id_seq;