create table calendar
(
    id            bigint not null
        constraint calendar_pkey
            primary key,
    calendar_desc varchar(255),
    calendar_name varchar(255),
    schedule_url  varchar(255),
    group_id      bigint
        constraint fk_calendar_group
            references groups
);

create sequence calendar_id_seq;